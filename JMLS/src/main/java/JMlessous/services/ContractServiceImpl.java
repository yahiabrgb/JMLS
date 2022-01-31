package JMlessous.services;

import java.security.Principal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import JMlessous.entities.Contract;
import JMlessous.entities.ContractType;
import JMlessous.entities.User;
import JMlessous.repositories.*;
import JMlessous.repositories.TableMortalitéRepository;



@Service
public class ContractServiceImpl implements IContractService {
	@Autowired
	ContractRepository ContractRepository;
	@Autowired
	UserRepository UserRepository;
	@Autowired
	TableMortalitéRepository tr ;

	
	private static final Logger L= LogManager.getLogger(ContractServiceImpl.class);
	

	
	@Override
	public List<Contract> RetrieveAllContracts(){
		List<Contract> cnts = (List<Contract>) ContractRepository.findAll();
		return cnts;
	}
	
	@Override
	public Contract AddContract(Contract c) {
		Contract cnt = null;
		cnt = ContractRepository.save(c);
		return cnt;
	}
	
	@Override
	public void DeleteContract(Long id) {
		ContractRepository.findById(id).get().setUser(null);
		ContractRepository.deleteById(id);
	}
	
	@Override
	public Contract UpdateContract(Contract c) {
		Contract ContractUpdated = ContractRepository.save(c);
		return ContractUpdated;
	}	
	
	@Override
	public void DeleteExpiredContracts(){
		ContractRepository.DeleteExpiredContracts();
	}
	
	@Override
	public Contract RetrieveContract(String id) {
		L.info("in RetrieveContract id = " + id);
		Contract c = ContractRepository.findById(Long.parseLong(id)).get();
		L.info("Contract returned = : " + c);
		return c;	
	}
	
		@Override
	public List<Contract> findByDurationGreater(int year) {
		List<Contract> cnt = ContractRepository.findByDurationGreater(year);
		L.info("Contract +++ :" + cnt) ;
		return cnt;
	}
		
	@Override
	public int CountContracts(){
		return ContractRepository.CountContracts();
	}
	
	@Override
	public int CountContractsByIdAndType(long id,ContractType type){
		return ContractRepository.CountContractsByIdAndType(id, type);
		
	}
	
	@Override
	public void DeleteContractsByUserId(long id){
		List<Contract> cnt = ContractRepository.RetrieveContractsByUserId(id)	;
		ContractRepository.deleteAll(cnt);
	}
	
	@Override
	public void ContractToUser(long cntID, long userID){
	Contract cnt = ContractRepository.findById(cntID).get();
	User user = UserRepository.findById(userID).get();
	cnt.setUser(user);
	ContractRepository.save(cnt);
	}
	
	@Override
	public float TotalPricing() {
		return ContractRepository.TotalPricing();
	}
	
	@Override
	public float TotalCost() {

		return ContractRepository.TotalPricing();
	}
	

	

	
	@Override
	public List<Contract> RetrieveContractsByUserId(long id) {
		List<Contract> cnt = ContractRepository.RetrieveContractsByUserId(id);
		L.info("contract +++ :" + cnt) ;
		return cnt;
	}
		@Override
	public float CapitalVieUnique (float C,long userid, int duree,double taux){
		float prime =0;
		Date date = UserRepository.findById(userid).get().getBirthdate();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int BDay = calendar.get(Calendar.YEAR);
		LocalDate now = LocalDate.now();
		int ageClient = now.getYear()-BDay;
		if (ageClient>60) {
			
		return 0;
		}
		float lxn = tr.findBySurvivantsLx(ageClient+duree);
		float lx = tr.findBySurvivantsLx(ageClient);
		double v = Math.pow( 1/ (1+taux) ,duree);
		prime = (float) (C*(lxn/lx) * v);
		
	   	return prime;}
	@Override
	public void MAJContractPrice(long cntid , long userid , int duree , double taux , float C){
		float prime =0;
		Date date = UserRepository.findById(userid).get().getBirthdate();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int BDay = calendar.get(Calendar.YEAR);
		LocalDate now = LocalDate.now();
		int ageClient = now.getYear()-BDay;
		float lxn = tr.findBySurvivantsLx(ageClient+duree);
		float lx = tr.findBySurvivantsLx(ageClient);
		double v = Math.pow( 1/ (1+taux) ,duree);
		prime = (float) (C*(lxn/lx) * v);
		Contract cnt = ContractRepository.findById(cntid).get();
		cnt.setPrice(prime);
		ContractRepository.save(cnt);
	}
	
