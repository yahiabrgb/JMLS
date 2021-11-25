package JMlessous.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@SuppressWarnings("serial")
@Entity
@Table(name="Compte")
public class Compte implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name="IdCompte")
	private Long idcompte;
	
	@Column(name="Solde_Actuel")
	private float soldeactuel;
	
	@Column(name="Solde_Disponible")
	private float soldedisponible;
		
	@Column(name="Interet")
	private float interet;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Date_de_creation")
	private Date datedecreation;
	
	@Column(name="Type", unique = true)
	private String type;
	
	@Column(name="Devise", unique = true)
	private String devise;
	
	@Column(name="RIB", unique = true)
	private String rib;
	
	@Column(name="Etat")
	private Boolean etat;
	

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "IdUser",referencedColumnName="IdUser")
	 private User user;
	
	public Long getIdcompte() {
		return idcompte;
	}
	
	public Compte(Long idcompte, float soldeactuel, float soldedisponible, float interet, Date datedecreation,
			String type, String devise, String rib, Boolean etat) {
		super();
		this.idcompte = idcompte;
		this.soldeactuel = soldeactuel;
		this.soldedisponible = soldedisponible;
		this.interet = interet;
		this.datedecreation = datedecreation;
		this.type = type;
		this.devise = devise;
		this.rib = rib;
		this.etat = etat;
	}

	public Compte(Long idcompte, float soldeactuel, float soldedisponible, float interet, Date datedecreation,
			String type, String devise, String rib, Boolean etat, User user) {
		super();
		this.idcompte = idcompte;
		this.soldeactuel = soldeactuel;
		this.soldedisponible = soldedisponible;
		this.interet = interet;
		this.datedecreation = datedecreation;
		this.type = type;
		this.devise = devise;
		this.rib = rib;
		this.etat = etat;
		this.user = user;
	}

	public void setIdcompte(Long idcompte) {
		this.idcompte = idcompte;
	}

	public float getSoldeactuel() {
		return soldeactuel;
	}

	public void setSoldeactuel(float soldeactuel) {
		this.soldeactuel = soldeactuel;
	}

	public float getSoldedisponible() {
		return soldedisponible;
	}

	public void setSoldedisponible(float soldedisponible) {
		this.soldedisponible = soldedisponible;
	}
	
	public Date getDatedecreation() {
		return datedecreation;
	}

	public float getInteret() {
		return interet;
	}

	public void setInteret(float interet) {
		this.interet = interet;
	}

	public void setDatedecreation(Date datedecreation) {
		this.datedecreation = datedecreation;
	}


	public String getDevise() {
		return devise;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setDevise(String devise) {
		this.devise = devise;
	}

	public String getRib() {
		return rib;
	}

	public void setRib(String rib) {
		this.rib = rib;
	}

	public Boolean getEtat() {
		return etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Compte() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idcompte == null) ? 0 : idcompte.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		if (idcompte == null) {
			if (other.idcompte != null)
				return false;
		} else if (!idcompte.equals(other.idcompte))
			return false;
		return true;
	}
		
}