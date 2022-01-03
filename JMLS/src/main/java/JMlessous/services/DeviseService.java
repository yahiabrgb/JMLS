package JMlessous.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import JMlessous.entities.*;
import JMlessous.repositories.DeviseRepository;

@Service
public class DeviseService implements IDeviseService {

	@Autowired
	DeviseRepository deviseRepository;

	
	@Override
	public Devise AjouterDevise(Devise d) {
	return deviseRepository.saveAndFlush(d);
	}
	
	
	@Override
	public List<Devise> RetrieveallDevise() {
		return deviseRepository.findAll();
	}
		

}
