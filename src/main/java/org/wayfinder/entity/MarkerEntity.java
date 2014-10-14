package org.wayfinder.entity;

import org.wayfinder.data.geojson.LngLatAlt;

import javax.persistence.*;

/**
 * Created by Иван on 12.10.14.
 */
public class MarkerEntity {


    private long id;

    private LngLatAlt coordinates;

    private String description;

    public MarkerEntity(LngLatAlt coordinates, String description) {
        this.coordinates = coordinates;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LngLatAlt getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(LngLatAlt coordinates) {
        this.coordinates = coordinates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
