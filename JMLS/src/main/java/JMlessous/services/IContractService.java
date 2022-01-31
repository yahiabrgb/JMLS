package JMlessous.services;

import java.util.List;

import JMlessous.entities.Contract;
import JMlessous.entities.ContractType;
import JMlessous.entities.User;


public interface IContractService {


	List<Contract> RetrieveAllContracts(); 
	Contract AddContract(Contract c);
	void DeleteContract(Long id);
	Contract UpdateContract(Contract c);
	Contract RetrieveContract(String id);
	List<Contract> findByDurationGreater(int year);
	List<Contract> ShowNotApprovedContracts();
	void ContractToUser(long cntID, long userID);
	float TotalPricing();
	List<Contract> RetrieveContractsByUserId(long id);
	float PrimeVieUnique(float prime, long userid, int duree,double taux);
	double RITP(double prime,long userid,double taux);
	double RITC(double capital,long userid,double taux);
	void MAJContractPrice(long cntid , long userid , int duree , double taux , float C);
	float CapitalMixte(double prime,long userid,int n);
	void DeleteContractsByUserId(long id);
	int CountContracts();
	void MAJContractDuration(int duration,long cntid);

	int CountContractsByIdAndType(long id, ContractType type);
	void DeleteExpiredContracts();
	void ApproveContract(long cntid);
	float TotalCost();
	public User retrieveUser(Long id);
	public Long findIdContrat(float prime);
	public Long findIdContratByNom(ContractType s);
	List<Long> findByIdPerson() ;
	public List<String> findByIdPerson2();
	Contract RetrieveContract2(Long id);
	 void MAJContractCost(long cntid , long userid , int duree , double taux , float C);
	Contract addOrUpdateContract(Contract contract);
	List<Contract> retrieveContractsbytype(ContractType type);
	Contract retrieveContractsbytype2(ContractType type);
	List<User> retrieveallusers();
	float CapitalVieUnique(float C, long userid, int duree,double taux);
	Contract findContrat1();
	Contract findContrat2();
	Contract findContrat3();

	//public List<Contract> sortByDuration();
}