package edu.pma.helper;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.pma.dto.FacultyDTO;

public class FacultyRegistrationHelper {
	private static SessionFactory factory;
	public boolean isRegister(FacultyDTO facultyDTO)
	{
		
		boolean isRegister=true;
		try{
		factory=new Configuration().configure().addAnnotatedClass(edu.pma.dto.FacultyDTO.class).buildSessionFactory();
		}catch(Throwable ex)
		{
			isRegister=false;
			System.err.println("Failed to crete session factory object."+ex);
			throw new ExceptionInInitializerError(ex);		
		}
		Session session=factory.openSession();
		Transaction tx = null;
		
		
		try{
		
			tx = session.beginTransaction();
			session.save(facultyDTO);
			tx.commit();
			}catch (HibernateException e) {
				isRegister=false;
			if (tx!=null) tx.rollback();
			e.printStackTrace();
			}finally {
			session.close();
			}
			
		
		
		return isRegister;
	}


}
