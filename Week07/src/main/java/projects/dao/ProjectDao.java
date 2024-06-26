package projects.dao;

import java.math.BigDecimal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import projects.entity.Category;
import projects.entity.Material;
import projects.entity.Project;
import projects.entity.Step;
import projects.exception.DbException;

import provided.util.DaoBase;

public class ProjectDao extends DaoBase {

	//setup some constants for each table in the database
	private static final String CATEGORY_TABLE = "category";
	private static final String MATERIAL_TABLE = "material";
	private static final String PROJECT_TABLE = "project";
	private static final String PROJECT_CATEGORY_TABLE = "project_category";
	private static final String STEP_TABLE = "step";

	
	
	//functions here
	public Project insertProject(Project project) {
		//@formatter:off
		String sqlStatement = "" +
				"INSERT INTO " + PROJECT_TABLE + " " +
				"(project_name, estimated_hours, actual_hours, difficulty, notes) " +
				"VALUES " + 
				"(?, ?, ?, ?, ?)";
		//@formatter:on
		
		try(Connection link = DbConnection.getConnection()) {
			startTransaction(link);
			
			try(PreparedStatement prepState = link.prepareStatement(sqlStatement)) {
				setParameter(prepState, 1, project.getProjectName(), String.class);
				setParameter(prepState, 2, project.getEstimatedHours(), BigDecimal.class);
				setParameter(prepState, 3, project.getActualHours(), BigDecimal.class);
				setParameter(prepState, 4, project.getDifficulty(), Integer.class);
				setParameter(prepState, 5, project.getNotes(), String.class);
				
				prepState.executeUpdate();
				
				Integer projId = getLastInsertId(link, PROJECT_TABLE);
				commitTransaction(link);
				
				project.setProjectId(projId);
				return project;
				
			} catch(Exception e) {
				rollbackTransaction(link);
				throw new DbException(e);
			}
		} catch(SQLException e) {
			throw new DbException(e);
		}
	}



	public List<Project> fetchAllProjects() {
		String sqlStatement = "SELECT * FROM " + PROJECT_TABLE + " ORDER BY project_name";
		try(Connection link = DbConnection.getConnection()) {
			startTransaction(link);
			
			try(PreparedStatement prepState = link.prepareStatement(sqlStatement)) {
				try(ResultSet rs = prepState.executeQuery()) {
					List<Project> projects = new LinkedList<>();
					
					while(rs.next()) {
						projects.add(extract(rs, Project.class));
					}
					return projects;
				}
				
			} catch(Exception e) {
				rollbackTransaction(link);
				throw new DbException(e);
			}
		} catch(SQLException e) {
			throw new DbException(e);
		}
	}



	public Optional<Project> fetchProjectByID(Integer projectID) {
		String sqlStatement = "SELECT * FROM " + PROJECT_TABLE + " WHERE project_id = ?";
		try(Connection link = DbConnection.getConnection()) {
			startTransaction(link);
			
			try {
				Project currentProject = null;
				
				try(PreparedStatement prepState = link.prepareStatement(sqlStatement)) {
					
					setParameter(prepState, 1, projectID, Integer.class);
					
					try (ResultSet rs = prepState.executeQuery()) {
						if(rs.next()) {
							currentProject = extract(rs, Project.class);
						}
					}
				}
				
				if(Objects.nonNull(currentProject)) {
					currentProject.getMaterials().addAll(fetchMaterialForProject(link, projectID));
					currentProject.getSteps().addAll(fetchStepsForProject(link, projectID));
					currentProject.getCategories().addAll(fetchCategoriesForProject(link, projectID));
				}
				
				commitTransaction(link);
				return Optional.ofNullable(currentProject);
				
			} catch(Exception e) {
				rollbackTransaction(link);
				throw new DbException(e);
			}
		} catch(SQLException e) {
			throw new DbException(e);
		}
	}



