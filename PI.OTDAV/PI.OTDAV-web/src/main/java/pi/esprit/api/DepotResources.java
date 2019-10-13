package pi.esprit.api;

import java.sql.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import pi.domain.ejb.DepotFacadeLocal;
import pi.esprit.entities.Depots;
import pi.esprit.entities.Members;
import pi.esprit.entities.Works;

@Path("/depots")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class DepotResources {

	
	@EJB
	private DepotFacadeLocal depotEjb;

	@GET
	public Response all()
	{	
		return Response.ok().entity(depotEjb.all()).build();
	}
}
