package student.college.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import student.college.entity.Professor;

public interface ProfessorDao extends JpaRepository<Professor, Integer> {

}
