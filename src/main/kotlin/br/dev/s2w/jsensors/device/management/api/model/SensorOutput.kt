package br.dev.s2w.jsensors.device.management.api.model

import br.dev.s2w.jsensors.device.management.domain.model.Sensor
import io.hypersistence.tsid.TSID

data class SensorOutput(
    val id: TSID,

    val name: String,

    val ip: String,

    val location: String,

    val protocol: String,

    val model: String,

    val enabled: Boolean
)

fun Sensor.toSensorOutput(): SensorOutput =
    SensorOutput(
        id = this.id.value,
        name = this.name,
        ip = this.ip,
        location = this.location,
        protocol = this.protocol,
        model = this.model,
        enabled = this.enabled
    )