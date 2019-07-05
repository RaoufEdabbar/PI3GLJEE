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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Works generated by hbm2java
 */
@Entity
@Table(name = "works", catalog = "otdav")
public class Works implements java.io.Serializable {

	private Integer id;
	private Categories categories;
	private Integer label;
	private String status;
	private Date createdAt;
	private Date renewedAt;
	private Set<Fees> feeses = new HashSet(0);
	private Set<Depots> depotses = new HashSet(0);

	public Works() {
	}

	public Works(Categories categories) {
		this.categories = categories;
	}

	public Works(Categories categories, Integer label, String status, Date createdAt, Date renewedAt, Set<Fees> feeses,
			Set<Depots> depotses) {
		this.categories = categories;
		this.label = label;
		this.status = status;
		this.createdAt = createdAt;
		this.renewedAt = renewedAt;
		this.feeses = feeses;
		this.depotses = depotses;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", nullable = false)
	public Categories getCategories() {
		return this.categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	@Column(name = "label")
	public Integer getLabel() {
		return this.label;
	}

	public void setLabel(Integer label) {
		this.label = label;
	}

	@Column(name = "status", length = 254)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", length = 19)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "renewed_at", length = 19)
	public Date getRenewedAt() {
		return this.renewedAt;
	}

	public void setRenewedAt(Date renewedAt) {
		this.renewedAt = renewedAt;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "works")
	public Set<Fees> getFeeses() {
		return this.feeses;
	}

	public void setFeeses(Set<Fees> feeses) {
		this.feeses = feeses;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "works")
	public Set<Depots> getDepotses() {
		return this.depotses;
	}

	public void setDepotses(Set<Depots> depotses) {
		this.depotses = depotses;
	}

}
