package pet.store.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.*;

@Data
@NoArgsConstructor
public class PetStoreCustomer {

	private Integer customerID;
	private String customerFirstName;
	private String customerLastName;
	private String customerEmail;
	
	
	public PetStoreCustomer(Customer newCust) {
		this.setCustomerID(newCust.getCustomerID());
		this.setCustomerFirstName(newCust.getCustomerFirstName());
		this.setCustomerLastName(newCust.getCustomerLastName());
		this.setCustomerEmail(newCust.getCustomerEmail());
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
}
