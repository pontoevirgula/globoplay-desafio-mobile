package com.chsltutorials.desafio_altran.ui.home

data class RequestStatus private constructor(val status: Status, val message: String? = null) {

    companion object {
        val LOADED = RequestStatus(Status.SUCCESS)
        val LOADING = RequestStatus(Status.RUNNING)
        fun error(message: String?) = RequestStatus(Status.FAILED, message)
    }

    enum class Status {
        RUNNING,
        SUCCESS,
        FAILED
    }
}