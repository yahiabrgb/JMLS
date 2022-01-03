package JMlessous.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import JMlessous.entities.*;
import JMlessous.repositories.TransactionRepository;

@Service
public class TransactionService implements ITransactionService {

	@Autowired
	TransactionRepository TransactionRepository;

	@Override
	public List<Transaction> RetrieveLastNTransactions(int n) {
		return TransactionRepository.RetrieveLastNTransactions(n);
	}
	
@Override
	public Transaction addTransaction(Transaction n) {
		return TransactionRepository.saveAndFlush(n);
	}

	@Override
	public List<Transaction> RetrieveallTransactions() {
		return TransactionRepository.findAll();
	}
	

	@Override
	public List<Transaction> RetrieveTransactionsbydate(String d1, String d2) {
		return TransactionRepository.RetrieveTransactionsbydate(d1,d2);
	}

	@Override
	public String simulateur(Long d, int m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String simulateur2(Long d, int m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String cptendettement(double s, Long ppm) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
