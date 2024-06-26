package projects.service;

import projects.entity.Project;
import projects.exception.DbException;

import java.util.List;
import java.util.NoSuchElementException;

import projects.dao.ProjectDao;

public class ProjectService {

	private ProjectDao projDao = new ProjectDao();

	public Project addProject(Project project) {
		return projDao.insertProject(project);
	}

	public List<Project> fetchAllProjects() {
		return projDao.fetchAllProjects();
	}

	public Project fetchProjectByID(Integer projectID) {
		return projDao.fetchProjectByID(projectID).orElseThrow(() -> new NoSuchElementException("The project ID of " + projectID + " does not exist."));
	}

	public void deleteProject(Integer projectID) {
		if(!projDao.deleteProject(projectID)) {
			throw new DbException("Project ID = " + projectID + " does not exist.");
		}
		
	}

	public void updateProjectData(Project newProject) {
		if(!projDao.updateProjectData(newProject)) {
			throw new DbException("Project ID = " +newProject.getProjectId() + " does not exist.");
		}
		
	}

}
