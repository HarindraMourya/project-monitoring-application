package edu.pma.helper;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.pma.dto.HODMailDTO;
import edu.pma.dto.MailBoxDTO;

public class HODEmailFetcher {
	private static SessionFactory factory;
	List<HODMailDTO> mail=new ArrayList<>();
	public List<HODMailDTO> fetchHODEmail()
	{
		try{
			factory=new Configuration().configure().addAnnotatedClass(edu.pma.dto.HODMailDTO.class).buildSessionFactory();
			}catch(Throwable ex)
			{
				System.err.println("Failed to crete session factory object."+ex);
				throw new ExceptionInInitializerError(ex);		
			}
			Session session=factory.openSession();
			Transaction tx = null;
			tx = session.beginTransaction();
			String hql="from HODMailDTO ";
			Query query=session.createQuery(hql);
			mail =query.list();
			return mail;
			
			
			
	}

}
