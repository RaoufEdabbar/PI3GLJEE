package pi.domain.ejb;

import java.util.List;

import javax.ejb.Local;

import pi.esprit.entities.Members;

@Local
public interface MemberFacadeLocal {
	
	public void register(Members member);
	public List<Members> login(Members member);
	public void update(Members  member);
	public Members find(int id);

}
