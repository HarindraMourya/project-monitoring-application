package edu.pma.helper;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.pma.dto.MailBoxDTO;

public class MailBoxHelper {
	private static SessionFactory factory;
	boolean isSend=false;
	public boolean sendEmail(MailBoxDTO boxDTO)
	{
		try{
			factory=new Configuration().configure().addAnnotatedClass(edu.pma.dto.MailBoxDTO.class).buildSessionFactory();
			}catch(Throwable ex)
			{
				isSend=false;
				System.err.println("Failed to crete session factory object."+ex);
				throw new ExceptionInInitializerError(ex);		
			}
			Session session=factory.openSession();
			Transaction tx = null;
			
			
			try{
			
				tx = session.beginTransaction();
				session.save(boxDTO);
				tx.commit();
				}catch (HibernateException e) {
					isSend=false;
				if (tx!=null) tx.rollback();
				e.printStackTrace();
				}finally {
				session.close();
				}
		return isSend;
	}

}
