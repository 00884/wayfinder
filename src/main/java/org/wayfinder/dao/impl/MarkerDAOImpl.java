package org.wayfinder.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.wayfinder.dao.MarkerDAO;
import org.wayfinder.entity.MarkerEntity;

import java.util.List;

/**
 * Created by Иван on 07.10.14.
 */

@Repository ("markerDAO")
public class MarkerDAOImpl implements MarkerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public void addMarker(MarkerEntity marker) {
        openSession().save(marker);
    }

    @Transactional
    public void removeMarker(MarkerEntity marker) {
        openSession().delete(marker);
    }

    @Transactional
    public void shareMarker(MarkerEntity marker, String user) {
        Query query=openSession().createQuery("insert into sharedmarker values("+marker.getId()+","+user);
        query.executeUpdate();
    }

    @Transactional
    public List<MarkerEntity> getOwnMarkers(String user) {
        Query query=openSession().createSQLQuery("select * from marker where user="+user);
        return query.list();
    }

    @Transactional
    public List<MarkerEntity> getSharedMarkers(String user) {
        Query query=openSession().createSQLQuery("select * from sharedmarker where user="+user);
        return query.list();
    }

    @Transactional
    public List<MarkerEntity> getAllMarkers() {
        Query query=openSession().createQuery("from MarkerEntity as mar");
        return query.list();
    }
}
