package com.ari.singersapp.utils

/**
 * States to control the view when making a network call
 */
data class StatusResource<out T>(
    val actionStatus: ActionStatus,
    val data: T?,
    val message: String?
) {

    companion object {

        /**
         * @return status and data
         */
        fun <T> success(data: T?): StatusResource<T> {
            return StatusResource(ActionStatus.SUCCESS, data, null)
        }

        /**
         * @return status, data and errorContent
         */
        fun <T> error(msg: String, data: T?): StatusResource<T> {
            return StatusResource(ActionStatus.ERROR, data, msg)
        }

        /**
         * @return set view in loading status
         */
        fun <T> loading(data: T?): StatusResource<T> {
            return StatusResource(ActionStatus.LOADING, data, null)
        }

    }

}
