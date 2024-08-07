package pet.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.store.entity.Customer;

public interface StoreCustomerDao extends JpaRepository<Customer, Integer> {

}
