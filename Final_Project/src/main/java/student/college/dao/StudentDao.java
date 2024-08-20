package student.college.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import student.college.entity.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {

}
