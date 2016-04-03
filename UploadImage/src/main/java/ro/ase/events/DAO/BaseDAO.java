package ro.ase.events.DAO;

import org.hibernate.Session;

import ro.ase.events.utils.HibernateSessionFactory;

public class BaseDAO {
	
	protected HibernateSessionFactory factory=HibernateSessionFactory.getInstance();
	

}
