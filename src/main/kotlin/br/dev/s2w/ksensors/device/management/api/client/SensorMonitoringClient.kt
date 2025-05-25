package br.dev.s2w.ksensors.device.management.api.client

import br.dev.s2w.ksensors.device.management.api.model.SensorMonitoringOutput
import io.hypersistence.tsid.TSID

interface SensorMonitoringClient {

    fun enableMonitoring(sensorId: TSID)

    fun disableMonitoring(sensorId: TSID)

    fun getDetail(sensorId: TSID): SensorMonitoringOutput?

}
