package org.wayfinder.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.wayfinder.entity.MarkerEntity;

import java.util.List;

/**
 * Created by Иван on 07.10.14.
 */

public class MarkerDAOImpl implements MarkerDAO {

    private SessionFactory sessionFactory;

    private Session openSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addMarker(MarkerEntity marker) {
        openSession().save(marker);
    }

    @Override
    public void removeMarker(MarkerEntity marker) {
        openSession().delete(marker);
    }

    @Override
    public void shareMarker(MarkerEntity marker, String user) {
        Query query=openSession().createQuery("insert into sharedmarker values("+marker.getId()+","+user);
        query.executeUpdate();
    }

    @Override
    public List<MarkerEntity> getOwnMarkers(String user) {
        Query query=openSession().createSQLQuery("select from marker where user="+user);
        return query.list();
    }

    @Override
    public List<MarkerEntity> getSharedMarkers(String user) {
        Query query=openSession().createSQLQuery("select from sharedmarker where user="+user);
        return query.list();
    }
}
