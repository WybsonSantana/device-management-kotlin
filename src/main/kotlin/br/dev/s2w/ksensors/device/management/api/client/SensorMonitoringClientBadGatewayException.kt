package br.dev.s2w.ksensors.device.management.api.client

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_GATEWAY)
class SensorMonitoringClientBadGatewayException : RuntimeException()