package JMlessous.entities;

import java.io.File; 
import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="Sinistre")
public class sinister implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="IdSinistre")
	private Long idSinistre ;
	
    @Enumerated(EnumType.STRING)
    @Column(name="TypeSinistre")
	typeSinister typeSinistre;
     
    @Column(name="description")
	private String description;
	@Temporal(TemporalType.DATE)
    @Column(name="DateOccurence")
	private Date dateOccurence;
	
	@Enumerated(EnumType.STRING)
    @Column(name="Status" , nullable=false)
	private sinisterstatus status;
	
	@Column(name="Documents" ,length = Integer.MAX_VALUE , nullable = true )
	private byte[] documents ;
	
	@Enumerated(EnumType.STRING)
    @Column(name="Motif")
	SinisterMotif motifStatus;
	
	@Column(name="Reglementation")
	private float reglemntation ;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID",referencedColumnName="USER_ID")
	@JsonIgnoreProperties("sinisterList")
	@JsonIgnore
	private User user;


	
	public float getReglemntation() {
		return reglemntation;
	}

	public void setReglemntation(float reglemntation) {
		this.reglemntation = reglemntation;
	}

	public Long getIdSinistre() {
		return idSinistre;
	}

	public void setIdSinistre(Long idSinistre) {
		this.idSinistre = idSinistre;
	}

	public typeSinister getTypeSinistre() {
		return typeSinistre;
	}

	public void setTypeSinistre(typeSinister typeSinistre) {
		this.typeSinistre = typeSinistre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateOccurence() {
		return dateOccurence;
	}

	public void setDateOccurence(Date dateOccurence) {
		this.dateOccurence = dateOccurence;
	}

	public sinisterstatus getStatus() {
		return status;
	}

	public void setStatus(sinisterstatus status) {
		this.status = status;
	}

	public byte[] getDocuments() {
		return documents;
	}

	public void setDocuments(byte[] documents) {
		this.documents = documents;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	public SinisterMotif getMotifStatus() {
		return motifStatus;
	}

	public void setMotifStatus(SinisterMotif motifStatus) {
		this.motifStatus = motifStatus;
	}

	@Override
	public String toString() {
		return "Sinistre [idSinistre=" + idSinistre + ", typeSinistre=" + typeSinistre + ", description=" + description
				+ ", dateOccurence=" + dateOccurence + ", status=" + status + ", documents=" + documents + "]";
	}
	

	public sinister(Long idSinistre, typeSinister typeSinistre, String description, Date dateOccurence,
			sinisterstatus status, byte[] documents, SinisterMotif motifStatus, float reglemntation, User user) {
		super();
		this.idSinistre = idSinistre;
		this.typeSinistre = typeSinistre;
		this.description = description;
		this.dateOccurence = dateOccurence;
		this.status = status;
		this.documents = documents;
		this.motifStatus = motifStatus;
		this.reglemntation = reglemntation;
		this.user = user;
	}

	public sinister(Long idSinistre, typeSinister typeSinistre, String description, Date dateOccurence,
			sinisterstatus status, byte[] documents, User user) {
		super();
		this.idSinistre = idSinistre;
		this.typeSinistre = typeSinistre;
		this.description = description;
		this.dateOccurence = dateOccurence;
		this.status = status;
		this.documents = documents;
		this.user = user;
	}

	public sinister(typeSinister typeSinistre, String description, Date dateOccurence) {
		super();
		this.typeSinistre = typeSinistre;
		this.description = description;
		this.dateOccurence = dateOccurence;
	}

	public sinister(typeSinister typeSinistre, String description, Date dateOccurence, sinisterstatus status,
			byte[] documents, SinisterMotif motifStatus, User user) {
		super();
		this.typeSinistre = typeSinistre;
		this.description = description;
		this.dateOccurence = dateOccurence;
		this.status = status;
		this.documents = documents;
		this.motifStatus = motifStatus;
		this.user = user;
	}

	public sinister(typeSinister typeSinistre, String description, Date dateOccurence, sinisterstatus status,
			byte[] documents, User user) {
		super();
		this.typeSinistre = typeSinistre;
		this.description = description;
		this.dateOccurence = dateOccurence;
		this.status = status;
		this.documents = documents;
		this.user = user;
	}

	public sinister(Long idSinistre,typeSinister typeSinistre, String description,
			Date dateOccurence, sinisterstatus status, byte[] documents) {
		super();
		this.idSinistre = idSinistre;
		this.typeSinistre = typeSinistre;
		this.description = description;
		this.dateOccurence = dateOccurence;
		this.status = status;
		this.documents = documents;
	}

	public sinister() {
		super();
	}

	public sinister(typeSinister typeSinistre, String description, Date dateOccurence, sinisterstatus status,
			byte[] documents, SinisterMotif motifStatus, float reglemntation, User user) {
		super();
		this.typeSinistre = typeSinistre;
		this.description = description;
		this.dateOccurence = dateOccurence;
		this.status = status;
		this.documents = documents;
		this.motifStatus = motifStatus;
		this.reglemntation = reglemntation;
		this.user = user;
	}

	public sinister(typeSinister typeSinistre, String description, Date dateOccurence,
			sinisterstatus status, byte[] documents) {
		super();
		this.typeSinistre = typeSinistre;
		this.description = description;
		this.dateOccurence = dateOccurence;
		this.status = status;
		this.documents = documents;
	}

	
	
	


}