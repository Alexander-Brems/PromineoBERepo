package student.college.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
