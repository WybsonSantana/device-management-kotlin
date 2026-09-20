package br.dev.s2w.ksensors.device.management.api.controller

import br.dev.s2w.ksensors.device.management.api.converter.toSensorOutput
import br.dev.s2w.ksensors.device.management.api.model.SensorInput
import br.dev.s2w.ksensors.device.management.api.model.SensorOutput
import br.dev.s2w.ksensors.device.management.common.IdGenerator
import br.dev.s2w.ksensors.device.management.domain.model.Sensor
import br.dev.s2w.ksensors.device.management.domain.model.SensorId
import br.dev.s2w.ksensors.device.management.domain.repository.SensorRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping("/api/sensors")
class SensorController(
    private val sensorRepository: SensorRepository
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody input: SensorInput): SensorOutput =
        Sensor(
            id = SensorId(IdGenerator.generateTSID()),
            name = input.name,
            ip = input.ip,
            location = input.location,
            protocol = input.protocol,
            model = input.model,
            enabled = false
        ).let(sensorRepository::saveAndFlush).toSensorOutput()

}
