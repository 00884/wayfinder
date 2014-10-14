package org.wayfinder.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wayfinder.dao.MarkerDAO;
import org.wayfinder.data.geojson.Feature;
import org.wayfinder.data.geojson.LngLatAlt;
import org.wayfinder.data.geojson.Point;
import org.wayfinder.entity.MarkerEntity;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by kreker on 27.09.14.
 */
@Controller
public class MapController {

    @Autowired
    private MarkerDAO markerDAO;

    @RequestMapping(value = "/rest/map/points/getFromDB", method = RequestMethod.GET)
    public @ResponseBody
    String getAllMarkers() {
        List<MarkerEntity> markers=new LinkedList<>();
        /*markers=markerDAO.getAllMarkers();*/
        //Когда hibernate заработает, эти данные будут браться из БД
        markers.add(new MarkerEntity(new LngLatAlt(3.0,4.0),"34"));
        markers.add(new MarkerEntity(new LngLatAlt(5.0,6.0),"56"));
        markers.add(new MarkerEntity(new LngLatAlt(7.0,8.0),"78"));
        List<Feature> features=new LinkedList<>();
        try{
            for(MarkerEntity markerEntity: markers){
                Feature feature=new Feature();
                Map propertyMap = new HashMap();
                propertyMap.put("popupContent", "Im a pop up");
                feature.setProperties(propertyMap);
                Point point=new Point(markerEntity.getCoordinates());
                feature.setGeometry(point);
                features.add(feature);
            }
            return new ObjectMapper().writeValueAsString(features);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return  null;
    }

    @RequestMapping(value = "/rest/map/points/all", method = RequestMethod.GET)
    public @ResponseBody
    String getJson(@RequestParam("longitude") double longitude, @RequestParam("latitude") double latitude) {
        try {
            Feature feature = new Feature();
            Map propertyMap = new HashMap();
            propertyMap.put("popupContent", "Im a pop up");
            feature.setProperties(propertyMap);
            Point point = new Point(longitude,latitude);
            MarkerEntity markerEntity=new MarkerEntity(new LngLatAlt(longitude, latitude),"EMPTY");
            // Эта строка не работает
            // markerDAO.addMarker(markerEntity);
            feature.setGeometry(point);
            return new ObjectMapper().writeValueAsString(feature);
    }
        catch (IOException e){
            e.printStackTrace();
        }
        return  null;
    }
}
