package pet.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.store.entity.Employee;

public interface StoreEmployeeDao extends JpaRepository<Employee, Integer> {

}
