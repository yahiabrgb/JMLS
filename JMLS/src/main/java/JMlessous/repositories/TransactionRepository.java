package JMlessous.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import JMlessous.entities.*;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

	@Query(value = "SELECT * FROM `transaction` order by date desc, heure desc limit :n", nativeQuery = true)
	public List<Transaction> RetrieveLastNTransactions(@Param("n")int n);

	@Query(value = "SELECT * FROM `transaction` where date > :d1 and date< :d2  order by date desc, heure desc", nativeQuery = true)
	public List<Transaction> RetrieveTransactionsbydate(@Param("d1") String d1, @Param("d2") String d2);
	

	@Query(value = "SELECT * FROM `transaction`", nativeQuery = true)
	public List<Transaction> RetrieveTransactions();
	
	

}
