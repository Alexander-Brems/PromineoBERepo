package student.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import student.college.service.StudentCollegeService;

@RestController
@RequestMapping("/college")
@Slf4j
public class StudentCollegeController {

	@Autowired
	private StudentCollegeService collegeService;
}
