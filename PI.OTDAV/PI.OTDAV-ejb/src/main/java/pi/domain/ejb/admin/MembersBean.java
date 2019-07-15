package pi.domain.ejb.admin;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pi.email.logic.Mailin;
import pi.esprit.entities.Members;
import pi.esprit.enumeration.MemberStatus;

@Stateless
public class MembersBean implements MemberFacadeLocal {

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

	@Override
	public void validate(Object id) {
		
		Members member = this.find(id);
		member.setValidatedAt( new Timestamp(System.currentTimeMillis()));
		member.setStatus(MemberStatus.ACCEPTED);
		em.persist(member);
		
		sendAccecptedNotification(member.getMail());
	}
	
	@Override
	public void reject(Object id)
	{
		Members member = this.find(id);
		member.setValidatedAt(new Timestamp(System.currentTimeMillis()));
		member.setStatus(MemberStatus.REJECTED);
		em.persist(member);
	}
	
	private void sendAccecptedNotification(String email)
	{
		Mailin http = new Mailin("https://api.sendinblue.com/v2.0","9y13b8mWFGQOZTxI");
		Map < String, String > to = new HashMap < String, String > ();
			to.put(email, "");

		Map < String, Object > data = new HashMap < String, Object > ();
			data.put("to", to);
			data.put("from", new String [] {"test@gmail.com",""});
			data.put("subject", "Votre demande de regoindre otdav est accepté");
			data.put("html", "This is the <h1>test</h1>");
		String str = http.send_email(data);
		System.out.println(str);
	}
		
}

