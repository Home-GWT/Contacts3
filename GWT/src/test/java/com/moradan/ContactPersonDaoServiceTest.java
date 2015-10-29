package com.moradan;

import com.moradan.server.dao.ContactPersonHibernateDao;
import com.moradan.server.service.ContactPersonService;
import com.moradan.server.util.HibernateUtil;
import com.moradan.shared.ContactList;
import com.moradan.shared.domain.ContactPerson;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

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

    }
}
