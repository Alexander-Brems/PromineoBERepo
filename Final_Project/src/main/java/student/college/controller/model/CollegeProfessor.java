package student.college.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import student.college.entity.Professor;

@Data
@NoArgsConstructor
public class CollegeProfessor {
	
	private Integer professorID;
	private String firstName;
	private String lastName;
	private String department;
	private Boolean hasTenure;
	private String phoneNumber;
	private String email;
	
	public CollegeProfessor(Professor newProf) {
		this.setProfessorID(newProf.getProfessorID());
		this.setFirstName(newProf.getFirstName());
		this.setLastName(newProf.getLastName());
		this.setDepartment(newProf.getDepartment());
		this.setHasTenure(newProf.getHasTenure());
		this.setPhoneNumber(newProf.getPhoneNumber());
		this.setEmail(newProf.getEmail());
	}
}
