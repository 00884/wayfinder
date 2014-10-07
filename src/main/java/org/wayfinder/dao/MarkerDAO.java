package org.wayfinder.dao;

import org.wayfinder.data.geojson.Point;

import java.util.List;

/**
 * Created by Иван on 07.10.14.
 */
public interface MarkerDAO {
    public void addMarker(Point point);
    public void removeMarker(Point point);
    public void shareMarker(String user);
    public List<Marker> getMarkers();
}
