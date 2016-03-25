package edu.pma.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.pma.dto.FacultyDTO;

public class FacultyDetailsHelper {

	private static SessionFactory factory;
	public ArrayList<FacultyDTO> faculty =new ArrayList<>();
	public ArrayList<FacultyDTO> fetch()
	{
		try{
			factory=new Configuration().configure().addAnnotatedClass(edu.pma.dto.FacultyDTO.class).buildSessionFactory();
			
		}catch(Throwable ex)
		{
			System.err.println("Failed to crete session factory object."+ex);
			throw new ExceptionInInitializerError(ex);
		}
		
		Session session = factory.openSession();
		Transaction tx = null;
		try{
		tx = session.beginTransaction();
		faculty = (ArrayList<FacultyDTO>)session.createQuery("FROM FacultyDTO F where F.status='Y'").list();
		/*for (Iterator iterator =faculty.iterator(); iterator.hasNext();)
		{
		FacultyDTO facultyDTO = (FacultyDTO) iterator.next();
		faculty.add(facultyDTO);
		}*/
		tx.commit();
		}catch (HibernateException e) {
		if (tx!=null) tx.rollback();
		e.printStackTrace();
		}finally {
		session.close();
		}
		return faculty;
	}
}
