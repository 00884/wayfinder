package org.wayfinder.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wayfinder.data.geojson.Feature;
import org.wayfinder.data.geojson.Point;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kreker on 27.09.14.
 */
@Controller
public class MapController {
    @RequestMapping(value = "/rest/map/points/all", method = RequestMethod.GET)
    public @ResponseBody
    String getJson(@RequestParam("longitude") double longitude, @RequestParam("latitude") double latitude) {
        try {
            Feature feature = new Feature();
            Map propertyMap = new HashMap();
            propertyMap.put("popupContent", "Im a pop up");
            feature.setProperties(propertyMap);
            Point point = new Point(longitude,latitude);
            feature.setGeometry(point);
            return new ObjectMapper().writeValueAsString(feature);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return  null;
    }
}
