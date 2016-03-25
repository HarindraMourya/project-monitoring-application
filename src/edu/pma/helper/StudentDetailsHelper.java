package edu.pma.helper;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.pma.dto.FacultyDTO;
import edu.pma.dto.StudentDTO;

public class StudentDetailsHelper {

	private static SessionFactory factory;
	public ArrayList<StudentDTO> student =new ArrayList<>();
	public ArrayList<StudentDTO> fetch() {
		try{
			factory=new Configuration().configure().addAnnotatedClass(edu.pma.dto.StudentDTO.class).buildSessionFactory();
			
		}catch(Throwable ex)
		{
			System.err.println("Failed to crete session factory object."+ex);
			throw new ExceptionInInitializerError(ex);
		}
		
		Session session = factory.openSession();
		Transaction tx = null;
		try{
		tx = session.beginTransaction();
		student = (ArrayList<StudentDTO>)session.createQuery("FROM StudentDTO").list();
		
		tx.commit();
		}catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		return student;
	}
	

}
