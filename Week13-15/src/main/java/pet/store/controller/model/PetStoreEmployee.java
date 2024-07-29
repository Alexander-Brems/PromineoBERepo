package pet.store.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.*;

@Data
@NoArgsConstructor
public class PetStoreEmployee {

	private Integer employeeID;
	private String employeeFirstName;
	private String employeeLastName;
	private String employeePhone;
	private String employeeJobTitle;
	
	public PetStoreEmployee(Employee newEmp) {
		this.setEmployeeID(newEmp.getEmployeeID());
		this.setEmployeeFirstName(newEmp.getEmployeeFirstName());
		this.setEmployeeLastName(newEmp.getEmployeeLastName());
		this.setEmployeePhone(newEmp.getEmployeePhone());
		this.setEmployeeJobTitle(newEmp.getEmployeeJobTitle());
	}
	
	public Integer getEmployeeID() {
		return employeeID;
	}
	
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
	
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}
	
	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}
	
	public String getEmployeeLastName() {
		return employeeLastName;
	}
	
	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}
	
	public String getEmployeePhone() {
		return employeePhone;
	}
	
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	
	public String getEmployeeJobTitle() {
		return employeeJobTitle;
	}
	
	public void setEmployeeJobTitle(String employeeJobTitle) {
		this.employeeJobTitle = employeeJobTitle;
	}
	
}
