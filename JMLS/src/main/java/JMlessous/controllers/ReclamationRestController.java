
package JMlessous.controllers;
import JMlessous.entities.ResourceNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import JMlessous.entities.Reclamation;
import JMlessous.repositories.ReclamationRepository;
import JMlessous.services.IReclamationService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ReclamationRestController {

	IReclamationService recService;

	ReclamationRepository recRepository;


	@Autowired 
	public ReclamationRestController(IReclamationService recService, ReclamationRepository recRepository) {
		super();
		this.recService = recService;
		this.recRepository = recRepository;
	}
	// URL : http://localhost:8081/SpringMVC/servlet/reclamations
	@GetMapping("/reclamations")
	@ResponseBody
	public List<Reclamation> getReclamations() {
		List<Reclamation> list = recService.retrieveAllReclamations();
		return list;
	}
	// http://localhost:8081/SpringMVC/servlet/reclamations/{rec-id}
	@GetMapping("/reclamations/{id}")
	@ResponseBody
	public Reclamation getReclamation(@PathVariable("id") String id) {
		return recService.retrieveReclamation(id);
	}

	// Ajouter  : http://localhost:8081/SpringMVC/servlet/reclamations
	@PostMapping("/reclamations")
	@ResponseBody
	public Reclamation addReclamation(@RequestBody Reclamation u) {

		Reclamation user = recService.addReclamation(u);

		return user;
	}
	// Supprimer  : http://localhost:8081/SpringMVC/servlet/delete-product/{id}
	@DeleteMapping("/reclamations/{id}")
	@ResponseBody
	public void deleteProduct(@PathVariable("id") String id) {
		recService.deleteReclamation(id);
	}
	

	// Modifier méth1
	// http://localhost:8081/SpringMVC/servlet/reclamations
	 
     /*
     @PutMapping("/reclamations")
	 @ResponseBody
	 public Reclamation updateReclamation(@RequestBody Reclamation p) {
		 return recService.updateReclamation(p);
	 }*/
	
	// Modifier méth2
	@CrossOrigin(origins = "http://localhost:4200")
	 @PutMapping("/reclamations/{id}")
	 @ResponseBody
	 public Reclamation updateReclamation2(@RequestBody Reclamation p, @PathVariable("id") long id) {
		 return recService.updateReclamation(p);

	 }

}
