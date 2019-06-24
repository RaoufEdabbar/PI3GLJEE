package pi.esprit.ImplementationService;

import javax.ejb.Remote;

import pi.esprit.entities.Test_Users;

@Remote
public interface IServiceImpUser {

	public int addUser(Test_Users  user);
}
