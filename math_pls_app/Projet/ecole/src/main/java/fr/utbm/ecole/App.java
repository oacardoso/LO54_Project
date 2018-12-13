/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole;

import fr.utbm.ecole.service.ClientService;
import fr.utbm.ecole.service.CourseService;
import java.util.HashSet;

/**
 *
 * @author mperrot
 */
public class App {
    public static void main(String[] args) {
 
        ClientService css = new ClientService();
        
        css.addClient("Janvier", "Robert", "4 rue Emile Zozo", "0365478520", "robertdu82@free.fr", new HashSet());
    }
}
