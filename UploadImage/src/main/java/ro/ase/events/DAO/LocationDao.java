package ro.ase.events.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class LocationDao extends BaseDAO {

	private Session cureentSession;
	private Transaction currentTransaction;

	public void openCurestnSesion(){
		cureentSession=factory.getSessionFactory().openSession();
	}
	
	
}
