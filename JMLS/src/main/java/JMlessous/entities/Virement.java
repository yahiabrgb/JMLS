package JMlessous.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(	name = "virement")
public class Virement implements Serializable {
	@Id
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
	private Date date_virement;

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

	public Date getDate_virement() {
		return date_virement;
	}

	public void setDate_virement(Date date_virement) {
		this.date_virement = date_virement;
	}

	public Double getNum_compte_rec() {
		return num_compte_rec;
	}

	public void setNum_compte_rec(Double num_compte_rec) {
		this.num_compte_rec = num_compte_rec;
	}

	public Virement(Long numero, @NotBlank Double montant, @NotBlank String emetteur, @NotBlank String receveur,
			@NotBlank @Size(max = 20) @Size(min = 20) Double num_compte, @NotBlank Date date_virement,
			@Size(max = 20) @Size(min = 20) Double num_compte_rec) {
		super();
		this.numero = numero;
		this.montant = montant;
		this.emetteur = emetteur;
		this.receveur = receveur;
		this.num_compte = num_compte;
		this.date_virement = date_virement;
		this.num_compte_rec = num_compte_rec;
	}
	}
