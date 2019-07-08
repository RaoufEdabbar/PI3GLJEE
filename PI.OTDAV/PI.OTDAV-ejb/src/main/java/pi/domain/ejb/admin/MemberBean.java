package pi.domain.ejb.admin;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pi.esprit.entities.Members;
import pi.esprit.entities.Persons;

@Stateless
public class MemberBean implements MemberFacadeRemote {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void save(Members member) {
		em.persist(member);
	}

	@Override
	public void edit(Members member) {
		
		Members m = this.find(member.getId());
		m.setName(member.getName());
		m.setAdress(member.getAdress());
		m.setBirthDate(member.getBirthDate());
		m.setChildNumber(member.getChildNumber());
		m.setGender(member.getGender());
		m.setImmatriculation(member.getImmatriculation());
		m.setMail(member.getMail());
		m.setPassword(member.getPassword());
		m.setValidatedAt(member.getValidatedAt());
		m.setZip(member.getZip());
		m.setRib(member.getRib());
		m.setRole(member.getRole());
		
		em.persist(m);
	}

	@Override
	public Members find(Object id) {		
		return em.find(Members.class, id);
	}

	@Override
	public void remove(Members member) {
		em.remove(em.merge(member));
	}

	@Override
	public List<Members> all() {
		return em.createQuery("from Members", Members.class).getResultList();
	}

}
