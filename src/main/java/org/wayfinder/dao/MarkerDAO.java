package org.wayfinder.dao;

import org.wayfinder.entity.MarkerEntity;

import java.util.List;

/**
 * Created by Иван on 07.10.14.
 */
public interface MarkerDAO {
    public void addMarker(MarkerEntity marker);
    public void removeMarker(MarkerEntity marker);
    public void shareMarker(MarkerEntity marker, String user);
    public List<MarkerEntity> getOwnMarkers(String user);
    public List<MarkerEntity> getSharedMarkers(String user);
}
