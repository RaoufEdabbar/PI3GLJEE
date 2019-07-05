package pi.esprit.entities;
// Generated Jul 4, 2019 4:08:41 PM by Hibernate Tools 5.2.11.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Members generated by hbm2java
 */
@Entity
@Table(name = "members", catalog = "otdav")
public class Members implements java.io.Serializable {

	private Integer id;
	private String name;
	private String password;
	private Date birthDate;
	private Integer cin;
	private Integer appliedAt;
	private Date validatedAt;
	private String adress;
	private Integer zip;
	private String mail;
	private Integer phone;
	private String gender;
	private Integer childNumber;
	private String rib;
	private String photo;
	private String immatriculation;
	private String role;
	private String status;
	private Set<Depots> depotses = new HashSet(0);
	private Set<Persons> personses = new HashSet(0);
	private Set<Organizations> organizationses = new HashSet(0);
	private Set<Resignations> resignationses = new HashSet(0);

	public Members() {
	}

	public Members(String name, String password, Date birthDate, Integer cin, Integer appliedAt, Date validatedAt,
			String adress, Integer zip, String mail, Integer phone, String gender, Integer childNumber, String rib,
			String photo, String immatriculation, String role, String status, Set<Depots> depotses, Set<Persons> personses,
			Set<Organizations> organizationses, Set<Resignations> resignationses) {
		this.name = name;
		this.password = password;
		this.birthDate = birthDate;
		this.cin = cin;
		this.appliedAt = appliedAt;
		this.validatedAt = validatedAt;
		this.adress = adress;
		this.zip = zip;
		this.mail = mail;
		this.phone = phone;
		this.gender = gender;
		this.childNumber = childNumber;
		this.rib = rib;
		this.photo = photo;
		this.immatriculation = immatriculation;
		this.role = role;
		this.status = status;
		this.depotses = depotses;
		this.personses = personses;
		this.organizationses = organizationses;
		this.resignationses = resignationses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 254)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", length = 254)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "birth_date", length = 19)
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "cin")
	public Integer getCin() {
		return this.cin;
	}

	public void setCin(Integer cin) {
		this.cin = cin;
	}

	@Column(name = "applied_at")
	public Integer getAppliedAt() {
		return this.appliedAt;
	}

	public void setAppliedAt(Integer appliedAt) {
		this.appliedAt = appliedAt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "validated_at", length = 19)
	public Date getValidatedAt() {
		return this.validatedAt;
	}

	public void setValidatedAt(Date validatedAt) {
		this.validatedAt = validatedAt;
	}

	@Column(name = "adress", length = 254)
	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Column(name = "zip")
	public Integer getZip() {
		return this.zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	@Column(name = "mail", length = 254)
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Column(name = "phone")
	public Integer getPhone() {
		return this.phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	@Column(name = "gender", length = 2)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "child_number")
	public Integer getChildNumber() {
		return this.childNumber;
	}

	public void setChildNumber(Integer childNumber) {
		this.childNumber = childNumber;
	}

	@Column(name = "rib", length = 254)
	public String getRib() {
		return this.rib;
	}

	public void setRib(String rib) {
		this.rib = rib;
	}

	@Column(name = "photo", length = 254)
	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Column(name = "immatriculation", length = 254)
	public String getImmatriculation() {
		return this.immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	@Column(name = "role", length = 6)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "status", length = 254)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "members")
	public Set<Depots> getDepotses() {
		return this.depotses;
	}

	public void setDepotses(Set<Depots> depotses) {
		this.depotses = depotses;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "members")
	public Set<Persons> getPersonses() {
		return this.personses;
	}

	public void setPersonses(Set<Persons> personses) {
		this.personses = personses;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "members")
	public Set<Organizations> getOrganizationses() {
		return this.organizationses;
	}

	public void setOrganizationses(Set<Organizations> organizationses) {
		this.organizationses = organizationses;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "members")
	public Set<Resignations> getResignationses() {
		return this.resignationses;
	}

	public void setResignationses(Set<Resignations> resignationses) {
		this.resignationses = resignationses;
	}

}