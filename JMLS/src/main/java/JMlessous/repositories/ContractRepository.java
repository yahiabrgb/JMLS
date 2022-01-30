package JMlessous.repositories;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import JMlessous.entities.Contract;
import JMlessous.entities.ContractType;
import JMlessous.entities.User;

@Repository
public interface ContractRepository extends CrudRepository<Contract,Long> {

	@Query("SELECT c from Contract c WHERE c.Duration > :Duration ORDER By c.Duration asc ")
	List<Contract> findByDurationGreater(@Param("Duration") int Duration);
	
	@Query("Select SUM(c.Price) from Contract c where c.approved = TRUE ")
	public float TotalPricing();
	
	@Query("Select SUM(c.cost) from Contract c where c.approved= TRUE ")
	public float TotalCost();
	
	@Query("Select c from Contract c where c.user.id=:id")
	List<Contract> RetrieveContractsByUserId(@Param("id")long id);
	
	@Modifying
    @Transactional
    @Query("UPDATE Contract c SET c.Price=:price where c.idcontract=:cntid")
    public void MAJContractPrice(@Param("price")float price, @Param("cntid")long cntid);
	
	@Modifying
    @Transactional
    @Query("UPDATE Contract c SET c.Duration=:duration where c.idcontract=:cntid")
    public void MAJContractDuration(@Param("duration")int duration, @Param("cntid")long cntid);
	
	@Modifying
    @Transactional
    @Query("DELETE from Contract c WHERE c.user.id=:id")
    public void DeleteContractsByUserId(@Param("id")long id);
	
	@Query("Select count(*) from Contract")
	public int CountContracts();
	
	@Query("select count(s.user.id) from sinister s "
			+ " join Contract c"
			+ " on s.user.id = c.user.id "
			+ " where  c.user.id=:id "
			+ " and s.typeSinistre = 'Vie' "
			+ " and c.Type = 'Vie' ")
	public int SinistersPerContractVie (@Param("id")long id); 
	
	@Query("select count(s.user.id) from sinister s"
			+ " join Contract c"
			+ " on s.user.id = c.user.id"
			+ " where  c.user.id=:id"
			+ " and s.typeSinistre like 'Rente' "
			+ " and c.Type like 'Rente' ")
	public int SinistersPerContractRente (@Param("id")long id); 
	
	@Query("Select count(*) from Contract c where c.user.id=:id and c.Type=:type")
	public int CountContractsByIdAndType(@Param("id")long id,@Param("type")ContractType type);

	@Modifying
	@Transactional
	@Query("DELETE from Contract c WHERE c.Expiration_date < now() ")
	public void DeleteExpiredContracts();
	
	@Query("Select c from Contract c where c.approved='false'")
	List<Contract> ShowNotApprovedContracts();

	@Query("select c.Price from Contract c where c.user = '6L' ")
	List<Long> findByIdUser();
	@Query("select c.idcontract from Contract c where c.Price = ?1 ")
	long findIdContrat(float prime);
	
	@Query("select c.idcontract from Contract c where c.Type = ?1 ")
	long findIdContratbyNom(ContractType nom);
	@Query("select c.Type from Contract c where c.user = '6L' ")
	List<String> findByIdPerson2();


	
	@Query("Select c from Contract c where c.Type=:type ")
	public List<Contract> retrieveContractsbytype(@Param("type")ContractType type);
	
	@Query("Select c from Contract c where c.Type=:type ")
	public Contract retrieveContractsbytype2(@Param("type")ContractType type);

	@Query("Select u from USER u")
	public List<User> retrieveallusers();
	
	@Query("Select u from USER u where u.id=:id")
	public User retrieveUser(@Param("id")Long id);
	
	/*@Query("select c from Contract c order by c.duration desc")
	public List<Contract> sortByDuration();*/
	   @Query("select c from Contract c WHERE c.Type = 'casDeces' ")
	    public Contract findContrat();
	   @Query("select c from Contract c WHERE c.Type = 'VieEntiere' ")
	    public Contract findContrat2();
	   @Query("select c from Contract c WHERE c.Type = 'TemporairedecesEmprunteur' ")
	    public Contract findContrat3();
	   @Query("select c from Contract c  JOIN c.user u Join u.sinisterList l where l.typeSinistre ='casDecesperiodique' AND c.Type = 'casDecesperiodique' AND u.id=:id ")
	    public Contract findContrat4(@Param("id")long id);

}