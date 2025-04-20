package br.dev.s2w.jsensors.device.management.domain.model

import com.fasterxml.jackson.annotation.JsonValue
import io.hypersistence.tsid.TSID
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
data class SensorId(
    @JsonValue
    private val value: TSID
) : Serializable {

    constructor(value: Long) : this(TSID.from(value))

    constructor(value: String) : this(TSID.from(value))

    override fun toString(): String = value.toString()

}
