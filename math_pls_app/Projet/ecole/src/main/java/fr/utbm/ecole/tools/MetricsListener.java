/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole.tools;

import com.codahale.metrics.MetricRegistry;

import com.codahale.metrics.servlet.InstrumentedFilterContextListener;

/**
 *
 * @author Mathilde
 */
public class MetricsListener extends InstrumentedFilterContextListener {
    
    public final static MetricRegistry METRIC_REGISTRY = new MetricRegistry();
    
    @Override
    protected MetricRegistry getMetricRegistry() {
        return METRIC_REGISTRY;
    }
}
