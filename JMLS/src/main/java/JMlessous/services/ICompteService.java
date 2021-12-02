package JMlessous.services;

import java.util.List;

import JMlessous.entities.Compte;

public interface ICompteService {

	List<Compte> RetrieveAllComptes();

	Compte AddCompte(Compte c);

	void DeleteCompte(Long id);

	Compte UpdateCompte(Compte c);

	Compte RetrieveCompte(String id);

	List<Compte> RetrieveActiveUserComptes(Long id);

	Compte UpdateCompteRate(Compte c, float rate);

	void AssignCompte(long compteid, long userid);

}
