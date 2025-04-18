package br.dev.s2w.jsensors.device.management.api.controller

import br.dev.s2w.jsensors.device.management.api.model.SensorInput
import br.dev.s2w.jsensors.device.management.common.IdGenerator
import br.dev.s2w.jsensors.device.management.domain.model.Sensor
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/sensors")
class SensorController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody input: SensorInput) =
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
