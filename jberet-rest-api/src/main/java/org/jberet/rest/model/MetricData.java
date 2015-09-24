/*
 * Copyright (c) 2015 Red Hat, Inc. and/or its affiliates.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Cheng Fang - Initial API and implementation
 */

package org.jberet.rest.model;

import java.io.Serializable;
import javax.batch.runtime.Metric;

public class MetricData implements Serializable, Metric {
    private static final long serialVersionUID = 717668174913816112L;
    private MetricType type;
    private long value;

    public MetricData() {
    }

    public MetricData(final Metric metric) {
        this.type = metric.getType();
        this.value = metric.getValue();
    }

    public static MetricData[] copyOf(final Metric[] metrics) {
        if (metrics != null) {
            MetricData[] metricArray = new MetricData[metrics.length];
            for (int i = 0; i < metricArray.length; i++) {
                metricArray[i] = new MetricData(metrics[i]);
            }
            return metricArray;
        } else {
            return null;
        }
    }

    @Override
    public MetricType getType() {
        return type;
    }

    public void setType(final MetricType type) {
        this.type = type;
    }

    @Override
    public long getValue() {
        return value;
    }

    public void setValue(final long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MetricData{" +
                "type=" + type +
                ", value=" + value +
                '}';
    }
}