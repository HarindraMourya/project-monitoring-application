package edu.pma.helper;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.pma.dto.AdminDTO;
import edu.pma.dto.LoginDTO;

public class AdminLoginHelper {
	private static SessionFactory factory;
	boolean isUser=false;
	public boolean login(AdminDTO adminDTO)
	{
		try{
			factory=new Configuration().configure().addAnnotatedClass(edu.pma.dto.AdminDTO.class).buildSessionFactory();
			}catch(Throwable ex)
			{
				System.err.println("Failed to crete session factory object."+ex);
				throw new ExceptionInInitializerError(ex);		
			}
			Session session=factory.openSession();
			Transaction tx = null;
			tx = session.beginTransaction();
			List l=session.createQuery("from AdminDTO").list();
			for(Iterator iterator=l.iterator();iterator.hasNext();)
			{
				AdminDTO obj=(AdminDTO)iterator.next();
				if(obj.getEmail().equals(adminDTO.getEmail()) && obj.getPassword().equals(adminDTO.getPassword()) )
				{
					isUser=true;
					break;
				}
			}
			return isUser;
		
	}


}
