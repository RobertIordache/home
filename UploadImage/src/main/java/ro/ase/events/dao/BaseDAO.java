package ro.ase.events.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jboss.jandex.ThrowsTypeTarget;

import ro.ase.events.utils.HibernateSessionFactory;

public class BaseDAO <T>{
	
	 HibernateSessionFactory factory;
	 private Session session;
	 private Class<T> clazz;
	 
	 
	 
	 
	 public BaseDAO(Class<T> clazz) {
		super();
		this.factory=HibernateSessionFactory.getInstance();
		this.clazz = clazz;
	}


	protected void openSession(){
		 this.session=factory.getSessionFactory().openSession();
	 }
	
	 
	 protected void closeSession(){
		 if(this.session.isOpen() || this.session!=null){
			 this.session.close();
		 }
	 }
	 
	 
	 public void saveObject(T object){
		 openSession();
		 Transaction transaction=null;
		 try{
			 transaction=this.session.beginTransaction();
			 this.session.save(object);
			 transaction.commit();
		 }catch(HibernateException ex){
			 if(transaction!=null)
				 transaction.rollback();
		 }finally{
			 closeSession();
		 }
		
	 }
	 
	 public void updateObject(T object){
		 openSession();
		 Transaction transaction=null;
		 try{
			 transaction=this.session.beginTransaction();
			 this.session.update(object);
			 transaction.commit();
		 }catch(HibernateException ex){
			 if(transaction!=null)
				 transaction.rollback();
		 }finally{
			 closeSession();
		 }
		
	 }
	 
	 public void deleteObject(T object){
		 openSession();
		 Transaction transaction=null;
		 try{
			 transaction=this.session.beginTransaction();
			 this.session.delete(object);
			 transaction.commit();
		 }catch(HibernateException ex){
			 if(transaction!=null)
				 transaction.rollback();
		 }finally{
			 closeSession();
		 }
		
	 }
	 
	 public T getObject(int id){
		 T object=null;
		 openSession();
		 Transaction transaction=null;
		 try{
			 transaction=this.session.beginTransaction();
			 object=this.session.get(clazz,id);
			 transaction.commit();
		 }catch(HibernateException ex){
			 if(transaction!=null)
				 transaction.rollback();
		 }finally{
			 closeSession();
		 }
		 
		 if(object==null)throw new HibernateException("The instance of "+clazz.getSimpleName()+" that you want to access doesn't exist.");
		return object;
	 }
	 
}
