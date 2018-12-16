/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import static com.codahale.metrics.MetricRegistry.name;
import com.codahale.metrics.Timer;
import fr.utbm.ecole.entity.Session;
import fr.utbm.ecole.service.ClientService;
import fr.utbm.ecole.service.CourseService;
import fr.utbm.ecole.service.SessionService;
import fr.utbm.ecole.tools.MetricsListener;
import static fr.utbm.ecole.tools.MetricsListener.METRIC_REGISTRY;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Filter;

/**
 *
 * @author mperrot
 */
public class App {

    public static final MetricRegistry metrics = new MetricRegistry();

    public static void main(String args[]) {
        
        startReport();
        
        
        
        for (int i=0; i<5; ++i)
        {
            ClientService cs = new ClientService();
            cs.listClients();
            wait5Seconds();
        }

        /*startReport();
        Meter requests = metrics.meter("requests");
        requests.mark(20);

        final Timer timer = metrics.timer(name(ClientService.class, "requests"));
        final Timer.Context context = timer.time();
        try {
            for (int i = 1; i < 5; ++i) {
                ClientService css = new ClientService();
                css.listClients();
            }
        } finally {
            context.stop();
        }

        wait5Seconds();*/
        
        /*SessionService ss = new SessionService();
        List s = ss.listSessions("LO54");
        ClientService css = new ClientService();
        css.addClient("test", "test", "blabla", "0000000000", "kk@com", (Session)s.get(0));*/

    }

    static void startReport() {
        ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
        reporter.start(1, TimeUnit.SECONDS);
    }

    static void wait5Seconds() {
        try {
            Thread.sleep(1 * 1000);
        } catch (InterruptedException e) {
        }
    }
}
