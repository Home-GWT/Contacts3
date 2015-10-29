package com.moradan;

import com.moradan.server.dao.ContactPersonHibernateDao;
import com.moradan.server.service.ContactPersonService;
import com.moradan.server.util.HibernateUtil;
import com.moradan.shared.domain.ContactPerson;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Created by Саша on 14.08.2015.
 * {@link http://viralpatel.net/blogs/hibernate-many-to-many-xml-mapping-example/}
 */
public class ContactPersonTest {

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
    public void testMain() {
        ContactPerson contact1 = new ContactPerson(UUID.randomUUID().toString(),"firstName-1","lastName-1","contact1@email.com");
        ContactPerson contact2 = new ContactPerson(UUID.randomUUID().toString(),"firstName-2","lastName-2","contact2@email.com");
        ContactPerson contact3 = new ContactPerson(UUID.randomUUID().toString(),"firstName-3","lastName-3","contact3@email.com");

        ContactPersonHibernateDao dao = new ContactPersonHibernateDao(HibernateUtil.getSessionFactory());
//        ContactPersonService  service = new ContactPersonService(dao);
//
//        service.add(contact1);
//        service.add(contact2);
//        service.add(contact3);

        dao.addContact(contact1.getId(), contact1.getFirstName(), contact1.getLastName(), contact1.getEmailAddress());
        dao.addContact(contact2.getId(), contact1.getFirstName(), contact1.getLastName(), contact1.getEmailAddress());
        dao.addContact(contact3.getId(), contact1.getFirstName(), contact1.getLastName(), contact1.getEmailAddress());

//        Iterator iterator = service.getAll().iterator();
//        while (iterator.hasNext()){
//            System.out.println("ID: " + (ContactPerson)iterator.next());
//        }
    }
}
