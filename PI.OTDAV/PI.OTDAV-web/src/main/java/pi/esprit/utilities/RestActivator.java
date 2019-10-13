package pi.esprit.utilities;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import pi.domain.ejb.CategoryBean;
import pi.domain.ejb.DepotBean;
import pi.domain.ejb.admin.MemberBean;
import pi.esprit.api.CategoryResources;
import pi.esprit.api.DepotResources;
import pi.esprit.api.admin.MemberResources;

@ApplicationPath("api")
public class RestActivator extends Application{

	  private Set<Object> singletons = new HashSet<Object>();
	    private Set<Class<?>> classes = new HashSet<Class<?>>();

	    public RestActivator() {
	        singletons.add(new CategoryResources());
	        singletons.add(new MemberResources());
	        singletons.add(new DepotResources());
	    }

	    @Override
	    public Set<Class<?>> getClasses() {
	    	
	    	classes.add(CategoryResources.class);
	    	classes.add(CategoryBean.class);
	    	classes.add(MemberResources.class);
	    	classes.add(MemberBean.class);
	    	classes.add(DepotResources.class);
	    	classes.add(DepotBean.class);
	    	
	        return classes;
	    }

	    @Override
	    public Set<Object> getSingletons() {
	        return singletons;
	    }
}


