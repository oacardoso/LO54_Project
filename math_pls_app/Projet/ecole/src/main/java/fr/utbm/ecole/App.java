/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole;

import fr.utbm.ecole.entity.Session;
import fr.utbm.ecole.service.ClientService;
import java.util.Date;
import java.util.HashSet;

/**
 *
 * @author mperrot
 */
public class App {
    public static void main(String[] args) {

        ClientService cs = new ClientService();
        
        HashSet sessions = new HashSet();
        
        sessions.add(new Session(new Date(2018, 12, 01), new Date(2018, 12, 10), 40));
        sessions.add(new Session(new Date(2019, 01, 05), new Date(2019, 01, 20), 40));
        
        cs.addClient("Dubois", "Jean-Du", "21000 Dijon", "0325456321", "blabla@free.fr", sessions);
        
        cs.listClients();
    }
}
