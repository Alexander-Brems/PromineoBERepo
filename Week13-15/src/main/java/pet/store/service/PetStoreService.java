package pet.store.service;

import java.util.Objects;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.store.controller.model.PetStoreData;
import pet.store.dao.PetStoreDao;
import pet.store.controller.error.GlobalErrorHandler;
import pet.store.entity.PetStore;

@Service
public class PetStoreService {
	
	@Autowired
	private PetStoreDao petStoreDao;

	public PetStoreData savePetStore(PetStoreData storeData) {
		PetStore petStore = findOrCreatePetStore(storeData.getPetStoreID());
		petStore = copyPetStoreFields(petStore, storeData);
		PetStoreData newData = new PetStoreData(petStoreDao.save(petStore));
		return newData;
	}

	private PetStore copyPetStoreFields(PetStore petStore, PetStoreData storeData) {
		petStore.setPetStoreID(storeData.getPetStoreID());
		petStore.setPetStoreName(storeData.getPetStoreName());
		petStore.setPetStoreAddress(storeData.getPetStoreAddress());
		petStore.setPetStoreCity(storeData.getPetStoreCity());
		petStore.setPetStoreState(storeData.getPetStoreState());
		petStore.setPetStoreZip(storeData.getPetStoreZip());
		petStore.setPetStorePhone(storeData.getPetStorePhone());;
		return petStore;
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
		return petStoreDao.findById(petStoreID).orElseThrow(() -> new NoSuchElementException("Pet Store ID = " + petStoreID.toString() + " was not found."));
	}

}
