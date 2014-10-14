package org.wayfinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wayfinder.dao.MarkerDAO;
import org.wayfinder.entity.MarkerEntity;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Иван on 14.10.14.
 */
@Service
public class MarkerServiceImpl implements MarkerService {

    @Autowired
    private MarkerDAO dao;

    @Transactional
    @Override
    public void addMarker(MarkerEntity marker) {
        dao.addMarker(marker);
    }

    @Transactional
    @Override
    public void removeMarker(MarkerEntity marker) {
        dao.removeMarker(marker);
    }

    @Transactional
    @Override
    public void shareMarker(MarkerEntity marker, String user) {
        dao.shareMarker(marker, user);
    }

    @Transactional
    @Override
    public List<MarkerEntity> getOwnMarkers(String user) {
        return dao.getOwnMarkers(user);
    }

    @Transactional
    @Override
    public List<MarkerEntity> getSharedMarkers(String user) {
        return dao.getSharedMarkers(user);
    }
}
