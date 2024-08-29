 package pet.store.service;

import java.util.Objects;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pet.store.controller.model.PetStoreCustomer;
import pet.store.controller.model.PetStoreData;
import pet.store.controller.model.PetStoreEmployee;
import pet.store.dao.PetStoreDao;
import pet.store.dao.StoreCustomerDao;
import pet.store.dao.StoreEmployeeDao;
import pet.store.entity.Customer;
import pet.store.entity.Employee;
import pet.store.entity.PetStore;

@Service
public class PetStoreService {
	
	@Autowired
	private PetStoreDao petStoreDao;
	@Autowired
	private StoreEmployeeDao storeEmpDao;
	@Autowired
	private StoreCustomerDao storeCustDao;

	@Transactional
	public PetStoreData savePetStore(PetStoreData storeData) {
		PetStore petStore = findOrCreatePetStore(storeData.getPetStoreID());
		copyPetStoreFields(petStore, storeData);
		PetStoreData newData = new PetStoreData(petStoreDao.save(petStore));
		return newData;
	}

	private void copyPetStoreFields(PetStore petStore, PetStoreData storeData) {
		petStore.setPetStoreID(storeData.getPetStoreID());
		petStore.setPetStoreName(storeData.getPetStoreName());
		petStore.setPetStoreAddress(storeData.getPetStoreAddress());
		petStore.setPetStoreCity(storeData.getPetStoreCity());
		petStore.setPetStoreState(storeData.getPetStoreState());
		petStore.setPetStoreZip(storeData.getPetStoreZip());
		petStore.setPetStorePhone(storeData.getPetStorePhone());
	}

	private PetStore findOrCreatePetStore(Integer petStoreID) {
		PetStore returnStore;
		if(Objects.isNull(petStoreID)) {
			returnStore = new PetStore();
		}
		else {
			returnStore = findPetStoreByID(petStoreID);
		}
		return returnStore;
	}

	private PetStore findPetStoreByID(Integer petStoreID) {
		return petStoreDao.findById(petStoreID).orElseThrow(() -> new NoSuchElementException("Pet Store ID = " + petStoreID + " was not found."));
	}

	@Transactional
	public PetStoreEmployee saveEmployee(Integer storeID, PetStoreEmployee storeEmp) {
		PetStore petStore = findPetStoreByID(storeID);
		Integer empID = storeEmp.getEmployeeID();
		Employee emp = findOrCreateEmployee(storeID, empID);
		copyEmployeeFields(emp, storeEmp);
		emp.setPetStore(petStore);
		petStore.getEmployees().add(emp);
		return new PetStoreEmployee(storeEmpDao.save(emp));
	}

	private void copyEmployeeFields(Employee emp, PetStoreEmployee storeEmp) {
		emp.setEmployeeID(storeEmp.getEmployeeID());
		emp.setEmployeeFirstName(storeEmp.getEmployeeFirstName());
		emp.setEmployeeLastName(storeEmp.getEmployeeLastName());
		emp.setEmployeePhone(storeEmp.getEmployeePhone());
		emp.setEmployeeJobTitle(storeEmp.getEmployeeJobTitle());
	}

	private Employee findOrCreateEmployee(Integer storeID, Integer empID) {
		Employee returnEmp;
		if(Objects.isNull(empID)) {
			returnEmp = new Employee();
		}
		else {
			returnEmp = findEmployeeByID(storeID, empID);
		}
		return returnEmp;
	}

	private Employee findEmployeeByID(Integer storeID, Integer empID) {
		Employee returnEmp = storeEmpDao.findById(empID).orElseThrow(() -> new NoSuchElementException("Employee ID = " + empID + " was not found."));
		if(storeID == returnEmp.getPetStore().getPetStoreID()) {
			return returnEmp;
		}
		else {
			throw new IllegalArgumentException("Employee ID = " + empID + " does not work at a pet store.");
		}
	}

	@Transactional
	public PetStoreCustomer saveCustomer(Integer storeID, PetStoreCustomer storeCust) {
		PetStore petStore = findPetStoreByID(storeID);
		Integer custID = storeCust.getCustomerID();
		Customer cust = findOrCreateCustomer(storeID, custID);
		copyCustomerFields(cust, storeCust);
		petStore.getCustomers().add(cust);
		cust.getPetStores().add(petStore);
		return new PetStoreCustomer(storeCustDao.save(cust));
	}

	private void copyCustomerFields(Customer cust, PetStoreCustomer storeCust) {
		cust.setCustomerID(storeCust.getCustomerID());
		cust.setCustomerFirstName(storeCust.getCustomerFirstName());
		cust.setCustomerLastName(storeCust.getCustomerLastName());
		cust.setCustomerEmail(storeCust.getCustomerEmail());
	}

	private Customer findOrCreateCustomer(Integer storeID, Integer custID) {
		Customer returnCust;
		if(Objects.isNull(custID)) {
			returnCust = new Customer();
		}
		else {
			returnCust = findCustomerByID(storeID, custID);
		}
		return returnCust;
	}

	private Customer findCustomerByID(Integer storeID, Integer custID) {
		Customer returnCust = storeCustDao.findById(custID).orElseThrow(() -> new NoSuchElementException("Customer ID = " + custID + " was not found."));
		for(PetStore petStore : returnCust.getPetStores()) {
			if(storeID == petStore.getPetStoreID()) {
				return returnCust;
			}
		}
		throw new IllegalArgumentException("Customer ID = " + custID + " is not a customer at any pet store.");
	}

	@Transactional
	public List<PetStoreData> retrieveAllPetStores() {
		List<PetStore> storeList = petStoreDao.findAll();
		List<PetStoreData> returnList = new LinkedList<PetStoreData>();
		for(PetStore store : storeList) {
			PetStoreData newStore = new PetStoreData(store);
			newStore.getEmployees().clear();
			newStore.getCustomers().clear();
			returnList.add(newStore);
		}
		return returnList;
	}

	@Transactional
	public PetStoreData retrieveOnePetStore(Integer storeID) {
		PetStore store = findPetStoreByID(storeID);
		return new PetStoreData(store);
	}

	@Transactional
	public void deletePetStoreByID(Integer storeID) {
		PetStore petStore = findPetStoreByID(storeID);
		petStoreDao.delete(petStore);
	}

}
