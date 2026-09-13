package br.dev.s2w.ksensors.device.management.api.controller

import br.dev.s2w.ksensors.device.management.api.model.SensorInput
import br.dev.s2w.ksensors.device.management.common.IdGenerator
import br.dev.s2w.ksensors.device.management.model.Sensor
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping("/api/sensors")
class SensorController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody input: SensorInput): Sensor =
        Sensor(
            id = IdGenerator.generateTSID(),
            name = input.name,
            ip = input.ip,
            location = input.location,
            protocol = input.protocol,
            model = input.model,
            enabled = false
        )

}
