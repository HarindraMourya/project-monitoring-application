package edu.pma.helper;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.pma.dto.StudentProjectDTO;

public class StudentProjectHelper {
	private static SessionFactory factory;
	boolean isInsert=true;
	public boolean insertProject(StudentProjectDTO dto)
	{
		try{
			factory=new Configuration().configure().addAnnotatedClass(edu.pma.dto.StudentProjectDTO.class).buildSessionFactory();
			}catch(Throwable ex)
			{
				isInsert=false;
				System.err.println("Failed to crete session factory object."+ex);
				throw new ExceptionInInitializerError(ex);		
			}
			Session session=factory.openSession();
			Transaction tx = null;
			
			
			try{
			
				tx = session.beginTransaction();
				session.save(dto);
				tx.commit();
				}catch (HibernateException e) {
					isInsert=false;
				if (tx!=null) tx.rollback();
				e.printStackTrace();
				}finally {
				session.close();
				}
			return isInsert;
	
	}
}
