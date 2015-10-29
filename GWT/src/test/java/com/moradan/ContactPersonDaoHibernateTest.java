//package com.moradan;
//
//import com.moradan.server.dao.ContactPersonHibernateDao;
//import com.moradan.server.service.ContactPersonService;
//import com.moradan.server.util.HibernateUtil;
//import com.moradan.shared.ContactList;
//import com.moradan.shared.domain.ContactPerson;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//import java.util.*;
//
///**
// * Created by Саша on 14.08.2015.
// * {@link http://viralpatel.net/blogs/hibernate-many-to-many-xml-mapping-example/}
// */
//public class ContactPersonDaoHibernateTest {
//
//    @Before
//    public void setUp(){}
//
//    /**
//     * ehCache | hibernate cache configuration file | hibernate configuration file for mysql
//     * *************************************************************************************
//     * {@link http://www.tutorialspoint.com/hibernate/hibernate_caching.htm}
//     * {@link http://howtodoinjava.com/2013/07/04/hibernate-ehcache-configuration-tutorial/}
//     * {@link http://www.1maven.com/idartifact/org.hibernate:hibernate-ehcache:3.6.8.Final}
//     *
//     * {@link http://forum.spring.io/forum/spring-projects/data/1354-how-do-i-setup-ehcache-with-spring-and-hibernate}
//     * {@link http://www.mkyong.com/ehcache/ehcache-hello-world-example/}
//     */
//    @Test
//    public void testAdd() {
//        ContactPersonHibernateDao dao = new ContactPersonHibernateDao(HibernateUtil.getSessionFactory());
//        int first = dao.getContactDetails().size();
//
//        dao.addContact(UUID.randomUUID().toString(),"firstName-1","lastName-1","contact1@email.com");
//        dao.addContact(UUID.randomUUID().toString(),"firstName-2","lastName-2","contact2@email.com");
//        dao.addContact(UUID.randomUUID().toString(),"firstName-3","lastName-3","contact3@email.com");
//
//        int last     = dao.getContactDetails().size();
//        int result   = last - first;
//        int actual   = result;
//        int expected = 3;
//
//        assertEquals("(All-Add) ContactPerson:",expected,actual);
////        System.out.println( "(All-Add) ContactPerson: " + first + " >> " + last + " = " + result + ";" );
//    }
//
//    @Test
//    public void testGetAll() {
//        ContactPersonHibernateDao dao = new ContactPersonHibernateDao(HibernateUtil.getSessionFactory());
//
//        dao.addContact(UUID.randomUUID().toString(),"firstName-1","lastName-1","contact1@email.com");
//        dao.addContact(UUID.randomUUID().toString(),"firstName-2","lastName-2","contact2@email.com");
//        dao.addContact(UUID.randomUUID().toString(),"firstName-3","lastName-3","contact3@email.com");
//
//        String actual0 = dao.getContactDetails().get(0).getLastName();
//        String actual1 = dao.getContactDetails().get(1).getLastName();
//        String actual2 = dao.getContactDetails().get(2).getLastName();
//        String expected0 = "lastName-3";
//        String expected1 = "lastName-2";
//        String expected2 = "lastName-1";
//
////        assertEquals("(Get-All) ContactPerson:",expected0,actual0);
////        assertEquals("(Get-All) ContactPerson:",expected1,actual1);
////        assertEquals("(Get-All) ContactPerson:",expected2,actual2);
//        System.out.println(actual0);
//        System.out.println(actual1);
//        System.out.println(actual2);
//    }
//
//    @Test
//    public void testDelete() {
//        ContactPersonHibernateDao dao = new ContactPersonHibernateDao(HibernateUtil.getSessionFactory());
//
//        dao.addContact(UUID.randomUUID().toString(),"firstName-1","lastName-1","contact1@email.com");
//        dao.addContact(UUID.randomUUID().toString(),"firstName-2","lastName-2","contact2@email.com");
//        dao.addContact(UUID.randomUUID().toString(),"firstName-3","lastName-3","contact3@email.com");
//
//        int first = dao.getContactDetails().size();
//
//        ArrayList<String> ids = new ArrayList<String>();
//        for (ContactPerson contact : dao.getContactDetails())
//            dao.deleteContact(contact.getId());
//
//        int last     = dao.getContactDetails().size();
//        int result   = first - last;
//        int actual   = first - result;
//        int expected = 0;
//
//        assertEquals("(All-Delete) ContactPerson:",expected,actual);
////        System.out.println( "(All-Delete) ContactPerson: " + first + " >> " + last + " = " + (first-result) + ";" );
//    }
//}
