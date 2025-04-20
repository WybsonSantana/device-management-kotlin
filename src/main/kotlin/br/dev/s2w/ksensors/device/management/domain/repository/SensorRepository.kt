package br.dev.s2w.ksensors.device.management.domain.repository

import br.dev.s2w.ksensors.device.management.domain.model.SensorId
import org.springframework.data.jpa.repository.JpaRepository

interface SensorRepository : JpaRepository<br.dev.s2w.ksensors.device.management.domain.model.Sensor, SensorId>