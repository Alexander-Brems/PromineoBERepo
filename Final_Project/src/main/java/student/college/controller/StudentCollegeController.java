package student.college.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import student.college.controller.model.CollegeClass;
import student.college.controller.model.CollegeProfessor;
import student.college.controller.model.CollegeStudent;
import student.college.service.StudentCollegeService;

@RestController
@RequestMapping("/college")
@Slf4j
public class StudentCollegeController {

	@Autowired
	private StudentCollegeService collegeService;
	
	@GetMapping("/class")
	public List<CollegeClass> getAllClasses() {
		log.info("Retrieving All Classes.");
		return collegeService.retrieveAllClasses();
	}
	
	@PostMapping("/class/{teacherID}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public CollegeClass insertCollegeCourse(@PathVariable Integer teacherID, @RequestBody CollegeClass classData) {
		log.info("Creating Class {}", classData);
		return collegeService.saveCollegeClass(classData, teacherID);
	}
	
	@PutMapping("/class/{classID}")
	public CollegeClass updateCollegeCourse(@PathVariable Integer classID, @RequestBody CollegeClass classData) {
		classData.setClassID(classID);
		Integer teacherID = classData.getTeacher().getProfessorID();
		log.info("Updating Class {}", classData);
		return collegeService.saveCollegeClass(classData, teacherID);
	}
	
	@DeleteMapping("class/{classID}")
	public Map<String, String> deleteClassByID(@PathVariable Integer classID) {
		log.info("Deleting Class {}", classID);
		collegeService.deleteClassByID(classID);
		return Map.of("message", "Class = " + classID + " successfully deleted.");
	}
	
	@GetMapping("/student")
	public List<CollegeStudent> getAllStudents() {
		log.info("Retrieving all Students");
		return collegeService.retrieveAllStudents();
	}
	
	@GetMapping("/student/{studentID}")
	public CollegeStudent getStudentDetails(@PathVariable Integer studentID) {
		log.info("Retrieving Student {}", studentID);
		return collegeService.retrieveStudentDetails(studentID);
	}
	
	@PostMapping("/student")
	@ResponseStatus(code = HttpStatus.CREATED)
	public CollegeStudent insertCollegeStudent(@RequestBody CollegeStudent studentData) {
		log.info("Creating Student {}", studentData);
		return collegeService.saveStudent(studentData);
	}
	
	@PutMapping("/student/{studentID}")
	public CollegeStudent updateCollegeStudent(@PathVariable Integer studentID, @RequestBody CollegeStudent studentData) {
		studentData.setStudentID(studentID);
		log.info("Updating Student {}", studentData);
		return collegeService.saveStudent(studentData);
	}
	
	@GetMapping("/teacher")
	public List<CollegeProfessor> getAllProfessors() {
		log.info("Retrieving All Professors.");
		return collegeService.retrieveAllProfessors();
	}
	
	@PostMapping("/teacher")
	@ResponseStatus(code = HttpStatus.CREATED)
	public CollegeProfessor insertCollegeProfessor(@RequestBody CollegeProfessor teacherData) {
		log.info("Creating Professor {}", teacherData);
		return collegeService.saveProfessor(teacherData);
	}
}
