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
	@JoinTable(name = "pet_store_customer", 
		joinColumns = @JoinColumn(name = "pet_store_id"), 
		inverseJoinColumns = @JoinColumn(name = "customer_id"))
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Customer> customers = new HashSet<>(); 
	
	public PetStore(PetStore newStore) {
		this.setPetStoreID(newStore.getPetStoreID());
		this.setPetStoreName(newStore.getPetStoreName());
		this.setPetStoreAddress(newStore.getPetStoreAddress());
		this.setPetStoreCity(newStore.getPetStoreCity());
		this.setPetStoreState(newStore.getPetStoreState());
		this.setPetStoreZip(newStore.getPetStoreZip());
		this.setPetStorePhone(newStore.getPetStorePhone());
		this.setEmployees(newStore.getEmployees());
		this.setCustomers(newStore.getCustomers());
	}
	
	public PetStore() {
		
	}

	public Integer getPetStoreID() {
		return petStoreID;
	}

	public void setPetStoreID(Integer petStoreID) {
		this.petStoreID = petStoreID;
	}

	public String getPetStoreName() {
		return petStoreName;
	}

	public void setPetStoreName(String petStoreName) {
		this.petStoreName = petStoreName;
	}

	public String getPetStoreAddress() {
		return petStoreAddress;
	}

	public void setPetStoreAddress(String petStoreAddress) {
		this.petStoreAddress = petStoreAddress;
	}

	public String getPetStoreCity() {
		return petStoreCity;
	}

	public void setPetStoreCity(String petStoreCity) {
		this.petStoreCity = petStoreCity;
	}

	public String getPetStoreState() {
		return petStoreState;
	}

	public void setPetStoreState(String petStoreState) {
		this.petStoreState = petStoreState;
	}

	public String getPetStoreZip() {
		return petStoreZip;
	}

	public void setPetStoreZip(String petStoreZip) {
		this.petStoreZip = petStoreZip;
	}

	public String getPetStorePhone() {
		return petStorePhone;
	}

	public void setPetStorePhone(String petStorePhone) {
		this.petStorePhone = petStorePhone;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}
}
