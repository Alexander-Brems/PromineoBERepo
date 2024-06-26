package projects;

import java.math.BigDecimal;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import projects.entity.Project;
import projects.exception.DbException;
import projects.service.ProjectService;

//import projects.dao.DbConnection;

public class ProjectsApp {

	//setup some initial variables
	// @formatter:off
	private List<String> operations = List.of(
			"1) Add a project",
			"2) List all projects",
			"3) Select a project",
			"4) Update project details",
			"5) Delete a project"
			);
	// @formatter:on
	private Scanner scan = new Scanner(System.in);
	private ProjectService projServe = new ProjectService();
	private Project currentProject;
	
	
	
	//main here
	public static void main(String[] args) {
		
		//DbConnection.getConnection();
		
		new ProjectsApp().processUserSelections();

	}
	
	
	
	//functions down here
	private void processUserSelections() {
		boolean complete = false;
		
		while(!complete) {
			try {
				int selection = getUserSelection();
				
				switch(selection) {
				case -1:
					complete = endMenu();
					break;
					
				case 1:
					createProject();
					break;
					
				case 2:
					listAllProjects();
					break;
					
				case 3:
					selectProject();
					break;
				
				case 4:
					updateProjectDetails();
					break;
					
				case 5:
					deleteProject();
					break;
					
				default:
					System.out.println("\n'" + selection + "' is not a valid option. Please try again.");
				}
				
			} catch(Exception e) {
				System.out.println("\nError: " + e + " Try again.");
				e.printStackTrace();
			}
		}
		
	}

	private void deleteProject() {
		listAllProjects();
		
		Integer projectID = getIntInput("Enter the ID of the project to delete");
		
		projServe.deleteProject(projectID);
		System.out.println("Project " + projectID + " was deleted successfully.");
		
		if(Objects.nonNull(currentProject) && currentProject.getProjectId().equals(projectID)) {
			currentProject = null;
		}
		
	}



	private void updateProjectDetails() {
		if(Objects.isNull(currentProject)) {
			System.out.println("There is no project currently selected.");
			return;
		}
		
		String projectName = getStringInput("Enter the new project name to replace [" + currentProject.getProjectName() + "]");
		BigDecimal estHours = getDecimalInput("Enter the new estimated hours to replace [" + currentProject.getEstimatedHours() + "]");
		BigDecimal actHours = getDecimalInput("Enter the new actual hours to replace [" + currentProject.getActualHours() + "]");
		Integer difficulty = getIntInput("Enter the new difficulty to replace [" + currentProject.getDifficulty() + "]");
		String notes = getStringInput("Enter the new set of notes to replace [" + currentProject.getNotes() + "]");
		
		Project newProject = new Project();
		
		newProject.setProjectId(currentProject.getProjectId());
		newProject.setProjectName(Objects.isNull(newProject) ? currentProject.getProjectName() : projectName);
		newProject.setEstimatedHours(Objects.isNull(estHours) ? currentProject.getEstimatedHours() : estHours);
		newProject.setActualHours(Objects.isNull(actHours) ? currentProject.getActualHours() : actHours);
		newProject.setDifficulty(Objects.isNull(difficulty) ? currentProject.getDifficulty() : difficulty);
		newProject.setNotes(Objects.isNull(notes) ? currentProject.getNotes() : notes);
		
		projServe.updateProjectData(newProject);
		
		currentProject = projServe.fetchProjectByID(currentProject.getProjectId());
	}



	private void selectProject() {
		listAllProjects();
		Integer projID = getIntInput("Enter a project ID to select it");
		
		//we clear the current project first just in case the fetch throws an exception
		currentProject = null;
		currentProject = projServe.fetchProjectByID(projID);
	}



	private void listAllProjects() {
		List<Project> projects = projServe.fetchAllProjects();
		
		System.out.println("\nProjects:");
		
		for(Project project : projects) {
			System.out.println("   " + project.getProjectId() + ": " + project.getProjectName());
		}
	}



	private void createProject() {
		String name = getStringInput("Enter the project Name: ");
		BigDecimal estHours = getDecimalInput("Enter the estimated hours: ");
		BigDecimal actHours = getDecimalInput("Enter the actual hours: ");
		Integer difficulty = getIntInput("Enter the project's difficulty, where 5 is the most difficult and 1 is the least: ");
		String notes = getStringInput("Enter any notes for the project: ");
		
		Project project = new Project();
		
		project.setProjectName(name);
		project.setEstimatedHours(estHours);
		project.setActualHours(actHours);
		project.setDifficulty(difficulty);
		project.setNotes(notes);
		
		Project dbProject = projServe.addProject(project);
		System.out.println("You have successfully created a project: " + dbProject);
		
	}

	private BigDecimal getDecimalInput(String input) {
		String value = getStringInput(input);
		
		if (Objects.isNull(value)) {
			return null;
		}
		
		try {
			return new BigDecimal(value).setScale(2);
		} catch (NumberFormatException e) {
			throw new DbException("'" + value + "' is not a valid decimal number.");
		}
	}

	private boolean endMenu() {
		System.out.println("Exiting the menu.");
		return true;
	}

	private int getUserSelection() {
		printOperations();
		
		Integer input = getIntInput("Enter a menu selection.");
		
		return Objects.isNull(input) ? -1 : input;
	}

	private Integer getIntInput(String input) {
		String value = getStringInput(input);
		
		if(Objects.isNull(value)) {
			return null;
		}
		
		try {
			return Integer.valueOf(value);
		} catch(NumberFormatException e) {
			throw new DbException("'" + value + "' is not a valid number.");
		}
	}

	private String getStringInput(String input) {
		System.out.print(input + ": ");
		String userInput = scan.nextLine();
		return userInput.isBlank() ? null : userInput.trim();
	}

	private void printOperations() {
		System.out.println("\nThese are the available selections. Press the Enter key to close the program.");
		for (String option : operations) {
			System.out.println("    " + option);
		}
		if(Objects.isNull(currentProject)) {
			System.out.println("\nYou have no currently selected project.");
		}
		else {
			System.out.println("\nYou are currently working with project: " + currentProject);
		}
	}

}
