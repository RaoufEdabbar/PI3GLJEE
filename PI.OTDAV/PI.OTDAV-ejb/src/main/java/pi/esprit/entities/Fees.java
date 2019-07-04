package pi.esprit.entities;
// Generated Jul 4, 2019 4:08:41 PM by Hibernate Tools 5.2.11.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Fees generated by hbm2java
 */
@Entity
@Table(name = "fees", catalog = "otdav")
public class Fees implements java.io.Serializable {

	private Integer id;
	private Works works;
	private Date payedAt;
	private Date canceledAt;

	public Fees() {
	}

	public Fees(Works works) {
		this.works = works;
	}

	public Fees(Works works, Date payedAt, Date canceledAt) {
		this.works = works;
		this.payedAt = payedAt;
		this.canceledAt = canceledAt;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "work_id", nullable = false)
	public Works getWorks() {
		return this.works;
	}

	public void setWorks(Works works) {
		this.works = works;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "payed_at", length = 19)
	public Date getPayedAt() {
		return this.payedAt;
	}

	public void setPayedAt(Date payedAt) {
		this.payedAt = payedAt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "canceled_at", length = 19)
	public Date getCanceledAt() {
		return this.canceledAt;
	}

	public void setCanceledAt(Date canceledAt) {
		this.canceledAt = canceledAt;
	}

}
