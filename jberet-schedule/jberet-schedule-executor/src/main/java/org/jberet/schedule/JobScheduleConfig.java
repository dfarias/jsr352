/*
 * Copyright (c) 2016 Red Hat, Inc. and/or its affiliates.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Cheng Fang - Initial API and implementation
 */

package org.jberet.schedule;

import java.io.Serializable;
import java.util.Properties;

public final class JobScheduleConfig implements Serializable {
    private static final long serialVersionUID = 7225109864510680914L;

    final String jobName;

    final long jobExecutionId;

    final Properties jobParameters;

    final String scheduleExpression;

    final long initialDelay;

    final long delay;

    final long interval;

    public JobScheduleConfig(final String jobName,
                             final long jobExecutionId,
                             final Properties jobParameters,
                             final String scheduleExpression,
                             final long initialDelay,
                             final long delay,
                             final long interval) {
        this.jobName = jobName;
        this.jobExecutionId = jobExecutionId;
        this.jobParameters = jobParameters;
        this.scheduleExpression = scheduleExpression == null ? null : scheduleExpression.trim();
        this.initialDelay = initialDelay;
        this.delay = delay;
        this.interval = interval;
    }

    public boolean isRepeating() {
        return delay > 0 || interval > 0 || (scheduleExpression != null && scheduleExpression.length() > 0);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final JobScheduleConfig that = (JobScheduleConfig) o;

        if (jobExecutionId != that.jobExecutionId) return false;
        if (initialDelay != that.initialDelay) return false;
        if (delay != that.delay) return false;
        if (interval != that.interval) return false;
        if (jobName != null ? !jobName.equals(that.jobName) : that.jobName != null) return false;
        if (jobParameters != null ? !jobParameters.equals(that.jobParameters) : that.jobParameters != null)
            return false;
        return scheduleExpression != null ? scheduleExpression.equals(that.scheduleExpression) : that.scheduleExpression == null;

    }

    @Override
    public int hashCode() {
        int result = jobName != null ? jobName.hashCode() : 0;
        result = 31 * result + (int) (jobExecutionId ^ (jobExecutionId >>> 32));
        result = 31 * result + (jobParameters != null ? jobParameters.hashCode() : 0);
        result = 31 * result + (scheduleExpression != null ? scheduleExpression.hashCode() : 0);
        result = 31 * result + (int) (initialDelay ^ (initialDelay >>> 32));
        result = 31 * result + (int) (delay ^ (delay >>> 32));
        result = 31 * result + (int) (interval ^ (interval >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "JobScheduleInfo{" +
                "jobName='" + jobName + '\'' +
                ", jobExecutionId=" + jobExecutionId +
                ", jobParameters=" + jobParameters +
                ", scheduleExpression='" + scheduleExpression + '\'' +
                ", initialDelay=" + initialDelay +
                ", delay=" + delay +
                ", interval=" + interval +
                '}';
    }
}