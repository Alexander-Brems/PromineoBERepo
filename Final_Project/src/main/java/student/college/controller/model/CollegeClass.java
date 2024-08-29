package student.college.controller.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import student.college.entity.Class;

@Data
@NoArgsConstructor
public class CollegeClass {

	private Integer classID;
	private String classTitle;
	private String department;
	private String weekdays;
	private String startTime;
	private String endTime;
	private CollegeProfessor teacher;
	
	public CollegeClass(Class newClass) {
		this.setClassID(newClass.getClassID());
		this.setClassTitle(newClass.getClassTitle());
		this.setDepartment(newClass.getDepartment());
		this.setWeekdays(newClass.getWeekdays());
		this.setStartTime(newClass.getStartTime());
		this.setEndTime(newClass.getEndTime());
		this.teacher = new CollegeProfessor(newClass.getTeacher());
	}

}
