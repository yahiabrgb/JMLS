package JMlessous.services;

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
	public List<Transaction> RetrieveallTransactions() {
		return TransactionRepository.findAll();
	}
}
