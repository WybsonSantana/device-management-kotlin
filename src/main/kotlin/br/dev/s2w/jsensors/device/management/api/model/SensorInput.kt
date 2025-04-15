package br.dev.s2w.jsensors.device.management.api.model

data class SensorInput(
    val name: String,

    val ip: String,

    val location: String,

    val protocol: String,

    val model: String
)