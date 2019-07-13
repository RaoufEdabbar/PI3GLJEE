package pi.domain.ejb;

import javax.ejb.Local;
import pi.esprit.entities.Categories;
import java.util.List;

@Local
public interface CategoryFacadeLocal {

	void save(Categories category);
	void edit(Categories category);
	Categories find(Object id);
	void remove(Categories category);
	List<Categories> all();
}
