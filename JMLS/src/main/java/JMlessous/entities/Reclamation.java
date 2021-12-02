package JMlessous.entities;
import JMlessous.entities.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static javax.persistence.GenerationType.AUTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

//import javax.validation.constraints.NotEmpty;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reclamation {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long Id;
    @Column(unique = true)
 //   @NotEmpty(message = "Ce champs est obligatoire")
    private String titre;
    private String contenu;
    private String imageUrl;
    //set default status of a plaint to unchecked
    @Column(length = 32, columnDefinition = "varchar(32) default 'UNCHECKED'")
    @Enumerated(value = EnumType.STRING)
    private Status status = Status.UNCHECKED;
    
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
	private Date date_creation;
    @UpdateTimestamp
	private Date date_modif;
	private Boolean urgent; 
	 
	private String service;  
/*	
	@ManyToOne
	@JsonIgnore
	private User user;
	
*/
	
	@JsonIgnore //many plaints to one product
	@ManyToOne
	private Product product;
	

	
}
