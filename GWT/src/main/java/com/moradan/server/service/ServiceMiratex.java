package com.moradan.server.service;

import com.moradan.server.dao.MiratexDao;
import com.moradan.shared.domain.Miratex;
import com.moradan.server.util.HibernateUtil;

import java.util.List;

/**
 * Created by alexandr on 13.08.15.
 */
public class ServiceMiratex {

    public ServiceMiratex(){
        dao = new MiratexDao(HibernateUtil.getSessionFactory());
    }

    public void add(Miratex miratex){
        dao.add(miratex);
    }

    public Miratex get(int id){
        return dao.get(id);
    }

    public List<Miratex> getAll(){
        return dao.getAll();
    }

    public void update(Miratex miratex){
        dao.update(miratex);
    }

    public void delete(int id){
        dao.delete(id);
    }

    private MiratexDao dao;
}
