package JMlessous.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import JMlessous.entities.Reclamation;

@Repository
public interface ReclamationRepository extends CrudRepository <Reclamation,Long>{


}
