package pet.store.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.PetStoreCustomer;
import pet.store.controller.model.PetStoreData;
import pet.store.controller.model.PetStoreEmployee;
import pet.store.service.PetStoreService;

@RestController
@RequestMapping("/pet_store")
@Slf4j
public class PetStoreController {
	
	@Autowired
	private PetStoreService storeService;
	
	@GetMapping("/pet_store_data")
	public List<PetStoreData> getAllPetStores() {
		log.info("Retrieving Current Pet Stores.");
		return storeService.retrieveAllPetStores();
	}
	
	@GetMapping("/pet_store_data/{storeID}")
	public PetStoreData getSinglePetStore(@PathVariable Integer storeID) {
		log.info("Retrieving Pet Store {}", storeID);
		return storeService.retrieveOnePetStore(storeID);
	}
	
	@DeleteMapping("/pet_store_data/{storeID}")
	public Map<String, String> deletePetStoreByID(@PathVariable Integer storeID) {
		log.info("Deleting Pet Store {}", storeID);
		storeService.deletePetStoreByID(storeID);
		return Map.of("message", "Pet Store = " + storeID + " successfully deleted.");
	}
	
	@PostMapping("/pet_store_data")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetStoreData insertPetStoreData(@RequestBody PetStoreData storeData) {
		log.info("Creating Pet Store {}", storeData);
		return storeService.savePetStore(storeData);
	}
	
	@PutMapping("/pet_store_data/{petStoreID}")
	public PetStoreData updatePetStoreData(@PathVariable Integer petStoreID, @RequestBody PetStoreData storeData) {
		storeData.setPetStoreID(petStoreID);
		log.info("Updating Pet Store {}", storeData);
		return storeService.savePetStore(storeData);
	}
	
	@PostMapping("/{storeID}/employee")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetStoreEmployee insertStoreEmployee(@PathVariable Integer storeID, @RequestBody PetStoreEmployee storeEmp) {
		log.info("Creating Employee {}", storeEmp);
		return storeService.saveEmployee(storeID, storeEmp);
	}
	
	@PostMapping("/{storeID}/customer")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetStoreCustomer insertStoreCustomer(@PathVariable Integer storeID, @RequestBody PetStoreCustomer storeCust) {
		log.info("Creating Store Customer {}", storeCust);
		return storeService.saveCustomer(storeID, storeCust);
	}

}
