package br.dev.s2w.ksensors.device.management.api.client.impl

import br.dev.s2w.ksensors.device.management.api.client.SensorMonitoringClient
import br.dev.s2w.ksensors.device.management.api.client.SensorMonitoringClientBadGatewayException
import io.hypersistence.tsid.TSID
import org.springframework.http.HttpStatusCode
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class SensorMonitoringClientImpl(
    builder: RestClient.Builder
) : SensorMonitoringClient {

    private val restClient: RestClient = builder
        .baseUrl("http://localhost:8082")
        .defaultStatusHandler(HttpStatusCode::isError) { request, response ->
            throw SensorMonitoringClientBadGatewayException()
        }
        .build()

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
