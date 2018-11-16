/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole;

import fr.utbm.ecole.service.ClientService;

/**
 *
 * @author mperrot
 */
public class App {
    public static void main(String[] args) {

        ClientService cs = new ClientService();
        cs.addClient("Dubois", "Jean-Du", "21000 Dijon", "0325456321".toCharArray(), "blabla@free.fr");
    }
}
