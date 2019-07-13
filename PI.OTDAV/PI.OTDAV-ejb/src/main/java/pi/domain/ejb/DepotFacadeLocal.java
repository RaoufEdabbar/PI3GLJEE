package pi.domain.ejb;

import java.util.List;
import javax.ejb.Local;
import pi.esprit.entities.Depots;

@Local
public interface DepotFacadeLocal {
	
	    void save(Depots depot);
		void edit(Depots depot);
		Depots find(Object id);
		void remove(Depots depot);
		List<Depots> all();

}
