package pi.domain.ejb;

import javax.ejb.Remote;
import pi.esprit.entities.Categories;
import java.util.List;

@Remote
public interface CategoryFacadeRemote {

	void save(Categories category);
	void edit(Categories category);
	Categories find(Object id);
	void remove(Categories category);
	List<Categories> all();
}
