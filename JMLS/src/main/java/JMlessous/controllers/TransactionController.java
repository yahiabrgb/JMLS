package JMlessous.controllers;

import java.util.List;

import org.hibernate.hql.internal.ast.tree.IsNotNullLogicOperatorNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import JMlessous.entities.*;
import JMlessous.services.*;
import JMlessous.repositories.*;

@RestController
@CrossOrigin (origins="http://localhost:4200")
public class TransactionController {

	@Autowired
	TransactionService transactionservice;
	//TwilioService twilioService;
	TransactionRepository transactionrepository;
	
	private final static Logger Logger=LoggerFactory.getLogger(CompteController.class);

	 @GetMapping("/retrievelastntransaction/{n}")
	  @ResponseBody
	  public List<Transaction> RetrieveLastNTransactions(@PathVariable("n")  int n){
			 List<Transaction> list = transactionservice.RetrieveLastNTransactions(n);
			  return list;}
	 
	 @GetMapping("/retrievelastntransaction")
	  @ResponseBody
	  public List<Transaction> RetrieveallTransactions(){
	 List<Transaction> list = transactionservice.RetrieveallTransactions();
	  return list;}	
	
}
