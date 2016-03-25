package edu.pma.helper;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchIdHelper {
	private static SessionFactory factory;
	ArrayList<Integer> id=new ArrayList<>();
	public ArrayList<Integer> fetch(String email)
	{
		try{
			factory=new Configuration().configure().addAnnotatedClass(edu.pma.dto.StudentProjectDTO.class).buildSessionFactory();
			}catch(Throwable ex)
			{
				System.err.println("Failed to crete session factory object."+ex);
				throw new ExceptionInInitializerError(ex);		
			}
			Session session=factory.openSession();
			Transaction tx = null;
			tx = session.beginTransaction();
			String hql="select S.projectId from StudentProjectDTO S where S.email=:email ";
			Query query=session.createQuery(hql);
			query.setParameter("email", email);
			id =(ArrayList<Integer>) query.list();
			return id;
			
	}

}
