package JMlessous.services;

import JMlessous.entities.TableMortalité;

public interface ITableMortaliteService {

	TableMortalité Addtm(TableMortalité t);
	float findBySurvivantsLx(int ageClient);
	float findByDecesDx(int deces);
	 float calcull(float capital , int ageClient, int AgeMax, double taux);
	 float findProbaByAgeClient(int ageClient);
	 int findAgeMax();
}