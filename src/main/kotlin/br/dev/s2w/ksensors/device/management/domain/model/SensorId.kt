package br.dev.s2w.ksensors.device.management.domain.model

import io.hypersistence.tsid.TSID
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
data class SensorId(
    val value: TSID
) : Serializable {

    constructor(value: Long) : this(TSID.from(value))

    constructor(value: String) : this(TSID.from(value))

    override fun toString(): String = value.toString()

}
