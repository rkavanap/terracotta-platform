/*
 * Copyright Terracotta, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terracotta.management.service.monitoring;

import com.tc.classloader.CommonComponent;
import org.terracotta.entity.BasicServiceConfiguration;
import org.terracotta.entity.ClientCommunicator;
import org.terracotta.entity.ServiceConfiguration;
import org.terracotta.entity.ServiceRegistry;
import org.terracotta.monitoring.IMonitoringProducer;

import java.util.Objects;

/**
 * @author Mathieu Carbou
 */
@CommonComponent
public class MonitoringServiceConfiguration implements ServiceConfiguration<MonitoringService> {

  private final ServiceRegistry serviceRegistry;

  public MonitoringServiceConfiguration(ServiceRegistry serviceRegistry) {
    this.serviceRegistry = Objects.requireNonNull(serviceRegistry);
  }

  public ClientCommunicator getClientCommunicator() {
    return serviceRegistry.getService(new BasicServiceConfiguration<>(ClientCommunicator.class));
  }

  public IMonitoringProducer getMonitoringProducer() {
    return serviceRegistry.getService(new BasicServiceConfiguration<>(IMonitoringProducer.class));
  }

  @Override
  public Class<MonitoringService> getServiceType() {
    return MonitoringService.class;
  }

  public ServiceRegistry getRegistry() {
    return serviceRegistry;
  }

}
