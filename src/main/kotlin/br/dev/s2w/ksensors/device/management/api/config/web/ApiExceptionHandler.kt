package br.dev.s2w.ksensors.device.management.api.config.web

import br.dev.s2w.ksensors.device.management.api.client.SensorMonitoringClientBadGatewayException
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.URI
import java.nio.channels.ClosedChannelException

@RestControllerAdvice
class ApiExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(
        SocketTimeoutException::class,
        ConnectException::class,
        ClosedChannelException::class
    )
    fun handle(e: IOException): ProblemDetail =
        ProblemDetail.forStatus(HttpStatus.GATEWAY_TIMEOUT).apply {
            title = "Gateway timeout"
            detail = e.message
            type = URI.create("/errors/gateway-timeout")
        }

    @ExceptionHandler(SensorMonitoringClientBadGatewayException::class)
    fun handle(e: SensorMonitoringClientBadGatewayException): ProblemDetail =
        ProblemDetail.forStatus(HttpStatus.BAD_GATEWAY).apply {
            title = "Bad gateway"
            detail = e.message
            type = URI.create("/errors/bad-gateway")
        }

}
