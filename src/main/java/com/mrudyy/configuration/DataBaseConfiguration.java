package com.mrudyy.configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


/**
 * Created by Michael Rudyy on 19-Nov-17.
 */

/**
 * Data Base Util
 * Provide connection to DataBase
 *
 * @author Michael Rudyy
 * @version 1.0
 */

@Configuration
public class DataBaseConfiguration {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        return new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
    }

    @Bean(name = "session")
    @Scope("singleton")
    public SessionImpl getSession(){
        Session session = DataBaseConfiguration.
                getSessionFactory().openSession();
        session.beginTransaction();
        return (SessionImpl) session;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutDown() {
        getSessionFactory().close();
    }
}
