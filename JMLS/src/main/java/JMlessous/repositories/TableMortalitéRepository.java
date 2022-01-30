package JMlessous.repositories;

import org.springframework.data.jpa.repository.Query;

public interface TableMortalitéRepository {
	@Query("select t.Tv_99 from TableMortalité t where t.x = ?1 ") //LIMIT 1
	float findBySurvivantsLx(int ageClient);

	@Query("select t.Td_99 from TableMortalité t where t.x = ?1 ")
	float findByDecesDx(int deces);
	
	@Query("select t.proba from TableMortalité t where t.x = ?1 ")
	float findProbaByAgeClient(int ageClient);
	
	@Query("select MAX(t.x) from TableMortalité t  ")
	int findAgeMax();
}
