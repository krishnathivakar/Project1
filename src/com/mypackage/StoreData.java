package com.mypackage;
  

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;  
  
public class StoreData {  
  
    public static void main( String[] args )  
    {  
         StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
            Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
          
        SessionFactory factory = meta.getSessionFactoryBuilder().build();  
        Session session = factory.openSession();  
        Transaction t = session.beginTransaction();  
          
         Employee e1=new Employee();    
            e1.setId(5);    
            e1.setFirstName("Gauravss");    
            e1.setLastName("Chawl");    
         
       session.save(e1);  
      
       t.commit();  
       System.out.println("successfully saved");  
       listCourse();
        factory.close();  
        session.close();     
    }
    
    public static void listCourse()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List courses = session.createQuery("from Employee").list();
			for (Iterator iterator = courses.iterator(); iterator.hasNext();)
			{
				Employee course = (Employee) iterator.next();
				System.out.println(course.getFirstName());
			}
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}  
