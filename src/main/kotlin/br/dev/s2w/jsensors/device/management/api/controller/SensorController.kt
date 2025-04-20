package br.dev.s2w.jsensors.device.management.api.controller

import br.dev.s2w.jsensors.device.management.api.model.SensorInput
import br.dev.s2w.jsensors.device.management.common.IdGenerator
import br.dev.s2w.jsensors.device.management.domain.model.Sensor
import br.dev.s2w.jsensors.device.management.domain.model.SensorId
import br.dev.s2w.jsensors.device.management.domain.repository.SensorRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/sensors")
class SensorController(
    private val sensorRepository: SensorRepository
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody input: SensorInput) =
        Sensor(
            id = SensorId(IdGenerator.generateTSID()),
            name = input.name,
            ip = input.ip,
            location = input.location,
            protocol = input.protocol,
            model = input.model,
            enabled = false
        ).let(sensorRepository::saveAndFlush)

}
