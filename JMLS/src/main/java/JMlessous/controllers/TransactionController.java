package JMlessous.controllers;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	@Autowired
	DeviseService ds;
	@Autowired
DeviseRepository dr;
	TransactionRepository transactionrepository;
	

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
	 
	 
	
	 @GetMapping("/sim/{d}/{m}")
	  @ResponseBody
	  public String simulateur(@PathVariable("d") Long d,@PathVariable("m") int m ){
			  return transactionservice.simulateur(d,m);}
	 
	 @GetMapping("/RetrieveTransactionsbydate/{d1}/{d2}")
	  @ResponseBody
	  public List<Transaction> RetrieveTransactionsbydate(@PathVariable("d1") String d1,@PathVariable("d2") String d2 ){
	 List<Transaction> list = transactionservice.RetrieveTransactionsbydate(d1,d2);
	  return list;}	
	 
		@PostMapping("/addDevise")
		@ResponseBody
		public Devise addDevise(@RequestBody Devise d) {
		 return ds.AjouterDevise(d);}
		
		@PostMapping("/addTransaction")
		@ResponseBody
		public Transaction addTrans(@RequestBody Transaction d) {
		 return transactionservice.addTransaction(d);}
		
		 @GetMapping("/RetrieTransaction")
		 @ResponseBody
		  public List<Transaction> RetrieveTransaction(){
		 List<Transaction> list = transactionservice.RetrieveallTransactions();
		  return list;}	
		 
		 @GetMapping("/Retrievealldevise")
		 @ResponseBody
		  public List<Devise> RetrieveallDevise(){
		 List<Devise> list = dr.RetrieveDevise();
		  return list;}	
		 

		 @PostMapping("/importdevise")
		  @ResponseBody
		  public String importFromExcel() {
			 ExcelImporter ex = new ExcelImporter();
			 List<Devise> listDevise = ex.excelImport();
			 dr.saveAll(listDevise);
			 return "Import Successfully";
		 }
		 
		 @GetMapping("/TNDtoDevise/{somme}")
		  @ResponseBody
		  public double TNDtoDevise(@PathVariable("somme") double s,@RequestBody Devise d) {
			 return ds.TNDtoDevise(d, s);
		 }
		 
		 @GetMapping("/DevisetoTND/{somme}")
		  @ResponseBody
		  public double DevisetoTND(@PathVariable("somme") double s,@RequestBody Devise d) {
			 return ds.DevisetoTND(d, s);
		 }
		
}
