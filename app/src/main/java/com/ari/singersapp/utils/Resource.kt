package com.ari.singersapp.utils

/**
 * States to control the view when making a network call
 */
data class Resource<out T>(
    val status: Status,
    val data: T?,
    val message: String?
) {

    companion object {

        /**
         * @return status and data
         */
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        /**
         * @return status, data and errorContent
         */
        fun <T> error(msg: String, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        /**
         * @return set view in loading status
         */
        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }

    }

}
