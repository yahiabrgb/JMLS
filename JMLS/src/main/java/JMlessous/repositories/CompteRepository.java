package JMlessous.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import JMlessous.entities.Compte;

@Repository
public interface CompteRepository  extends JpaRepository<Compte,Long> {

}
