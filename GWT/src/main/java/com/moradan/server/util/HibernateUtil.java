package com.moradan.server.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by alexandr on 28.10.15.
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private HibernateUtil(){}

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure("hibernate_mysql.cfg.xml").buildSessionFactory();
        } catch (Exception ex) {
            System.err.println("[Initial SessionFactory creation failed] " + ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}
