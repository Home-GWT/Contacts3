package com.moradan.server.dao;

import com.moradan.shared.domain.ContactPerson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by alexandr on 13.08.15.
 */
public class ContactPersonHibernateDao {

    private SessionFactory factory;

    public ContactPersonHibernateDao(){}
    public ContactPersonHibernateDao(SessionFactory factory){
        this.factory = factory;
    }

    public ContactPerson getContact(String id){
        Session session = factory.openSession();
        return (ContactPerson) session.get(ContactPerson.class,id);
    }

    public List<ContactPerson> getContactDetails(){
        Session session = factory.openSession();
        return session.createCriteria(ContactPerson.class).list();
    }

    public void addContact(String id, String firstName, String lastName, String emailAddress){
        Session session = null;
        Transaction transaction = null;
        try{
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.save(new ContactPerson(id,firstName,lastName,emailAddress));
            transaction.commit();
        }catch (Exception e1){
            try{
                transaction.rollback();
            }catch (Exception e2){}
        } finally {
            try{
                if(session != null && session.isOpen())
                    session.close();
            } catch (Exception e3){}
        }
    }

    public void updateContact(String id, String firstName, String lastName, String emailAddress){
        Session session = null;
        Transaction transaction = null;
        try{
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.update(new ContactPerson(id,firstName,lastName,emailAddress));
            transaction.commit();
        } catch (Exception e1){
            try{
                transaction.rollback();
            }catch (Exception e2){}
        } finally {
            try{
                if(session != null && session.isOpen())
                    session.close();
            }catch (Exception e3){}
        }
    }

    public void deleteContact(String id){
        Session session = null;
        Transaction transaction = null;
        try {
            session = factory.openSession();
            ContactPerson contact = (ContactPerson) session.get(ContactPerson.class, id);
            transaction = session.beginTransaction();
            session.delete(contact);
            transaction.commit();
        }catch (Exception e1){
            try{
                transaction.rollback();
            }catch (Exception e2){}
        } finally{
            try{
                if(session != null && session.isOpen())
                    session.close();
            }catch (Exception e3){}
        }
    }

}
