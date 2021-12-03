package JMlessous.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class User implements Serializable {
	@Id
	@Column(name="IdUser")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	@Column(unique=true)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	@Column(name="Password")
	private String password;
		
	@Column(name="First_name")
	private String firstname;
		
	@Column(name="Last_name")
	private String lastname;
	
	@Column(name="Résidence")
	private String residence;
	
	@Column(name="Etat_Civile")
	private String etatcivile;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Birthdate")
	private Date birthdate;
			
	@Column(name="CIN",unique=true)
	private int cin;
	
	@Column(name="Phone_Number",unique=true)
	private int phonenumber;
	
	@Column(name="Salary")
	private float salary;

	@ManyToMany
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<Compte> comptes;
	
	public User() {
		super();
	}

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public User(Long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, @Size(max = 20) String firstname,
			@Size(max = 20) String lastname, @Size(max = 20) String residence, @Size(max = 20) String etatcivile,
			Date birthdate, int cin, int phonenumber, float salary, Set<Role> roles, List<Compte> comptes) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.residence = residence;
		this.etatcivile = etatcivile;
		this.birthdate = birthdate;
		this.cin = cin;
		this.phonenumber = phonenumber;
		this.salary = salary;
		this.roles = roles;
		this.comptes = comptes;
	}
	
	public User(Long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, @Size(max = 20) String firstname,
			@Size(max = 20) String lastname, @Size(max = 20) String residence, @Size(max = 20) String etatcivile,
			Date birthdate, int cin, int phonenumber, float salary) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.residence = residence;
		this.etatcivile = etatcivile;
		this.birthdate = birthdate;
		this.cin = cin;
		this.phonenumber = phonenumber;
		this.salary = salary;
	}

	public User(Long id, @NotBlank @Size(max = 120) String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	public String getEtatcivile() {
		return etatcivile;
	}

	public void setEtatcivile(String etatcivile) {
		this.etatcivile = etatcivile;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public int getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}
