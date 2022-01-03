package JMlessous.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import JMlessous.entities.Devise;

@Repository
public interface DeviseRepository extends JpaRepository<Devise, String> {

}
