package JMlessous.entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(	name = "transaction")
public class Transaction implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;

	@NotBlank
	private Double montant;

	private String emetteur;

	private String receveur;
	
	@NotBlank
	private Date date;
	
	@NotBlank
	private Time heure;
	
	@NotBlank
	private String type;

	private Double solde_rec;
	
	private Double solde_em;

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getEmetteur() {
		return emetteur;
	}

	public void setEmetteur(String emetteur) {
		this.emetteur = emetteur;
	}

	public String getReceveur() {
		return receveur;
	}

	public void setReceveur(String receveur) {
		this.receveur = receveur;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getHeure() {
		return heure;
	}

	public void setHeure(Time heure) {
		this.heure = heure;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getSolde_rec() {
		return solde_rec;
	}

	public void setSolde_rec(Double solde_rec) {
		this.solde_rec = solde_rec;
	}

	public Double getSolde_em() {
		return solde_em;
	}

	public void setSolde_em(Double solde_em) {
		this.solde_em = solde_em;
	}

	public Transaction(Long numero, @NotBlank Double montant, String emetteur, String receveur, @NotBlank Date date,
			@NotBlank Time heure, @NotBlank String type, Double solde_rec, Double solde_em) {
		super();
		this.numero = numero;
		this.montant = montant;
		this.emetteur = emetteur;
		this.receveur = receveur;
		this.date = date;
		this.heure = heure;
		this.type = type;
		this.solde_rec = solde_rec;
		this.solde_em = solde_em;
	}
public Transaction() {};
	
}

