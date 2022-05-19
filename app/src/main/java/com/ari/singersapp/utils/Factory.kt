package com.ari.singersapp.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder

class Factory {
    companion object {
        val gson: Gson by lazy { createGson() }

        private fun createGson(): Gson {
            //It allows us to deserialize and serialize classes
            val builder = GsonBuilder()

            //Create and return Gson object
            return builder.create()
        }
    }
}
