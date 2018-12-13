/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole.service;

import fr.utbm.ecole.entity.Client;
import fr.utbm.ecole.repository.ClientDao;
import java.util.List;
import java.util.Set;

/**
 *
 * @author mperrot
 */
public class ClientService {

    public ClientService() {
    }
    
    /*Nouveau client*/
    public Integer addClient(String last_name, String first_name, String address, String phone, String email, Set sessions) {
        ClientDao dao = new ClientDao();
        return dao.addClient(last_name, first_name, address, phone, email, sessions);
    }

    /*Liste des clients*/
    public List listClients() {
        ClientDao dao = new ClientDao();
        return dao.listClients();
    }
    
    /*Renvoie un client selon son nom*/
    public Client getClient(String first_name, String last_name) {
        ClientDao dao = new ClientDao();
        return dao.getClient(first_name, last_name);
    }
    
    /*Ajoute des sessions de cours à un client*/
    public void addClientSession(Client client, Set sessions) {
        ClientDao dao = new ClientDao();
        dao.addClientSession(client, sessions);
    }

}
