package com.jonathansantos.fotosdeanimais.extensions

val String.cleanUrl: String
    get() {
        return replace("\\", "")
    }
