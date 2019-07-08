package pi.domain.ejb.admin;

import java.util.List;
import javax.ejb.Remote;
import pi.esprit.entities.Members;

@Remote
public interface MemberFacadeRemote {
	
	
	void save(Members member);
	void edit(Members member);
    Members find(Object id);
	void remove(Members member);
	List<Members> all();

}
