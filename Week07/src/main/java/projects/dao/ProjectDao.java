package projects.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import projects.entity.Project;
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

}
