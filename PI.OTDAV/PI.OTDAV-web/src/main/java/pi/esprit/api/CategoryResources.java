package pi.esprit.api;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pi.domain.ejb.CategoryFacadeLocal;

@Path("categories")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class CategoryResources {
	
	@EJB
	private CategoryFacadeLocal categoryEjb;	
	
	
	@GET
	public Response all()
	{	 
		
		return Response.ok().entity(categoryEjb.all()).build();
	}
	
	
	/**
	 * Todo , implements find, create, update, delete method using categoryEjb
	 */
	
}
