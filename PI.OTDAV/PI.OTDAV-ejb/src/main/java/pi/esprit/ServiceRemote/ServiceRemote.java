package pi.esprit.ServiceRemote;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pi.esprit.ImplementationService.IServiceImpUser;
import pi.esprit.entities.Test_Users;


public class ServiceRemote  implements IServiceImpUser{
	@PersistenceContext(unitName = "PI.OTDAV-ejb")
	EntityManager em;

	@Override
	public int addUser(Test_Users user) {
		em.persist(user);
		return (int) user.getId();
	}
	
	
}
