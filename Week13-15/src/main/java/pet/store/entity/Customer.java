package pet.store.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerID;
	private String customerFirstName;
	private String customerLastName;
	private String customerEmail;
	
	@ManyToMany(mappedBy = "customers", cascade = CascadeType.PERSIST)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<PetStore> petStores = new HashSet<>();
	
	public Customer(Customer newCust) {
		this.setCustomerID(newCust.getCustomerID());
		this.setCustomerFirstName(newCust.getCustomerFirstName());
		this.setCustomerLastName(newCust.getCustomerLastName());
		this.setCustomerEmail(newCust.getCustomerEmail());
		this.setPetStores(newCust.getPetStores());
		}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public String getCustomerFirstName() {
		return customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Set<PetStore> getPetStores() {
		return petStores;
	}

	public void setPetStores(Set<PetStore> petStores) {
		this.petStores = petStores;
	}
}
