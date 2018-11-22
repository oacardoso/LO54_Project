/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole;

import fr.utbm.ecole.entity.Session;
import fr.utbm.ecole.service.ClientService;
import java.util.HashSet;

/**
 *
 * @author mperrot
 */
public class App {
    public static void main(String[] args) {

        ClientService cs = new ClientService();
        
        HashSet sessions = new HashSet();

        sessions.add(new Session("01/12/2018", "10/12/2018", 40));
        sessions.add(new Session("05/01/2019", "20/01/2019", 40));
        
        cs.addClient("Dubois", "Jean-Du", "21000 Dijon", "0325456321".toCharArray(), "blabla@free.fr", sessions);
    }
}
