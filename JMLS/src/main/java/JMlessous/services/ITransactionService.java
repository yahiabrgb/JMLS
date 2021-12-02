package JMlessous.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import JMlessous.entities.*;

public interface ITransactionService {
	
	public List<Transaction> RetrieveLastNTransactions(int n);

	List<Transaction> RetrieveallTransactions();


}
