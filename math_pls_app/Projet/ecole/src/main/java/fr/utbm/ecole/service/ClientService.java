/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole.service;

import fr.utbm.ecole.entity.Client;
import fr.utbm.ecole.entity.Session;
import fr.utbm.ecole.repository.ClientDao;
import java.util.List;
import static com.codahale.metrics.MetricRegistry.name;
import com.codahale.metrics.Timer;
import static fr.utbm.ecole.tools.MetricsRegistry.METRIC_REGISTRY;

/**
 *
 * @author mperrot
 */
public class ClientService {

    //A changer avec METRIC_REGISTRY
    private final Timer addClient = METRIC_REGISTRY.timer(name(ClientService.class,"addClient"));
    private final Timer listClient = METRIC_REGISTRY.timer(name(ClientService.class,"listClient"));
    
    

    public ClientService() {
    }

    /*Nouveau client*/
    public Integer addClient(String last_name, String first_name, String address, String phone, String email, Session session) {
        final Timer.Context context = addClient.time();
        try {
            ClientDao dao = new ClientDao();
            return dao.addClient(last_name, first_name, address, phone, email, session);
        } finally {
            context.stop();
        }
    }

    /*Liste des clients*/
    public List listClients() {
        final Timer.Context context = listClient.time();
        try {
            ClientDao dao = new ClientDao();
            return dao.listClients();
        } finally {
            context.stop();
        }
    }

    /*Renvoie un client selon son nom*/
    public Client getClient(String first_name, String last_name) {
        ClientDao dao = new ClientDao();
        return dao.getClient(first_name, last_name);
    }

    /*Ajoute des sessions de cours à un client*/
    public void addClientSession(Client client, Session session) {
        ClientDao dao = new ClientDao();
        dao.addClientSession(client, session);
    }

}
