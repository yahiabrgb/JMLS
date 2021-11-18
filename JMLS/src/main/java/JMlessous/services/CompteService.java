package JMlessous.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JMlessous.entities.Compte;
import JMlessous.repositories.*;


@Service
public class CompteService implements ICompteService{

	@Autowired
	CompteRepository CompteRepository;

	
	@Override
	public List<Compte> RetrieveAllComptes(){
		List<Compte> compte = (List<Compte>) CompteRepository.findAll();
		return compte;
	}
	
	@Override
	public Compte AddCompte(Compte c) {
		Compte compte = null;
		compte = CompteRepository.save(c);
		return compte;
	}
	
	@Override
	public void DeleteCompte(Long id) {
		//CompteRepository.findById(id).get().setUser(null);
		CompteRepository.deleteById(id);
	}
	
	@Override
	public Compte UpdateCompte(Compte c) {
		Compte CompteUpdated = CompteRepository.save(c);
		return CompteUpdated;
	}	
	
	@Override
	public Compte RetrieveCompte(String id){
		Compte c = CompteRepository.findById(Long.parseLong(id)).get();
		return c;
	}
	

}
