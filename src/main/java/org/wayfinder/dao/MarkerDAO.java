package org.wayfinder.dao;

import org.wayfinder.data.geojson.Point;

/**
 * Created by Иван on 07.10.14.
 */
public interface MarkerDAO {
    public void addMarker(Point point);
    public void removeMarker(Point point);
    public void shareMarker(String user);
}
