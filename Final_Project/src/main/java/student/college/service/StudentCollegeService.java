package student.college.service;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import student.college.controller.model.CollegeClass;
import student.college.controller.model.CollegeProfessor;
import student.college.controller.model.CollegeStudent;
import student.college.entity.Class;
import student.college.entity.Professor;
import student.college.entity.Student;
import student.college.dao.ClassDao;
import student.college.dao.ProfessorDao;
import student.college.dao.StudentDao;

@Service
public class StudentCollegeService {

	@Autowired
	private StudentDao stuDao;
	@Autowired
	private ClassDao claDao;
	@Autowired
	private ProfessorDao profDao;
	
	@Transactional
	public List<CollegeClass> retrieveAllClasses() {
		List<Class> classList = claDao.findAll();
		List<CollegeClass> returnList = new LinkedList<CollegeClass>();
		for(Class cla : classList) {
			CollegeClass newClass = new CollegeClass(cla);
			returnList.add(newClass);
		}
		return returnList;
	}
	
	@Transactional
	public CollegeClass saveCollegeClass(CollegeClass classData, Integer teacherID) {
		Professor teacher = findProfessorByID(teacherID);
		Integer classID = classData.getClassID();
		Class cla = findOrCreateClass(classID, teacherID);
		copyClassFields(cla, classData);
		cla.setTeacher(teacher);
		teacher.getClasses().add(cla);
		return new CollegeClass(claDao.save(cla));
	}

	private void copyClassFields(Class cla, CollegeClass classData) {
		cla.setClassID(classData.getClassID());
		cla.setClassTitle(classData.getClassTitle());
		cla.setDepartment(classData.getDepartment());
		cla.setWeekdays(classData.getWeekdays());
		cla.setStartTime(classData.getStartTime());
		cla.setEndTime(classData.getEndTime());
		
	}

	private Class findOrCreateClass(Integer classID, Integer teacherID) {
		Class returnClass;
		if(Objects.isNull(classID)) {
			returnClass = new Class();
		}
		else {
			returnClass = findClassByID(classID, teacherID);
		}
		return returnClass;
	}

	private Class findClassByID(Integer classID) {
		return claDao.findById(classID).orElseThrow(() -> new NoSuchElementException("Class ID = " + classID + " was not found."));
	}
	
	private Class findClassByID(Integer classID, Integer teacherID) {
		Class returnClass = claDao.findById(classID).orElseThrow(() -> new NoSuchElementException("Class ID = " + classID + " was not found."));
		if(teacherID == returnClass.getTeacher().getProfessorID()) {
			return returnClass;
		}
		else {
			throw new IllegalArgumentException("Class ID = " + classID + " does not have a teacher.");
		}
	}
	
	@Transactional
	public void deleteClassByID(Integer classID) {
		Class cla = findClassByID(classID);
		claDao.delete(cla);
	}
	
	@Transactional
	public List<CollegeStudent> retrieveAllStudents() {
		List<Student> studentList = stuDao.findAll();
		List<CollegeStudent> returnList = new LinkedList<CollegeStudent>();
		for(Student student : studentList) {
			CollegeStudent newStudent = new CollegeStudent(student);
			newStudent.getClasses().clear();
			returnList.add(newStudent);
		}
		return returnList;
	}
	
	@Transactional
	public CollegeStudent retrieveStudentDetails(Integer studentID) {
		Student student = findStudentByID(studentID);
		return new CollegeStudent(student);
	}

	@Transactional
	public CollegeStudent saveStudent(CollegeStudent studentData) {
		Student student = findOrCreateStudent(studentData.getStudentID());
		copyStudentFields(student, studentData);
		CollegeStudent newStudent = new CollegeStudent(stuDao.save(student));
		return newStudent;
	}
	
	private void copyStudentFields(Student student, CollegeStudent studentData) {
		student.setStudentID(studentData.getStudentID());
		student.setFirstName(studentData.getFirstName());
		student.setLastName(studentData.getLastName());
		student.setPhoneNumber(studentData.getPhoneNumber());
		student.setEmail(studentData.getEmail());
		for(Class cla : student.getClasses()) {
			cla.getStudents().remove(student);
		}
		student.getClasses().clear();
		for(CollegeClass cla : studentData.getClasses()) {
			Class newClass = findClassByID(cla.getClassID());
			student.getClasses().add(newClass);
		}
		for(Class newCla : student.getClasses()) {
			newCla.getStudents().add(student);
		}
		
	}

	private Student findOrCreateStudent(Integer studentID) {
		Student returnStudent;
		if(Objects.isNull(studentID)) {
			returnStudent = new Student();
		}
		else {
			returnStudent = findStudentByID(studentID);
		}
		return returnStudent;
	}

	private Student findStudentByID(Integer studentID) {
		return stuDao.findById(studentID).orElseThrow(() -> new NoSuchElementException("Student ID = " + studentID + " was not found."));
	}

	@Transactional
	public List<CollegeProfessor> retrieveAllProfessors() {
		List<Professor> teacherList = profDao.findAll();
		List<CollegeProfessor> returnList = new LinkedList<CollegeProfessor>();
		for(Professor prof : teacherList) {
			CollegeProfessor newTeacher = new CollegeProfessor(prof);
			returnList.add(newTeacher);
		}
		return returnList;
	}

	@Transactional
	public CollegeProfessor saveProfessor(CollegeProfessor teacherData) {
		Professor teacher = findOrCreateProfessor(teacherData.getProfessorID());
		copyProfessorFields(teacher, teacherData);
		CollegeProfessor newTeacher = new CollegeProfessor(profDao.save(teacher));
		return newTeacher;
	}

	private void copyProfessorFields(Professor teacher, CollegeProfessor teacherData) {
		teacher.setProfessorID(teacherData.getProfessorID());
		teacher.setFirstName(teacherData.getFirstName());
		teacher.setLastName(teacherData.getLastName());
		teacher.setDepartment(teacherData.getDepartment());
		teacher.setHasTenure(teacherData.getHasTenure());
		teacher.setPhoneNumber(teacherData.getPhoneNumber());
		teacher.setEmail(teacherData.getEmail());
		
	}

	private Professor findOrCreateProfessor(Integer professorID) {
		Professor returnProf;
		if(Objects.isNull(professorID)) {
			returnProf = new Professor();
		}
		else {
			returnProf = findProfessorByID(professorID);
		}
		return returnProf;
	}

	private Professor findProfessorByID(Integer professorID) {
		return profDao.findById(professorID).orElseThrow(() -> new NoSuchElementException("Professor ID = " + professorID + " was not found."));
	}
}
