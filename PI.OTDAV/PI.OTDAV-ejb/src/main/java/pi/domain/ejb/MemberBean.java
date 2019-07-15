package pi.domain.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pi.esprit.entities.Members;
import pi.esprit.enumeration.MemberRole;
import pi.esprit.enumeration.MemberStatus;

@Stateless
public class MemberBean implements MemberFacadeLocal {

	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void register(Members member) {
		
		member.setStatus(MemberStatus.CREATED);
		member.setRole(MemberRole.USER);
		
		em.persist(member);
	}

	@Override
	public List<Members> login(Members member) {
		
		List m =  em.createNativeQuery("select * from members where mail = :email", Members.class)
				.setParameter("email", member.getMail())
				.getResultList();
		
		return m;
	}

	@Override
	public void update(Members member) {
		
		Members m = this.find(member.getId());
		m.setName(member.getName());
		m.setAdress(member.getAdress());
		m.setBirthDate(member.getBirthDate());
		m.setChildNumber(member.getChildNumber());
		m.setGender(member.getGender());
		m.setImmatriculation(member.getImmatriculation());
		m.setMail(member.getMail());
		m.setZip(member.getZip());
		m.setRib(member.getRib());
		
		em.persist(m);
	}

	@Override
	public Members find(int id) {
		return em.find(Members.class, id);
	}

}
