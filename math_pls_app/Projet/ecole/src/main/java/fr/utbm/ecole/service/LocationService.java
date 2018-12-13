/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole.service;

import fr.utbm.ecole.repository.LocationDao;
import java.util.List;

/**
 *
 * @author mperrot
 */
public class LocationService {

    public LocationService() {
    }
    
    /*Liste les locations*/
    public List listLocations() {
        LocationDao dao = new LocationDao();
        return dao.listLocations();
    }
}
