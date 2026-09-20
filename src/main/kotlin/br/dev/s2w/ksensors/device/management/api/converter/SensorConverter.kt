package br.dev.s2w.ksensors.device.management.api.converter

import br.dev.s2w.ksensors.device.management.api.model.SensorOutput
import br.dev.s2w.ksensors.device.management.domain.model.Sensor

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
