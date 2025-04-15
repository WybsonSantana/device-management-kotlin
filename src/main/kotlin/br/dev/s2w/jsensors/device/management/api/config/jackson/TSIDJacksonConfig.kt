package br.dev.s2w.jsensors.device.management.api.config.jackson

import com.fasterxml.jackson.databind.module.SimpleModule
import io.hypersistence.tsid.TSID
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TSIDJacksonConfig {

    @Bean
    fun tsidModule() = SimpleModule().apply {
        addSerializer(TSID::class.java, TSIDToStringSerializer())
    }

}
