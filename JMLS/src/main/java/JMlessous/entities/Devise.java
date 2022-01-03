package JMlessous.entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(	name = "devise")
public class Devise implements Serializable {
	@Id
	private String Désignation;

	private String Code;

	private int Unité;

	private double Achat;
	
	private double Vente;

	public String getDésignation() {
		return Désignation;
	}

	public void setDésignation(String désignation) {
		Désignation = désignation;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public int getUnité() {
		return Unité;
	}

	public void setUnité(int unité) {
		Unité = unité;
	}

	public double getAchat() {
		return Achat;
	}

	public void setAchat(double achat) {
		Achat = achat;
	}

	public double getVente() {
		return Vente;
	}

	public void setVente(double vente) {
		Vente = vente;
	}

	public Devise(String désignation, String code, int unité, double achat, double vente) {
		super();
		Désignation = désignation;
		Code = code;
		Unité = unité;
		Achat = achat;
		Vente = vente;
	}

	public Devise()
	{};
}

