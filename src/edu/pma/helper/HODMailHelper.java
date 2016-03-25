package edu.pma.helper;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.pma.dto.HODMailDTO;


public class HODMailHelper {
	private static SessionFactory factory;
	boolean isMail=true;
	public boolean mailHOD(HODMailDTO dto)
	{
		try{
			factory=new Configuration().configure().addAnnotatedClass(edu.pma.dto.HODMailDTO.class).buildSessionFactory();
			}catch(Throwable ex)
			{
				isMail=false;
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
					isMail=false;
				if (tx!=null) tx.rollback();
				e.printStackTrace();
				}finally {
				session.close();
				}
	
		return isMail;
		
	}
	

}
