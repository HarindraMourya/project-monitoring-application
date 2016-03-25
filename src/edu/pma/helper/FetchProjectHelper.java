package edu.pma.helper;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.pma.dto.InitialProjectDTO;


public class FetchProjectHelper {
	private static SessionFactory factory;
	List<InitialProjectDTO> mail=new ArrayList<>();
	public List<InitialProjectDTO> fetchProject(int id)
	{
		try{
			factory=new Configuration().configure().buildSessionFactory();
			}catch(Throwable ex)
			{
				System.err.println("Failed to crete session factory object."+ex);
				throw new ExceptionInInitializerError(ex);		
			}
		Session session=factory.openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		
		String hql="from InitialProjectDTO I join I.projectId S where I.projectId=:id";
		//String hql="from MailBoxDTO M WHERE M.recevier=:email ";
		System.out.println("before HQL");
		Query query=session.createQuery(hql);
		System.out.println("After HQL");
		query.setParameter("id", id);
		System.out.println("After Parameter ");
		mail =query.list();
		System.out.println("AFter List");
		System.out.println("Projects="+mail);
		return mail;
	}
	

}
