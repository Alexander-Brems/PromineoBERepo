package pet.store.controller.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.*;

@Data
@NoArgsConstructor
public class PetStoreData {

	private Integer petStoreID;
	private String petStoreName;
	private String petStoreAddress;
	private String petStoreCity;
	private String petStoreState;
	private String petStoreZip;
	private String petStorePhone;
	
	private Set<PetStoreEmployee> employees = new HashSet<>();
	
	private Set<PetStoreCustomer> customers = new HashSet<>();
	
	public PetStoreData(PetStore newStore) {
		this.setPetStoreID(newStore.getPetStoreID());
		this.setPetStoreName(newStore.getPetStoreName());
		this.setPetStoreAddress(newStore.getPetStoreAddress());
		this.setPetStoreCity(newStore.getPetStoreCity());
		this.setPetStoreState(newStore.getPetStoreState());
		this.setPetStoreZip(newStore.getPetStoreZip());
		this.setPetStorePhone(newStore.getPetStorePhone());
		
		for(Employee emp : newStore.getEmployees()) {
			this.employees.add(new PetStoreEmployee(emp));
		}
		
		for(Customer cust : newStore.getCustomers()) {
			this.customers.add(new PetStoreCustomer(cust));
		}
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
	
}
