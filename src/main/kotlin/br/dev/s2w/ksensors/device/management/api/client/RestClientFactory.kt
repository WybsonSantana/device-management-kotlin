package br.dev.s2w.ksensors.device.management.api.client

import org.springframework.http.HttpStatusCode
import org.springframework.http.client.ClientHttpRequestFactory
import org.springframework.http.client.SimpleClientHttpRequestFactory
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient

@Component
class RestClientFactory(
    private val builder: RestClient.Builder
) {

    fun temperatureMonitoringRestClient(): RestClient =
        builder.baseUrl("http://localhost:8082")
            .requestFactory(generateClientHttpRequestFactory())
            .defaultStatusHandler(HttpStatusCode::isError) { _, _ ->
                throw SensorMonitoringClientBadGatewayException()
            }
            .build()

    private fun generateClientHttpRequestFactory(): ClientHttpRequestFactory =
        SimpleClientHttpRequestFactory().apply {
            setReadTimeout(java.time.Duration.ofSeconds(5))
            setConnectTimeout(java.time.Duration.ofSeconds(3))
        }

}
