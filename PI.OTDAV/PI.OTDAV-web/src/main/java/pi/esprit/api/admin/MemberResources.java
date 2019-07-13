package pi.esprit.api.admin;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.logging.Param;

import pi.domain.ejb.admin.MemberFacadeLocal;
import pi.esprit.entities.Members;

@Path("admin/members")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class MemberResources {
	
	@EJB
	MemberFacadeLocal memberEjb;
	
	
	@GET
	public Response all()
	{
		return Response.ok().entity(memberEjb.all()).build();
	}
	
	@Path("{id}")
	@GET
	public Response fetchById(@PathParam("id") int id)
	{
		return Response.ok().entity(memberEjb.find(id)).build();
	}
	
	@Path("/save")
	@POST
	public Response create(Members member)
	{
		memberEjb.save(member);
		return Response.ok().build();
	}
	
	@Path("/update")
	@PUT
	public Response update(Members member)
	{
		memberEjb.edit(member);
		
		return Response.ok().build();
	}
	
	@Path("/delete")
	@DELETE
	public Response delete(Members member)
	{
		memberEjb.remove(member);
		
		return Response.ok().build();
	}
	
	@Path("/validate/{id}")
	@POST
	public Response validate(@PathParam("id") int id)
	{
		memberEjb.validate(id);
	
		return Response.ok().build();
	}
	
	@Path("/rejecte/{id}")
	@POST
	public Response reject(@PathParam("id") int id)
	{
		memberEjb.reject(id);
		
		return Response.ok().build();
	}
	
	
	
	

}
