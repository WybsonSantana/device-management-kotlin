package br.dev.s2w.ksensors.device.management.api.client

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.support.RestClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory

@Configuration
class RestClientConfig {

    @Bean
    fun sensorMonitoringClient(factory: RestClientFactory): SensorMonitoringClient =
        factory.temperatureMonitoringRestClient()
            .let(RestClientAdapter::create)
            .run {
                HttpServiceProxyFactory.builderFor(this)
                    .build()
                    .createClient(SensorMonitoringClient::class.java)
            }

}
