package student.college.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import student.college.entity.Class;

public interface ClassDao extends JpaRepository<Class, Integer> {

}
