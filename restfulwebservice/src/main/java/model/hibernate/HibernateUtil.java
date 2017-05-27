package model.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
 
public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	 
    //ServiceRegistryBuilder and buildSessionFactory() in Hibernate 5 is deprecated
    private static SessionFactory buildSessionFactory() {
        try {
        	Configuration conf = new Configuration().configure("hibernate.cfg.xml");
        	StandardServiceRegistryBuilder builder= new StandardServiceRegistryBuilder().applySettings(conf.getProperties());
        	ServiceRegistry sr = builder.build();
        	SessionFactory factory = conf.buildSessionFactory(builder.build());

            // Create the SessionFactory from hibernate.cfg.xml
            return conf.buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
 
    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
    
    public static void main(String[] args) {
    	buildSessionFactory();
        System.out.println("cấu hình thành công");
    }

 
}