package pi.esprit.api;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pi.domain.ejb.DepotFacadeRemote;
import pi.esprit.entities.Depots;
import pi.esprit.entities.Members;
import pi.esprit.entities.Works;

@Path("/depots")
@Stateless
public class DepotResources {
	@EJB
	private DepotFacadeRemote depotEjb;
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response all()
	{	
		Date date = new Date();
		Members member = new Members();
		Works work = new Works();
		Depots depot = new Depots();
		depot.setCreatedAt(date);
		depot.setName("depot test");
		depot.setMembers(member);
		depot.setWorks(work);
	
		depotEjb.save(depot);
		return Response.ok().entity(depotEjb.all()).build();
	}
	


}
