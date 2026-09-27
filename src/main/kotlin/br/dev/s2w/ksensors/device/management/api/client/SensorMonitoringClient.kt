package br.dev.s2w.ksensors.device.management.api.client

import br.dev.s2w.ksensors.device.management.api.model.SensorMonitoringOutput
import io.hypersistence.tsid.TSID
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.service.annotation.DeleteExchange
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.HttpExchange
import org.springframework.web.service.annotation.PutExchange

@HttpExchange("/api/sensors/{sensorId}/monitoring")
interface SensorMonitoringClient {

    @PutExchange("/enable")
    fun enableMonitoring(@PathVariable sensorId: TSID)

    @DeleteExchange("/enable")
    fun disableMonitoring(@PathVariable sensorId: TSID)

    @GetExchange
    fun getDetail(@PathVariable sensorId: TSID): SensorMonitoringOutput

}
