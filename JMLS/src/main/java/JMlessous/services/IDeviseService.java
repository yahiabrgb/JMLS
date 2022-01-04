package JMlessous.services;

import java.util.List;

import JMlessous.entities.Devise;

public interface IDeviseService {

	Devise AjouterDevise(Devise d);

	List<Devise> RetrieveallDevise();

	double DevisetoTND(Devise d, double somme);

	double TNDtoDevise(Devise d, double somme);

	//void AjouterDevise();

}
