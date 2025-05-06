package br.dev.s2w.ksensors.device.management.api.model

import br.dev.s2w.ksensors.device.management.common.IdGenerator
import br.dev.s2w.ksensors.device.management.domain.model.Sensor
import br.dev.s2w.ksensors.device.management.domain.model.SensorId

data class SensorInput(
    val name: String,

    val ip: String,

    val location: String,

    val protocol: String,

    val model: String
)

fun SensorInput.toSensor(): Sensor =
    Sensor(
        id = SensorId(IdGenerator.generateTSID()),
        name = this.name,
        ip = this.ip,
        location = this.location,
        protocol = this.protocol,
        model = this.model,
        enabled = false
    )