package com.jonathansantos.animaisfofos.extensions

val String.cleanUrl: String
    get() {
        return replace("\\", "")
    }