	private List<Category> fetchCategoriesForProject(Connection link, Integer projectID) throws SQLException {
		//@formatter:off
		String sql = ""
				+ "SELECT c.* FROM " + CATEGORY_TABLE + " c "
				+ "JOIN " + PROJECT_CATEGORY_TABLE + " pc USING (category_id)"
				+ "WHERE project_id = ?";
		//@formatter:on
		try(PreparedStatement prepState = link.prepareStatement(sql)) {
			setParameter(prepState, 1, projectID, Integer.class);
			
			try(ResultSet rs = prepState.executeQuery()) {
				List<Category> categories = new LinkedList<>();
				while(rs.next()) {
					categories.add(extract(rs, Category.class));
				}
				return categories;
			}
		}
	}



	private List<Step> fetchStepsForProject(Connection link, Integer projectID) throws SQLException {
		//@formatter:off
		String sql = "SELECT * FROM " + STEP_TABLE + " WHERE project_id = ?";
		//@formatter:on
		try(PreparedStatement prepState = link.prepareStatement(sql)) {
			setParameter(prepState, 1, projectID, Integer.class);
			
			try(ResultSet rs = prepState.executeQuery()) {
				List<Step> steps = new LinkedList<>();
				while(rs.next()) {
					steps.add(extract(rs, Step.class));
				}
				return steps;
			}
		}
	}



	private List<Material> fetchMaterialForProject(Connection link, Integer projectID) throws SQLException {
		//@formatter:off
		String sql = "SELECT * FROM " + MATERIAL_TABLE + " WHERE project_id = ?";
		//@formatter:on
		try(PreparedStatement prepState = link.prepareStatement(sql)) {
			setParameter(prepState, 1, projectID, Integer.class);
			
			try(ResultSet rs = prepState.executeQuery()) {
				List<Material> materials = new LinkedList<>();
				while(rs.next()) {
					materials.add(extract(rs, Material.class));
				}
				return materials;
			}
		}
	}
	
	
	public boolean deleteProject(Integer projectID) {
		String sqlState = ""
				+ "DELETE FROM " + PROJECT_TABLE
				+ " WHERE project_id = ?;";
		
		try(Connection link = DbConnection.getConnection()) {
			startTransaction(link);
			
			try(PreparedStatement prepState = link.prepareStatement(sqlState)) {
				setParameter(prepState, 1, projectID, Integer.class);
				
				boolean deleted = !prepState.execute();
				commitTransaction(link);
				return deleted;
				
			
			} catch(Exception e) {
				rollbackTransaction(link);
				return false;
			}
		} catch(SQLException e) {
			throw new DbException(e);
		}
	}



	public boolean updateProjectData(Project newProject) {
		String sqlState = ""
				+ "UPDATE " + PROJECT_TABLE + " SET "
				+ "project_name = ?, "
				+ "estimated_hours = ?, "
				+ "actual_hours = ?, "
				+ "difficulty = ?, "
				+ "notes = ? "
				+ "WHERE project_id = ?";
		
		try(Connection link = DbConnection.getConnection()) {
			startTransaction(link);
			
			try(PreparedStatement prepState = link.prepareStatement(sqlState)) {
				setParameter(prepState, 1, newProject.getProjectName(), String.class);
				setParameter(prepState, 2, newProject.getEstimatedHours(), BigDecimal.class);
				setParameter(prepState, 3, newProject.getActualHours(), BigDecimal.class);
				setParameter(prepState, 4, newProject.getDifficulty(), Integer.class);
				setParameter(prepState, 5, newProject.getNotes(), String.class);
				setParameter(prepState, 6, newProject.getProjectId(), Integer.class);
				
				boolean updated = prepState.executeUpdate() == 1;
				commitTransaction(link);
				return updated;
				
			
			} catch(Exception e) {
				rollbackTransaction(link);
				throw new DbException(e);
			}
		} catch(SQLException e) {
			throw new DbException(e);
		}
	}

}
