/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Richard's Surface
 */
public class Utility {
    
    public static LinkedHashMap<Integer, Double> sortHashMapByValues(HashMap<Integer, Double> passedMap) {
    List<Integer> mapKeys = new ArrayList<>(passedMap.keySet());
    List<Double> mapValues = new ArrayList<>(passedMap.values());
    Collections.sort(mapValues);
    Collections.sort(mapKeys);

    LinkedHashMap<Integer, Double> sortedMap =
        new LinkedHashMap<>();

    Iterator<Double> valueIt = mapValues.iterator();
    while (valueIt.hasNext()) {
        Double val = valueIt.next();
        Iterator<Integer> keyIt = mapKeys.iterator();

        while (keyIt.hasNext()) {
            Integer key = keyIt.next();
            Double comp1 = passedMap.get(key);
            Double comp2 = val;

            if (comp1.equals(comp2)) {
                keyIt.remove();
                sortedMap.put(key, val);
                break;
            }
        }
    }
        return sortedMap;
    }
    
    
    public static double computeDistance(double lat1, double lon1, double lat2, double lon2) {
      double theta = lon1 - lon2;
      double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
      dist = Math.acos(dist);
      dist = rad2deg(dist);
      dist = dist * 60 * 1.1515;
      dist = dist * 1.609344;
      
      return dist;
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts decimal degrees to radians             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double deg2rad(double deg) {
      return (deg * Math.PI / 180.0);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts radians to decimal degrees             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static double rad2deg(double rad) {
      return (rad * 180.0 / Math.PI);
    }
}
