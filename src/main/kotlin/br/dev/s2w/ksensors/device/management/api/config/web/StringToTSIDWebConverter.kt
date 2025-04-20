package br.dev.s2w.ksensors.device.management.api.config.web

import io.hypersistence.tsid.TSID
import org.springframework.core.convert.converter.Converter

class StringToTSIDWebConverter : Converter<String, TSID> {

    override fun convert(source: String): TSID? {
        return TSID.from(source)
    }

}
