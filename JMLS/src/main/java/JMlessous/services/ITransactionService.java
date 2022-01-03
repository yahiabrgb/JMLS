package JMlessous.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import JMlessous.entities.*;

public interface ITransactionService {
	
	public List<Transaction> RetrieveLastNTransactions(int n);

	List<Transaction> RetrieveallTransactions();

	String simulateur(Long d, int m);

	String simulateur2(Long d, int m);

	String cptendettement(double s, Long ppm);


	List<Transaction> RetrieveTransactionsbydate(String d1, String d2);

	Transaction addTransaction(Transaction n);


}
