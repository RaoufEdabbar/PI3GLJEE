package pi.domain.ejb;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pi.esprit.entities.Depots;


@Stateless
public class DepotsBean implements DepotFacadeRemote {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(Depots depot) {
		em.persist(depot);
		
	}

	@Override
	public void edit(Depots depot) {
		em.merge(depot);
		
	}

	@Override
	public Depots find(Object id) {
		return em.find(Depots.class, id);
		
	}

	@Override
	public void remove(Depots depot) {
		em.remove(em.merge(depot));
		
	}

	@Override
	public List<Depots> all() {
		return em.createQuery("from Depots", Depots.class).getResultList();
	}
	

}
