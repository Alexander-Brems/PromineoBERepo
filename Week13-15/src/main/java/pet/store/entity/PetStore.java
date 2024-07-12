package pet.store.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class PetStore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer petStoreID;
	private String petStoreName;
	private String petStoreAddress;
	private String petStoreCity;
	private String petStoreState;
	private String petStoreZip;
	private String petStorePhone;
	
	@OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL, orphanRemoval = true)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Employee> employees = new HashSet<>();
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "pet_store_customer", joinColumns = 
	@JoinColumn(name = "pet_store_id"), inverseJoinColumns = 
	@JoinColumn(name = "customer_id"))
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Customer> customers = new HashSet<>(); 
	
	public PetStore(PetStore newStore) {
		this.petStoreID = newStore.petStoreID;
		this.petStoreName = newStore.petStoreName;
		this.petStoreAddress = newStore.petStoreAddress;
		this.petStoreCity = newStore.petStoreCity;
		this.petStoreState = newStore.petStoreState;
		this.petStoreZip = newStore.petStoreZip;
		this.petStorePhone = newStore.petStorePhone;
		this.employees = newStore.employees;
		this.customers = newStore.customers;
	}
}
