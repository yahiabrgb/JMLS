package JMlessous.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import JMlessous.entities.*;
import JMlessous.services.*;
import JMlessous.repositories.*;

@RestController
@CrossOrigin (origins="http://localhost:4200")
public class CompteController {
	
	@Autowired
	CompteService compteservice;
	//TwilioService twilioService;
	CompteRepository compterepository;
	
	private final static Logger Logger=LoggerFactory.getLogger(CompteController.class);

	
	/*@Autowired
	public CompteController(CompteService compteservice, TwilioService twilioService,
			CompteRepository compterepository) {
		super();
		this.compteservice = compteservice;
		this.twilioService = twilioService;
		this.compterepository = compterepository;
	}*/

	// http://localhost:8082/retrieve-all-comptes
	 // @PreAuthorize("hasRole('ROLE_ADMIN')")
	  @GetMapping("/retrieve-all-comptes")
	  @ResponseBody
	  public List<Compte> getComptes(){
		  List<Compte> list = compteservice.RetrieveAllComptes();
		  return list;
	  }
	
	  	@PreAuthorize("hasRole('ROLE_ADMIN')")
		@PostMapping("/add-compte")
		@ResponseBody
		public Compte addCompte(@RequestBody Compte C) {
		Compte cpt = compteservice.AddCompte(C);
		return cpt;
		}
	  	
	  	@PreAuthorize("hasRole('ROLE_ADMIN')")
		@DeleteMapping("/delete-compte/{compte-id}")
		@ResponseBody
		public void removeCompte(@PathVariable("compte-id") long compteId) {
	  		compteservice.DeleteCompte(compteId);
		}
	  	
	  	@PreAuthorize("hasRole('ROLE_USER')")
		@GetMapping("/retrieveuseraccounts/{user-id}")
		@ResponseBody
		public List<Compte> RetrieveActiveUserComptes(@PathVariable("user-id") long userid) {
	  		return compteservice.RetrieveActiveUserComptes(userid);
		}
	  	
	  	/*@GetMapping("/otpverification/{compterib}")
		@ResponseBody
		public String sendOTPandVerify(@PathVariable("compterib") String compterib) {
	  		String phoneNumber = String.valueOf(compterepository.findById(compterepository.RetrieveIdByRib(compterib)).get().getUser().getTelephone());
	  		String code=twilioService.sendOTP("+216"+phoneNumber);
	  		Logger.info(code);
	  		return code;
		}*/
	  	
	  	
	  	@PreAuthorize("hasRole('ROLE_ADMIN')")
	  	@PutMapping("/assigncompte/{compteid}/{userid}")
		@ResponseBody
		public void AssignCompte(@PathVariable("compteid")long compteid,@PathVariable("userid")long userid) {
			compteservice.AssignCompte(compteid,userid);
		}
	  	
}