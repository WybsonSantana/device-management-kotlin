package br.dev.s2w.jsensors.device.management

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DeviceManagementApplication

fun main(args: Array<String>) {
	runApplication<DeviceManagementApplication>(*args)
}