	@Override
	public void MAJContractCost(long cntid , long userid , int duree , double taux , float P){
		float C =0;
		Date date = UserRepository.findById(userid).get().getBirthdate();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int BDay = calendar.get(Calendar.YEAR);
		LocalDate now = LocalDate.now();
		int ageClient = now.getYear()-BDay;
		float lxn = tr.findBySurvivantsLx(ageClient+duree);
		float lx = tr.findBySurvivantsLx(ageClient);
		double v = Math.pow( 1/ (1+taux) ,duree);
		C = (float) (P/((lxn/lx) * v));
		Contract cnt = ContractRepository.findById(cntid).get();
		cnt.setCost(C);
		ContractRepository.save(cnt);
	}
	
	@Override
	public void MAJContractDuration(int duration,long cntid){
		Contract cnt = ContractRepository.findById(cntid).get();
		int d =cnt.getDuration();
		cnt.setDuration(duration);
		LocalDate exp = (new Date()).toInstant()
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate().plusYears(duration);
		cnt.setExpiration_date(Date.from(exp.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		cnt.setPrice(cnt.getPrice()*duration/d);
		ContractRepository.save(cnt);
	}
	
	@Override
	public void ApproveContract(long cntid){
		Contract c = ContractRepository.findById(cntid).get();
		User u= ContractRepository.findById(cntid).get().getUser();
		/*try {
			.sendEmail(u.getEmail(), "Contract approved", "Dear Client "+u.getFirstName() +" "+u.getLastName()+"\n Your Contract, of type "+c.getType()+" has been approved for a total price of "
			+ c.getPrice()+" and a maximum of "+c.getCost()+"Dt as cost for the insurance.\n The duration of the contract is "+c.getDuration()+" Years, strating from now "+ c.getCreation_date() + " to "+c.getExpiration_date()+"\n For any information please contact us or"
			+ " leave us a contraint.\nWeInsure MicroInsurance for everyone", file);
		} catch (MessagingException e) {
			e.printStackTrace();
		}*/
		c.setApproved(true);
		ContractRepository.save(c);
	}
	
	@Override
	public List<Contract> ShowNotApprovedContracts() {
		List<Contract> cnt = ContractRepository.ShowNotApprovedContracts();
		return cnt;
	}
	

			
	@Override
	public float PrimeVieUnique(float prime,long userid, int duree,double taux){
		
		float C =0;
		Date date = UserRepository.findById(userid).get().getBirthdate();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int BDay = calendar.get(Calendar.YEAR);
		LocalDate now = LocalDate.now();
		int ageClient = now.getYear()-BDay;
		float lxn = tr.findBySurvivantsLx(ageClient+duree);
		float lx = tr.findBySurvivantsLx(ageClient);
		double v = Math.pow( 1/ (1+taux) ,duree);
		C = (float) (prime/((lxn/lx) * v));
		
		return C;
	}
	
	@Override
	public double RITP(double prime,long userid,double taux){
		float somme1 = 0,somme2=0;
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(UserRepository.findById(userid).get().getBirthdate());
		int BDay = calendar.get(Calendar.YEAR);
		LocalDate now = LocalDate.now();
		int ageClient = now.getYear()-BDay;
	
		for (int i=0;i<60-ageClient-1;i++)
		{
			float lxn = tr.findBySurvivantsLx(ageClient+i);
			float lx = tr.findBySurvivantsLx(ageClient);
			double v = Math.pow( 1/ (1+taux) ,i);
			somme1=(float) (somme1+((lxn/lx)*v));
		}
		double side1= prime*somme1;
		for (int i=60-ageClient-1;i<tr.findAgeMax()-ageClient;i++)
		{
			float lxn = tr.findBySurvivantsLx(ageClient+i);
			float lx = tr.findBySurvivantsLx(ageClient);
			double v = Math.pow( 1/ (1+taux) ,i);
			somme2=(float) (somme2+((lxn/lx)*v));
		}
		 	
	   	return side1/somme2;

		
	}
	
	@Override
	public double RITC(double capital,long userid,double taux){
		float somme1 = 0,somme2=0;
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(UserRepository.findById(userid).get().getBirthdate());
		int BDay = calendar.get(Calendar.YEAR);
		LocalDate now = LocalDate.now();
		int ageClient = now.getYear()-BDay;
		
		for (int i=0;i<60-ageClient-1;i++)
		{
			float lxn = tr.findBySurvivantsLx(ageClient+i);
			float lx = tr.findBySurvivantsLx(ageClient);
			double v = Math.pow( 1/ (1+taux) ,i);
			somme1=(float) (somme1+((lxn/lx)*v));
		}
		
		for (int i=60-ageClient-1;i<tr.findAgeMax()-ageClient;i++)
		{
			float lxn = tr.findBySurvivantsLx(ageClient+i);
			float lx = tr.findBySurvivantsLx(ageClient);
			double v = Math.pow( 1/ (1+taux) ,i);
			somme2=(float) (somme2+((lxn/lx)*v));
		}
		double side2= capital*somme2;
	
	   	return side2/somme1;
	 
		}
	
	@Override
	public float CapitalMixte(double prime,long userid,int n){
		float somme1 = 0,somme2=0;
		double taux = 0;
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(UserRepository.findById(userid).get().getBirthdate());
		int BDay = calendar.get(Calendar.YEAR);
		LocalDate now = LocalDate.now();
		int ageClient = now.getYear()-BDay;
		if((ageClient > 18) &&( ageClient<=35) )
		taux = 0.13;
		else if ((ageClient >35) &&( ageClient<=50) )
			taux = 0.19;
		else if ((ageClient >50) &&( ageClient<60) )
			taux = 0.27;
		else {
		L.info("Erreur: Le client n'est pas eligible aÃ‚Â  ce type de contrat");
		return 0;
		}
		for (int i=0;i<60-ageClient-1;i++)
		{
			float lxn = tr.findBySurvivantsLx(ageClient+i);
			float lx = tr.findBySurvivantsLx(ageClient);
			double v = Math.pow( 1/ (1+taux) ,i);
			somme1=(float) (somme1+((lxn/lx)*v));
		}
		float side1=(float) (somme1*prime);
		for(int i=0;i<n;i++)
		{
			float dxk=tr.findByDecesDx(ageClient+i)	;
			float lx=tr.findBySurvivantsLx(ageClient);
			double v = Math.pow( 1/ (1+taux) ,i+(1/2));
			somme2 = (float) (somme2+((dxk*v)/lx));
		}
		Contract c = new Contract();
		c.setCreation_date(new Date());
		c.setDuration(tr.findAgeMax()-ageClient);
		LocalDate exp = (new Date()).toInstant()
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate().plusYears(tr.findAgeMax()-ageClient);
		c.setExpiration_date(Date.from(exp.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		if (ContractRepository.CountContractsByIdAndType(userid, ContractType.Mixte) == 0)
		c.setType(ContractType.Mixte);
		else {System.out.println("You already have a contract with this type!");
		return 0;
		}
		c.setRate(taux);
		c.setPrice((float) (side1/(somme2+((Math.pow( 1/ (1+taux) ,n))*tr.findBySurvivantsLx(ageClient+n))/tr.findBySurvivantsLx(ageClient))));
		User user = UserRepository.findById(userid).get();
		c.setUser(user);
		c.setCost((float) (side1/(somme2+((Math.pow( 1/ (1+taux) ,n))*tr.findBySurvivantsLx(ageClient+n))/tr.findBySurvivantsLx(ageClient))));

		System.out.print("Do you confirm " + user.getLastname() +" " + user.getFirstname() +" the creation of this " + c.getType()+" contract for a price of : " + prime +"DT for " + (60-ageClient) + " Years and total of " + c.getPrice() +"DT ?\n");
	  
	   	ContractRepository.save(c);	   	
		return (float) (side1/(somme2+((Math.pow( 1/ (1+taux) ,n))*tr.findBySurvivantsLx(ageClient+n))/tr.findBySurvivantsLx(ageClient)));
	}
	
	@Override
	public List<Long> findByIdPerson() {
		List<Long> sins  = ContractRepository.findByIdUser();
	  return sins;
	}
	

	@Override
	public Contract addOrUpdateContract(Contract contract) {
		Contract cnt = new Contract();
cnt = ContractRepository.save(contract);
return cnt;
	}

	@Override

	public Long findIdContrat(float prime) {
		Long id  = ContractRepository.findIdContrat(prime);
	  return id;
	}
	@Override
	public Long findIdContratByNom(ContractType s) {
		Long id  = ContractRepository.findIdContratbyNom(s);
	  return id;
	}
	@Override
	public List<String> findByIdPerson2() {
		List<String> sins  = ContractRepository.findByIdPerson2();
	  return sins;
	}
	@Override
	public Contract RetrieveContract2(Long id) {
		L.info("in RetrieveContract id = " + id);
		Contract c = ContractRepository.findById(id).get();
		L.info("Contract returned = : " + c);
		return c;	
	}

	

	public List<Contract> retrieveContractsbytype(ContractType type) {
		
		return ContractRepository.retrieveContractsbytype(type);
	}
public Contract retrieveContractsbytype2(ContractType type) {
		
		return ContractRepository.retrieveContractsbytype2(type);
	}

	@Override
	public List<User> retrieveallusers() {
		return ContractRepository.retrieveallusers();
	}

	@Override
	public User retrieveUser(Long id) {
		User u = ContractRepository.retrieveUser(id);
		return u;
	}

	@Override
	public Contract findContrat1(){
		Contract c = ContractRepository.findContrat();
		return c ;
	}
	@Override
	public Contract findContrat2(){
		Contract c = ContractRepository.findContrat2();
		return c ;
	}

	@Override
	public Contract findContrat3(){
		Contract c = ContractRepository.findContrat3();
		return c ;
	}





}