package br.dev.s2w.ksensors.device.management.api.client.impl

import br.dev.s2w.ksensors.device.management.api.client.RestClientFactory
import br.dev.s2w.ksensors.device.management.api.client.SensorMonitoringClient
import io.hypersistence.tsid.TSID
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class SensorMonitoringClientImpl(
    factory: RestClientFactory
) : SensorMonitoringClient {

    private val restClient = factory.temperatureMonitoringRestClient()

    override fun enableMonitoring(sensorId: TSID) {
        restClient.put()
            .uri("/api/sensors/{sensorId}/monitoring/enable", sensorId)
            .retrieve()
            .toBodilessEntity()
    }

    override fun disableMonitoring(sensorId: TSID) {
        restClient.delete()
            .uri("/api/sensors/{sensorId}/monitoring/enable", sensorId)
            .retrieve()
            .toBodilessEntity()
    }

}
