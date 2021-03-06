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
 * Resignations generated by hbm2java
 */
@Entity
@Table(name = "resignations", catalog = "otdav")
public class Resignations implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Members members;
	private Date resignatiedAt;

	public Resignations() {
	}

	public Resignations(Members members) {
		this.members = members;
	}

	public Resignations(Members members, Date resignatiedAt) {
		this.members = members;
		this.resignatiedAt = resignatiedAt;
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
	@JoinColumn(name = "member_id", nullable = false)
	public Members getMembers() {
		return this.members;
	}

	public void setMembers(Members members) {
		this.members = members;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "resignatied_at", length = 19)
	public Date getResignatiedAt() {
		return this.resignatiedAt;
	}

	public void setResignatiedAt(Date resignatiedAt) {
		this.resignatiedAt = resignatiedAt;
	}

}
