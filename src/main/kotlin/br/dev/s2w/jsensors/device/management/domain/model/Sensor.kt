package br.dev.s2w.jsensors.device.management.domain.model

import io.hypersistence.tsid.TSID

data class Sensor(
    val id: TSID,

    val name: String,

    val ip: String,

    val location: String,

    val protocol: String,

    val model: String,

    val enabled: Boolean
)