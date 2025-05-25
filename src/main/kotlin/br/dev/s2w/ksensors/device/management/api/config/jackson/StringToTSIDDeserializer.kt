package br.dev.s2w.ksensors.device.management.api.config.jackson

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import io.hypersistence.tsid.TSID

class StringToTSIDDeserializer : JsonDeserializer<TSID>() {

    override fun deserialize(p: JsonParser?, ctxt: DeserializationContext?): TSID =
        TSID.from(p?.text)

}
