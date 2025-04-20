package br.dev.s2w.jsensors.device.management.api.controller

import br.dev.s2w.jsensors.device.management.api.model.SensorInput
import br.dev.s2w.jsensors.device.management.api.model.SensorOutput
import br.dev.s2w.jsensors.device.management.api.model.toSensorOutput
import br.dev.s2w.jsensors.device.management.common.IdGenerator
import br.dev.s2w.jsensors.device.management.domain.model.Sensor
import br.dev.s2w.jsensors.device.management.domain.model.SensorId
import br.dev.s2w.jsensors.device.management.domain.repository.SensorRepository
import io.hypersistence.tsid.TSID
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/sensors")
class SensorController(
    private val sensorRepository: SensorRepository
) {

    @GetMapping
    fun search(@PageableDefault pageable: Pageable): Page<SensorOutput> =
        sensorRepository.findAll(pageable)
            .map { it.toSensorOutput() }

    @GetMapping("/{sensorId}")
    fun getOne(@PathVariable sensorId: TSID): SensorOutput =
        sensorRepository.findById(SensorId(sensorId))
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
            .toSensorOutput()

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
