package br.dev.s2w.ksensors.device.management.api.model

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

fun br.dev.s2w.ksensors.device.management.domain.model.Sensor.toSensorOutput(): SensorOutput =
    SensorOutput(
        id = this.id.value,
        name = this.name,
        ip = this.ip,
        location = this.location,
        protocol = this.protocol,
        model = this.model,
        enabled = this.enabled
    )