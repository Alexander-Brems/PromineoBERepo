package student.college.controller.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import student.college.entity.Class;
import student.college.entity.Student;

@Data
@NoArgsConstructor
public class CollegeStudent {
	
	private Integer studentID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	
	private Set<CollegeClass> classes = new HashSet<>();
	
	public CollegeStudent(Student newStudent) {
		this.setStudentID(newStudent.getStudentID());
		this.setFirstName(newStudent.getFirstName());
		this.setLastName(newStudent.getLastName());
		this.setPhoneNumber(newStudent.getPhoneNumber());
		this.setEmail(newStudent.getEmail());
		for(Class newClass : newStudent.getClasses()) {
			this.classes.add(new CollegeClass(newClass));
		}
	}
}
