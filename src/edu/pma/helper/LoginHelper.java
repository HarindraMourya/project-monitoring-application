package edu.pma.helper;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.pma.dto.LoginDTO;

public class LoginHelper {
	private static SessionFactory factory;
	boolean isUser=false;
	public boolean login(LoginDTO loginDTO)
	{
		try{
			factory=new Configuration().configure().addAnnotatedClass(edu.pma.dto.LoginDTO.class).buildSessionFactory();
			}catch(Throwable ex)
			{
				System.err.println("Failed to crete session factory object."+ex);
				throw new ExceptionInInitializerError(ex);		
			}
			Session session=factory.openSession();
			Transaction tx = null;
			tx = session.beginTransaction();
			List l=session.createQuery("from LoginDTO").list();
			for(Iterator iterator=l.iterator();iterator.hasNext();)
			{
				LoginDTO obj=(LoginDTO)iterator.next();
				if(obj.getEmail().equals(loginDTO.getEmail()) && obj.getPassword().equals(loginDTO.getPassword()) && obj.getCategory().equals(loginDTO.getCategory()))
				{
					isUser=true;
					break;
				}
			}
			return isUser;
		
	}
	public String getHOD(LoginDTO loginDTO)
	{
		String HOD="";
		try{
			factory=new Configuration().configure().addAnnotatedClass(edu.pma.dto.LoginDTO.class).buildSessionFactory();
			}catch(Throwable ex)
			{
				System.err.println("Failed to crete session factory object."+ex);
				throw new ExceptionInInitializerError(ex);		
			}
			Session session=factory.openSession();
			Transaction tx = null;
			tx = session.beginTransaction();
			List l=session.createQuery("select L.email from LoginDTO L where L.department='CSE' and L.category='HOD'").list();
			for(Iterator iterator=l.iterator();iterator.hasNext();)
			{
				/*LoginDTO obj=(LoginDTO)iterator.next();
				HOD=obj.getEmail();*/
				HOD=(String) iterator.next();
			}
		
		return HOD;
	}
	

}
