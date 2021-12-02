package JMlessous.services;
import java.util.List;
import JMlessous.entities.Reclamation;
public interface IReclamationService {
	List<Reclamation> retrieveAllReclamations();
	Reclamation addReclamation (Reclamation p);
	void deleteReclamation (String id);
	Reclamation updateReclamation (Reclamation p);
	Reclamation retrieveReclamation (String id);


}
