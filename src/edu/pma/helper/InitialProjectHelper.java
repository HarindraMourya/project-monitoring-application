package edu.pma.helper;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import edu.pma.dto.InitialProjectDTO;

public class InitialProjectHelper {
	private static SessionFactory factory;
	
	public boolean isInsert(InitialProjectDTO dto)
	{
		boolean isInsert=true;
		try{
			factory=new Configuration().configure().addAnnotatedClass(edu.pma.dto.InitialProjectDTO.class).buildSessionFactory();
			}catch(Throwable ex)
			{
				isInsert=false;
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
					isInsert=false;
				if (tx!=null) tx.rollback();
				e.printStackTrace();
				}finally {
				session.close();
				}
				
			
			
		return isInsert;
	}
	public List getProjectId(InitialProjectDTO dto)
	{
		List id=null;
		
		try{
			factory=new Configuration().configure().addAnnotatedClass(edu.pma.dto.InitialProjectDTO.class).buildSessionFactory();
			}catch(Throwable ex)
			{
				
				System.err.println("Failed to crete session factory object."+ex);
				throw new ExceptionInInitializerError(ex);		
			}
			Session session=factory.openSession();
			Transaction tx = null;
			try{
				
				tx = session.beginTransaction();
				String hql="select M.projectId from InitialProjectDTO M where M.name=:name and M.technology=:technology and "
						+ "M.description=:description";
				Query query=session.createQuery(hql);
				query.setParameter("name", dto.getName());
				query.setParameter("technology", dto.getTechnology());
				query.setParameter("description", dto.getDescription());
                id=query.list();  
				System.out.println("id H="+id);
				}catch (HibernateException e) {
					
				if (tx!=null) tx.rollback();
				e.printStackTrace();
				}finally {
				session.close();
				}
				
			
			
		return id;
	}

}
