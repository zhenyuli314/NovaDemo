package com.nova.novademo.utli


import java.time.LocalDateTime


class DateTimeUtil {
    companion object {
        fun curremtTime(): LocalDateTime {
            return LocalDateTime.now();
        }
    }
}