package pi.esprit.api;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import pi.domain.ejb.CategoryFacadeRemote;
import pi.esprit.entities.Categories;

@Path("/categories")
@Stateless
public class CategoryResources {
	
	@EJB
	private CategoryFacadeRemote categoryEjb;
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response all()
	{	
		Categories categorie = new Categories();
		categorie.setLabel("test");
		categorie.setPrice(1254);
		categoryEjb.save(categorie);
		 return Response.ok().entity(categoryEjb.all()).build();
	}
	
	
	/**
	 * Todo , implements find, create, update, delete method using categoryEjb
	 */
	
}
