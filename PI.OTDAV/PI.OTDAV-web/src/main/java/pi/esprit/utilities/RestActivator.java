package pi.esprit.utilities;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import pi.domain.ejb.CategoryBean;
import pi.esprit.api.CategoryResources;

@ApplicationPath("api")
public class RestActivator extends Application{

	  private Set<Object> singletons = new HashSet<Object>();
	    private Set<Class<?>> classes = new HashSet<Class<?>>();

	    public RestActivator() {
	        singletons.add(new CategoryResources());
	    }

	    @Override
	    public Set<Class<?>> getClasses() {
	    	
	    	classes.add(CategoryResources.class);
	    	classes.add(CategoryBean.class);
	    	
	        return classes;
	    }

	    @Override
	    public Set<Object> getSingletons() {
	        return singletons;
	    }
}


