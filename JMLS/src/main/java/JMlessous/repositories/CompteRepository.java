package JMlessous.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import JMlessous.entities.*;

@Repository
public interface CompteRepository  extends JpaRepository<Compte,Long> {

	@Query("Select c from Compte c where c.user.id=:id")
	public List<Compte> RetrieveActiveUserComptes(@Param("id")Long id);
	
	@Query("Select c from Compte c where c.rib=:rib")
	Compte FindByRib(@Param("rib")String rib);

	@Query("Select u from User u where u.id=:id")
	User RetrieveUser(@Param("id")long id);
	
	@Query("Select c.id from Compte c where c.rib=:rib")
	long RetrieveIdByRib(@Param("rib")String rib);
	
}
