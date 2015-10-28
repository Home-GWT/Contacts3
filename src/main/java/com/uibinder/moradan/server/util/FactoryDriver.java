package com.uibinder.moradan.server.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by alexandr on 28.10.15.
 */
public class FactoryDriver {

    private FactoryDriver(){}

    public static SessionFactory getSessionFactory(){
        return factory == null ? factory = new Configuration().configure().buildSessionFactory() : factory;
    }

    private static SessionFactory factory = null;

}
