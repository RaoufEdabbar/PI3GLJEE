package pi.esprit.api;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.mindrot.jbcrypt.BCrypt;

import pi.domain.ejb.MemberFacadeLocal;
import pi.esprit.entities.Members;

@Path("member")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class MemberResource {
	
	@EJB
	MemberFacadeLocal memberEjb;
	
	
	@Path("/register")
	@POST
	public Response register(Members member)
	{	
		member.setPassword(BCrypt.hashpw(member.getPassword(), BCrypt.gensalt()));
		
		memberEjb.register(member);
		
		return Response.status(201).build();
	}
	
	
	@Path("/login")
	@POST
	public Response login(Members member)
	{
		List<Members> m  = memberEjb.login(member);
		
		if(! m.isEmpty() && isValidPassword(member.getPassword(), m.get(0).getPassword()))
			return Response.status(201).build();
		
		return Response.status(403).build();
		
	}
	
	@Path("/profil/{id}")
	@GET
	public Response profil(@PathParam("id") int id)
	{
		Members member = memberEjb.find(id);
		return Response.ok().status(201).entity(member).build();
	}
	
	@Path("/profil/update")
	@PUT
	public Response update(Members member)
	{
		memberEjb.update(member);
		return Response.status(201).build();
		
	}
	
	private boolean isValidPassword(String plainPassword, String hashedPassword) {
		if (BCrypt.checkpw(plainPassword, hashedPassword))
			return true;
		else
			return false;
	}

}
