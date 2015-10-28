package com.moradan.server.dao;

import com.moradan.shared.domain.ContactPerson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
* Created by alexandr on 28.10.15.
*/
public class ContactPersonHibernateDao {

    private SessionFactory factory;

    public ContactPersonHibernateDao(){}
    public ContactPersonHibernateDao(SessionFactory factory){
        this.factory = factory;
    }

    public ContactPerson find(String id){
        ContactPerson contact = null;
        Session session = null;
        try {
            session = factory.openSession();
            contact = (ContactPerson)session.load(ContactPersonHibernateDao.class, id);
        } catch (ExceptionInInitializerError error){
//            System.err.println("[find-by-id] " + error.getMessage());
        } finally {
            if(session != null && session.isOpen()) {
                session.close();
            }
        }
        return contact;
    }

    public List<ContactPerson> getAll(){
        List<ContactPerson> contacts = null;
        Session session = null;
        try {
            session = factory.openSession();
            contacts = session.createCriteria(ContactPerson.class).list();
        } catch (ExceptionInInitializerError error){
//            System.err.println("[get-all] " + error.getMessage());
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
        return contacts;
    }

    public void add(ContactPerson contact){
        Session session = null;
        Transaction transaction = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.save(contact);
            transaction.commit();
        } catch (ExceptionInInitializerError error){
//            System.err.println("[get-all] " + error.getMessage());
            transaction.rollback();
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public void delete(String id){
        Session session = null;
        Transaction transaction = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            ContactPerson contact = (ContactPerson)session.load(ContactPerson.class, id);
            session.delete(contact);
            transaction.commit();
        } catch (ExceptionInInitializerError error){
//            System.err.println("[delete-id] " + error.getMessage());
            transaction.rollback();
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }

    public void update(ContactPerson contact){
        Session session = null;
        Transaction transaction = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.update(contact);
            transaction.commit();
        } catch (ExceptionInInitializerError error){
//            System.err.println("[update] " + error.getMessage());
            transaction.rollback();
        } finally {
            if(session != null && session.isOpen()){
                session.close();
            }
        }
    }

}
