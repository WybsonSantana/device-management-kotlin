package br.dev.s2w.ksensors.device.management.domain.model

import jakarta.persistence.AttributeOverride
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Sensor(
    @Id
    @AttributeOverride(name = "value", column = Column(name = "id", columnDefinition = "BIGINT"))
    val id: br.dev.s2w.ksensors.device.management.domain.model.SensorId,

    val name: String,

    val ip: String,

    val location: String,

    val protocol: String,

    val model: String,

    val enabled: Boolean
)