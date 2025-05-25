package br.dev.s2w.ksensors.device.management.api.model

data class SensorDetailOutput(
    val sensor: SensorOutput,

    val monitoring: SensorMonitoringOutput?

)