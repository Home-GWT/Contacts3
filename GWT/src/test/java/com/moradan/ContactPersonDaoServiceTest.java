package com.moradan;

import com.moradan.server.dao.ContactPersonHibernateDao;
import com.moradan.server.service.ContactPersonService;
import com.moradan.server.util.HibernateUtil;
import com.moradan.shared.ContactList;
import com.moradan.shared.domain.ContactPerson;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Саша on 14.08.2015.
 * {@link http://viralpatel.net/blogs/hibernate-many-to-many-xml-mapping-example/}
 */
public class ContactPersonDaoServiceTest {

    @Before
    public void setUp(){}

    /**
     * ehCache | hibernate cache configuration file | hibernate configuration file for mysql
     * *************************************************************************************
     * {@link http://www.tutorialspoint.com/hibernate/hibernate_caching.htm}
     * {@link http://howtodoinjava.com/2013/07/04/hibernate-ehcache-configuration-tutorial/}
     * {@link http://www.1maven.com/idartifact/org.hibernate:hibernate-ehcache:3.6.8.Final}
     *
     * {@link http://forum.spring.io/forum/spring-projects/data/1354-how-do-i-setup-ehcache-with-spring-and-hibernate}
     * {@link http://www.mkyong.com/ehcache/ehcache-hello-world-example/}
     */
    @Test
    public void testAdd() {
        ContactPersonHibernateDao dao = new ContactPersonHibernateDao(HibernateUtil.getSessionFactory());
        ContactPersonService service = new ContactPersonService(dao);

        int first = service.getAll().size();

        service.add(new ContactPerson(UUID.randomUUID().toString(), "firstName-1", "lastName-1", "contact1@email.com"));
        service.add(new ContactPerson(UUID.randomUUID().toString(), "firstName-2", "lastName-2", "contact2@email.com"));
        service.add(new ContactPerson(UUID.randomUUID().toString(), "firstName-3", "lastName-3", "contact3@email.com"));

        int last     = service.getAll().size();
        int result   = last - first;
        int actual   = result;
        int expected = 3;

        assertEquals("(All-Add) ContactPerson:",expected,actual);
//        System.out.println( "(All-Add) ContactPerson: " + first + " >> " + last + " = " + result + ";" );
    }

    @Test
    public void testGetAll() {
        ContactPersonHibernateDao dao = new ContactPersonHibernateDao(HibernateUtil.getSessionFactory());
        ContactPersonService service = new ContactPersonService(dao);

        service.add(new ContactPerson(UUID.randomUUID().toString(), "firstName-1", "lastName-1", "contact1@email.com"));
        service.add(new ContactPerson(UUID.randomUUID().toString(), "firstName-2", "lastName-2", "contact2@email.com"));
        service.add(new ContactPerson(UUID.randomUUID().toString(), "firstName-3", "lastName-3", "contact3@email.com"));

        String actual0 = service.getAll().get(0).getDisplayName();
        String actual1 = service.getAll().get(1).getDisplayName();
        String actual2 = service.getAll().get(2).getDisplayName();
        String expected0 = "firstName-3 lastName-3";
        String expected1 = "firstName-2 lastName-2";
        String expected2 = "firstName-1 lastName-1";

//        assertEquals("(Get-All) ContactPerson:",expected0,actual0);
//        assertEquals("(Get-All) ContactPerson:",expected1,actual1);
//        assertEquals("(Get-All) ContactPerson:",expected2,actual2);
        System.out.println(actual0);
        System.out.println(actual1);
        System.out.println(actual2);
    }

    @Test
    public void testDelete() {
        ContactPersonHibernateDao dao = new ContactPersonHibernateDao(HibernateUtil.getSessionFactory());
        ContactPersonService service = new ContactPersonService(dao);

        dao.addContact(UUID.randomUUID().toString(),"firstName-1","lastName-1","contact1@email.com");
        dao.addContact(UUID.randomUUID().toString(),"firstName-2","lastName-2","contact2@email.com");
        dao.addContact(UUID.randomUUID().toString(),"firstName-3","lastName-3","contact3@email.com");

        int first = service.getAll().size();

        ArrayList<String> ids = new ArrayList<String>();
        for (ContactList contact : service.getAll())
            dao.deleteContact(contact.getId());

        int last     = service.getAll().size();
        int result   = first - last;
        int actual   = first - result;
        int expected = 0;

        assertEquals("(All-Delete) ContactPerson:",expected,actual);
//        System.out.println( "(All-Delete) ContactPerson: " + first + " >> " + last + " = " + (first-result) + ";" );
    }
}

















