/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.ecole.tools;

import com.codahale.metrics.MetricRegistry;

/**
 *
 * @author Mathilde
 */
public class MetricsRegistry {
    
    public static MetricRegistry METRIC_REGISTRY;

    public MetricsRegistry() {
    }
    
    public MetricsRegistry(MetricRegistry registry) {
        METRIC_REGISTRY = registry;
    }

    public static MetricRegistry getMETRIC_REGISTRY() {
        return METRIC_REGISTRY;
    }

}
