package edu.pma.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.pma.dto.AdminDTO;
import edu.pma.dto.MailBoxDTO;

public class EmailFetcher {
	private static SessionFactory factory;
	List<MailBoxDTO> mail=new ArrayList<>();
	public List<MailBoxDTO> fetchEmail(MailBoxDTO boxDTO)
	{
		try{
			factory=new Configuration().configure().addAnnotatedClass(edu.pma.dto.MailBoxDTO.class).buildSessionFactory();
			}catch(Throwable ex)
			{
				System.err.println("Failed to crete session factory object."+ex);
				throw new ExceptionInInitializerError(ex);		
			}
			Session session=factory.openSession();
			Transaction tx = null;
			tx = session.beginTransaction();
			String hql="from MailBoxDTO M WHERE M.recevier=:email ";
			Query query=session.createQuery(hql);
			query.setParameter("email", boxDTO.getRecevier());
			mail =query.list();
			return mail;
			
			
			
	}

}
