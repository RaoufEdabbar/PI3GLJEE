package pi.domain.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pi.esprit.entities.Categories;

@Stateless
public class CategoryBean implements CategoryFacadeRemote {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void save(Categories category) {
		em.persist(category);

	}

	@Override
	public void edit(Categories category) {
		em.merge(category);
	}

	@Override
	public Categories find(Object id) {
		
		return em.find(Categories.class, id);
	}

	@Override
	public List<Categories> all() {
	
		return em.createQuery("from Categories", Categories.class).getResultList();
	}

	@Override
	public void remove(Categories category) {
		em.remove(em.merge(category));
	}

}
