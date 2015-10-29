package com.moradan;

import com.moradan.server.service.ServiceDriver;
import com.moradan.server.service.ServiceMiratex;
import com.moradan.shared.domain.Car;
import com.moradan.shared.domain.Driver;
import com.moradan.shared.domain.Miratex;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
* Created by Саша on 14.08.2015.
* {@link http://viralpatel.net/blogs/hibernate-many-to-many-xml-mapping-example/}
*/
public class DriverTest {

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
    public void testMain1() {
     /* *****************[ 1 ]****************** */
        List<String> friends = new ArrayList<String>();
        friends.add("Marina");
        friends.add("Aleg");
        friends.add("Dnirty");
        friends.add("Toni");
        friends.add("Michael");

        Miratex miratex1 = new Miratex(1,"Sasha","Lazarchuk","Sergey",friends);
        Miratex miratex2 = new Miratex(2,"Any","Nenene","Alexey",friends);
        Miratex miratex3 = new Miratex(3,"Jeny","Barusina","Olya",friends);
        ServiceMiratex service = new ServiceMiratex();
        service.add(miratex1);
        service.add(miratex2);
        service.add(miratex3);

        Miratex miratexX = service.get(1);
        System.out.println("ID: " +  miratexX);

        miratexX.setFriend("Vova");
        service.update(miratexX);

        service.delete(1);

        for (Miratex miratex:service.getAll())
            System.out.println("ID: " +  miratex);
    }

    @Test
    public void testMain2(){
     /* *****************[ 2 ]****************** */
        Car car1 = new Car("road", 123, "white");
        Car car2 = new Car("baggy", 456, "dark");
        Car car3 = new Car("speed", 789, "red");
        List<Car> cars1 = new LinkedList<Car>();
        List<Car>cars2 = new LinkedList<Car>();
        List<Car>cars3 = new LinkedList<Car>();
        cars1.add(car1);
        cars2.add(car1);
        cars2.add(car2);
        cars3.add(car1);
        cars3.add(car2);
        cars3.add(car3);
        Driver driver1 = new Driver("Sasha","Nikolaev",car1);
        Driver driver2 = new Driver("Yana","Nikolaev",car2);
        Driver driver3 = new Driver("Nick","Nikolaev",car3);
//        Driver driver1 = new Driver("Sasha","Nikolaev",cars1);
//        Driver driver2 = new Driver("Yana","Nikolaev",cars2);
//        Driver driver3 = new Driver("Nick","Nikolaev",cars3);
        ServiceDriver service = new ServiceDriver();
        service.add(driver1);
        service.add(driver2);
        service.add(driver3);

        for(Driver driver:service.getAll())
            System.out.println("ID: " + driver);
    }

}
