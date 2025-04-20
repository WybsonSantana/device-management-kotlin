package br.dev.s2w.jsensors.device.management.domain.model

import io.hypersistence.tsid.TSID
import jakarta.persistence.AttributeOverride
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Sensor(
    @Id
    @AttributeOverride(name = "value", column = Column(name = "id", columnDefinition = "BIGINT"))
    val id: SensorId,

    val name: String,

    val ip: String,

    val location: String,

    val protocol: String,

    val model: String,

    val enabled: Boolean
)