package JMlessous.controllers;

import java.util.Date;	
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import JMlessous.entities.Contract;
import JMlessous.entities.User;
import JMlessous.services.IContractService;
import JMlessous.services.IUserService;

@RestController
@CrossOrigin (origins="http://localhost:4200")
public class ContractController {

	@Autowired
	IContractService ic;
	IUserService iu;
	

	
	  @PreAuthorize("hasRole('ROLE_ADMIN')")
	  @GetMapping("/retrieveAllContracts")
	  @ResponseBody
	  public List<Contract> getContract() {
		  List<Contract> c = ic.RetrieveAllContracts();
		  return c;
	  }
		

	  @GetMapping("/RertiveMyContract/{userid}")
	  @ResponseBody
	  public List<Contract> RetrieveContractsByUserId(@PathVariable("userid")long id) {
	  
	  List<Contract> cnt = ic.RetrieveContractsByUserId(id);
	  return cnt;
		}
	  

	  

	  
	  @PreAuthorize("hasRole('ROLE_ADMIN')") 
	  @DeleteMapping("/DeleteExpiredContracts")
	  @ResponseBody
	  public void DeleteExpiredContracts(){
		   ic.DeleteExpiredContracts();
	  }
		
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@DeleteMapping("/DeleteContractsByUserId/{id}")
		@ResponseBody
		public void DeleteContractsByUserID(@PathVariable("id")long id){
			ic.DeleteContractsByUserId(id);
			
		}
		
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@PostMapping("/addContract")
		@ResponseBody	
		public Contract addContract(@RequestBody Contract c) {
			//{	"duration":"5",	"expiration_date":"",	"price":"",	"type":"",	"rate":""}
			//c.setCreation_date(new Date());
			c.setDocument(null);
			
			return ic.AddContract(c);}
		
		@GetMapping("/findByDurationGreater/{Duration}")
		@ResponseBody
		public List<Contract> findByDurationGreater(@PathVariable("Duration") int Duration){
				List<Contract> c = ic.findByDurationGreater(Duration);		 
				  return c;
				  }	
		
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@GetMapping("/ShowNotApprovedContracts")
		@ResponseBody
		public List<Contract> ShowNotApprovedContracts(){
				List<Contract> c = ic.ShowNotApprovedContracts();	 
				  return c;
				  }	
		
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@PutMapping("/ApproveContract/{cntid}")
		@ResponseBody
		public void ApproveContract(@PathVariable("cntid")long cntid){
			ic.ApproveContract(cntid);			
		}
		
		
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@PutMapping("/ContractToUser/{idcnt}/{iduser}")
		@ResponseBody
		public void ContractToUser(@PathVariable("iduser")long iduser,@PathVariable("idcnt")long idcnt)
		{
		ic.ContractToUser(idcnt, iduser);
		}
		
		
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@DeleteMapping("/deletecontract/{idcontract}")
		@ResponseBody
		public void removeContract(@PathVariable("idcontract") Long idcontract) {
		   ic.DeleteContract(idcontract);
		   }
		
		@GetMapping(value="/CountContracts")
		@ResponseBody
		public int CountContracts(){
			return ic.CountContracts();
		}
		
		
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@GetMapping("/TotalPricing")
		@ResponseBody
		public float TotalPricing(){
			float total =0;
			total =ic.TotalPricing();
			return total;
		}
		
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@GetMapping("/TotalCost")
		@ResponseBody
		public float TotalCost(){
			float total =0;
			total =ic.TotalCost();
			return total;
		}

		
		@PutMapping(value = "/MAJcntprice/{cntid}/{userid}/{duree}/{taux}/{C}") 
		@ResponseBody
		public void MAJContractPrice(@PathVariable("cntid")long cntid,@PathVariable("userid")long userid,@PathVariable("duree")int duree,@PathVariable("taux")double taux,@PathVariable("C")float C){
			ic.MAJContractPrice(cntid, userid,duree,taux,C);
		}
		@PutMapping(value = "/MAJcntcost/{cntid}/{userid}/{duree}/{taux}/{P}") 
		@ResponseBody
		public void MAJContractCost(@PathVariable("cntid")long cntid,@PathVariable("userid")long userid,@PathVariable("duree")int duree,@PathVariable("taux")double taux,@PathVariable("P")float P){
			ic.MAJContractCost(cntid, userid,duree,taux,P);
		}
		
		
		@PreAuthorize("hasRole('ROLE_ADMIN')")
		@PutMapping(value = "/MAJcntduration/{cntid}/{duration}") 
		@ResponseBody
	    public void MAJContractDuration(@PathVariable("duration")int duration, @PathVariable("cntid")long cntid){
			ic.MAJContractDuration(duration, cntid);
		}
		

		@PostMapping("/RITP/{p}/{t}/{userid}")
		@ResponseBody  
		public double contractRITP(@PathVariable("p")double p , @PathVariable("t")double t ,@PathVariable("userid")long id)
		{	
			return ic.RITP(p, id,t);
		}
		

		@PostMapping("/RITC/{c}/{t}/{userid}")
		@ResponseBody  
		public double contractRITC(@PathVariable("c")double c , @PathVariable("t")double t ,@PathVariable("userid")long id)
		{	
			return ic.RITC(c, id,t);
		}
		

		@GetMapping("/CVU/{C}/{duree}/{t}/{userid}")
		@ResponseBody 
		public float CapitalVieUnique (@PathVariable("C")float C,@PathVariable("duree") int duree , @PathVariable("t")double t ,@PathVariable("userid")long id){
			
			return ic.CapitalVieUnique(C, id, duree ,t);
			
		}
		

		@GetMapping("/PVU/{prime}/{duree}/{t}/{userid}")
		@ResponseBody 
		public float PrimeVieUnique(@PathVariable("prime")float prime, @PathVariable("duree")int duree , @PathVariable("t")double t ,@PathVariable("userid")long id){
			
			return ic.PrimeVieUnique(prime,  id, duree , t);
		}		

		
		@PostMapping(value="/CapitalMixte/{prime}/{duree}/{userid}")
		@ResponseBody
		public float CapitalMixte(@PathVariable("prime")double prime,@PathVariable("duree")int n ,@PathVariable("userid")long id){
			

			return ic.CapitalMixte(prime, id, n);
			}
		
		

}