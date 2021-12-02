package JMlessous.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(	name = "cheque")
public class Cheque implements Serializable {
	@Id
	@Size(max = 7)
	@Size(min = 7)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;

	@NotBlank
	private Double montant;

	@NotBlank
	private String emetteur;

	@NotBlank
	private String receveur;
	
	@NotBlank
	@Size(max = 20)
	@Size(min = 20)
	private Double num_compte;
	
	@NotBlank
	private Date date_signature;
	
	@NotBlank
	private Date date_encaissement;
	
	@NotBlank
	private String etat;
	
	@Size(max = 20)
	@Size(min = 20)
	private Double num_compte_rec;
	
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

	public Double getNum_compte() {
		return num_compte;
	}

	public void setNum_compte(Double num_compte) {
		this.num_compte = num_compte;
	}

	public Date getDate_signature() {
		return date_signature;
	}

	public void setDate_signature(Date date_signature) {
		this.date_signature = date_signature;
	}

	public Date getDate_encaissement() {
		return date_encaissement;
	}

	public void setDate_encaissement(Date date_encaissement) {
		this.date_encaissement = date_encaissement;
	}


	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Double getNum_compte_rec() {
		return num_compte_rec;
	}

	public void setNum_compte_rec(Double num_compte_rec) {
		this.num_compte_rec = num_compte_rec;
	}
}
