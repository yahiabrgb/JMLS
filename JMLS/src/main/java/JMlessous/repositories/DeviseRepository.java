package JMlessous.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import JMlessous.entities.Devise;
import JMlessous.entities.Transaction;

@Repository
public interface DeviseRepository extends JpaRepository<Devise, String> {

	@Query(value = "SELECT * FROM `devise` Where `désignation`!= \"Dinar Tunisien\"\r\n", nativeQuery = true)
	public List<Devise> RetrieveDevise();


	
}
