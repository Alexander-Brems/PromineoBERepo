package projects.service;

import projects.entity.Project;
import projects.dao.ProjectDao;

public class ProjectService {

	private ProjectDao projDao = new ProjectDao();

	public Project addProject(Project project) {
		return projDao.insertProject(project);
	}

}
