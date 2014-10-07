package org.wayfinder.dao;

import org.hibernate.annotations.GenericGenerator;
import org.wayfinder.data.geojson.LngLatAlt;

import javax.persistence.*;

/**
 * Created by Иван on 08.10.14.
 */

public class Marker {

    private long id;
    private LngLatAlt coordinates;
    private String description;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Marker(LngLatAlt coordinates, String description) {
        this.coordinates = coordinates;
        this.description = description;
    }


    public LngLatAlt getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(LngLatAlt coordinates) {
        this.coordinates = coordinates;
    }

    @Column(name="desription")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
