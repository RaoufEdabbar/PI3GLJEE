package pi.esprit.services;

import java.util.List;

import javax.ejb.EJB;

import pi.domain.ejb.admin.MemberFacadeLocal;
import pi.esprit.entities.Members;

public class MemberAdminServices {
	
	@EJB 
	MemberFacadeLocal memberEjb;
	
	public List<Members> all()
	{
		return memberEjb.all();
	}

}
