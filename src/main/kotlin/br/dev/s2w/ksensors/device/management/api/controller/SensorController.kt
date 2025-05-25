package br.dev.s2w.ksensors.device.management.api.controller

import br.dev.s2w.ksensors.device.management.api.client.SensorMonitoringClient
import br.dev.s2w.ksensors.device.management.api.model.*
import br.dev.s2w.ksensors.device.management.domain.model.SensorId
import br.dev.s2w.ksensors.device.management.domain.repository.SensorRepository
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
    private val sensorRepository: SensorRepository,
    private val sensorMonitoringClient: SensorMonitoringClient
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

    @GetMapping("/{sensorId}/detail")
    fun getOneWithDetail(@PathVariable sensorId: TSID): SensorDetailOutput =
        sensorRepository.findById(SensorId(sensorId))
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
            .run {
                SensorDetailOutput(
                    sensor = this.toSensorOutput(),
                    monitoring = sensorMonitoringClient.getDetail(sensorId)
                )
            }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody sensorInput: SensorInput): SensorOutput =
        sensorInput.toSensor()
            .let(sensorRepository::saveAndFlush)
            .toSensorOutput()

    @PutMapping("/{sensorId}")
    fun update(@PathVariable sensorId: TSID, @RequestBody sensorInput: SensorInput): SensorOutput =
        sensorRepository.findById(SensorId(sensorId))
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
            .copy(
                name = sensorInput.name,
                ip = sensorInput.ip,
                location = sensorInput.location,
                protocol = sensorInput.protocol,
                model = sensorInput.model
            ).let(sensorRepository::save).toSensorOutput()

    @DeleteMapping("/{sensorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable sensorId: TSID) =
        sensorRepository.findById(SensorId(sensorId))
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
            .let(sensorRepository::delete)

    @PutMapping("/{sensorId}/enable")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun enable(@PathVariable sensorId: TSID) =
        sensorRepository.findById(SensorId(sensorId))
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
            .copy(enabled = true)
            .apply(sensorRepository::save)
            .run { sensorMonitoringClient.enableMonitoring(sensorId) }

    @DeleteMapping("/{sensorId}/enable")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun disable(@PathVariable sensorId: TSID) =
        sensorRepository.findById(SensorId(sensorId))
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
            .copy(enabled = false)
            .apply(sensorRepository::save)
            .run { sensorMonitoringClient.disableMonitoring(sensorId) }

}
