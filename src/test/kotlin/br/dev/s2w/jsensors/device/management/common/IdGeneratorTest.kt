package br.dev.s2w.jsensors.device.management.common

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.time.Instant
import java.time.temporal.ChronoUnit

internal class IdGeneratorTest {

    @Test
    fun `should generate tsid`() {
        val tsid = IdGenerator.generateTSID()

        Assertions.assertThat(tsid.instant)
            .isCloseTo(Instant.now(), Assertions.within(1, ChronoUnit.MINUTES))
    }

}
