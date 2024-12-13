package org.david;

import com.mysql.cj.xdevapi.SessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import javax.transaction.Transaction;
import java.util.Collection;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml)
            // config file.
            sessionFactory = (SessionFactory) new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception.
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}