package com.nova.novademo.utli


import java.time.LocalDateTime

/**
 * Date time util
 *
 * @constructor Create empty Date time util
 */
class DateTimeUtil {
    companion object {
        fun curremtTime(): LocalDateTime {
            return LocalDateTime.now();
        }
    }
}