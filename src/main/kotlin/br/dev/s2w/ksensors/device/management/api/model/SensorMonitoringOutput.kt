package br.dev.s2w.ksensors.device.management.api.model

import io.hypersistence.tsid.TSID
import java.time.OffsetDateTime

data class SensorMonitoringOutput(
    val sensorId: TSID?,

    val lastTemperature: Double?,

    val updatedAt: OffsetDateTime?,

    val enabled: Boolean?
)