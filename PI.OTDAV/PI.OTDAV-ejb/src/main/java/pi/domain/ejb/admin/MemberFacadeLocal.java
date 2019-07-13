package pi.domain.ejb.admin;

import java.util.List;

import javax.ejb.Local;
import pi.esprit.entities.Members;

@Local
public interface MemberFacadeLocal {
	
	
	void save(Members member);
	void edit(Members member);
    Members find(Object id);
	void remove(Members member);
	List<Members> all();
	void validate(Object id);
	void reject(Object id);

}
