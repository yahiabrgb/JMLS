package JMlessous.services;
import java.util.List;
import org.apache.logging.log4j.LogManager; 
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import JMlessous.entities.Reclamation;
import JMlessous.repositories.ReclamationRepository;

@Service
public class ReclamationServiceImpl implements IReclamationService{
	@Autowired 
	ReclamationRepository recRepository;
	private static final Logger  L =LogManager.getLogger(ReclamationServiceImpl.class);
	
	//**********************************Retrieve********************************************
	@Override
	public List <Reclamation> retrieveAllReclamations(){
		List<Reclamation> list =(List<Reclamation>) recRepository.findAll();
		for (Reclamation p: list)
		{L.info("reclamation +++: "+ p);
		}	
		return list;
	}


	//**********************Ajout***************************************************************
	@Override
	public Reclamation addReclamation(Reclamation p) {
		Reclamation recSaved=null;
		recSaved =recRepository.save(p);
		return recSaved;
	}
	@Override
	public void deleteReclamation(String id) {
		recRepository.deleteById(Long.parseLong(id));

	}
	@Override
	public Reclamation updateReclamation(Reclamation p) {
		return recRepository.save(p);

	}
	@Override
	public Reclamation retrieveReclamation(String id) {
		L.info(("in retrieveReclamation id = " +id));
		Reclamation p = recRepository.findById(Long.parseLong(id)).orElse(null);
		
		L.info("Reclmation returned : "+p);
		return p;
	}


}
