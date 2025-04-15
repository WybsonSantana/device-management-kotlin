package br.dev.s2w.jsensors.device.management.api.config.jackson

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import io.hypersistence.tsid.TSID

class TSIDToStringSerializer : JsonSerializer<TSID>() {

    override fun serialize(value: TSID?, gen: JsonGenerator?, serializers: SerializerProvider?) {
        gen?.writeString(value.toString())
    }

}
