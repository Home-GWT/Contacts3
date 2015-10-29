//package com.moradan.server.service;
//
//import com.moradan.server.dao.DriverDao;
//import com.moradan.shared.domain.Driver;
//import com.moradan.server.util.HibernateUtil;
//
//import java.util.List;
//
///**
// * Created by alexandr on 13.08.15.
// */
//public class ServiceDriver {
//
//    public ServiceDriver(){
//        dao = new DriverDao(HibernateUtil.getSessionFactory());
//    }
//
//    public void add(Driver driver){
//        dao.add(driver);
//    }
//
//    public Driver get(int id){
//        return dao.get(id);
//    }
//    public List<Driver> getAll(){
//        return dao.getAll();
//    }
//
//    public void update(Driver driver){
//        dao.update(driver);
//    }
//
//    public void delete(int id){
//        dao.delete(id);
//    }
//
//    private DriverDao dao;
//}
