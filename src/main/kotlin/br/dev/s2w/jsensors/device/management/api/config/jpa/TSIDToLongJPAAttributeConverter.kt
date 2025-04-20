package br.dev.s2w.jsensors.device.management.api.config.jpa

import io.hypersistence.tsid.TSID
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter(autoApply = true)
class TSIDToLongJPAAttributeConverter : AttributeConverter<TSID, Long> {

    override fun convertToDatabaseColumn(attribute: TSID?): Long? {
        return attribute?.toLong()
    }

    override fun convertToEntityAttribute(dbData: Long?): TSID? {
        return dbData?.let { TSID.from(it) }
    }

}
