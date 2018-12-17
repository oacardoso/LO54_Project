/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecoleapp.metrics;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.servlets.MetricsServlet;
import fr.utbm.ecole.tools.MetricsRegistry;

/**
 *
 * @author Mathilde
 */
public class MetricsListener extends MetricsServlet.ContextListener {
    
    public static final MetricRegistry METRIC_REGISTRY = new MetricRegistry();

    @Override
    protected MetricRegistry getMetricRegistry() {
        return METRIC_REGISTRY;
    }
    
    @Override
    public void contextInitialized(javax.servlet.ServletContextEvent event)
    {
        MetricsRegistry registry = new MetricsRegistry(METRIC_REGISTRY);
        super.contextInitialized(event);
    }
}
