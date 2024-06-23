package projects.service;

import projects.entity.Project;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

}
