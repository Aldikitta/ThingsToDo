package com.aldikitta.core_logger

interface Logging {
    fun log(priority: Int, tag: String, message: String, throwable: Throwable?)
}
