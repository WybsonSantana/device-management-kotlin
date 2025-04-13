package br.dev.s2w.jsensors.device.management

import io.hypersistence.tsid.TSID

class IdGenerator {

    companion object {
        private var tsidFactory: TSID.Factory

        init {
            System.getenv("tsid.node")?.let {
                System.setProperty("tsid.node", it)
            }

            System.getenv("tsid.node.count")?.let {
                System.setProperty("tsid.node.count", it)
            }

            tsidFactory = TSID.Factory.builder().build()
        }

        fun generateTSID(): TSID = tsidFactory.generate()
    }

}
