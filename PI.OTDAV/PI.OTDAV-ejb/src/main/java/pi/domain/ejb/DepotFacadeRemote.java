package pi.domain.ejb;
import javax.ejb.Remote;
import pi.esprit.entities.Depots;
import java.util.List;
@Remote
public interface DepotFacadeRemote {

	    void save(Depots depot);
		void edit(Depots depot);
		Depots find(Object id);
		void remove(Depots depot);
		List<Depots> all();
}
