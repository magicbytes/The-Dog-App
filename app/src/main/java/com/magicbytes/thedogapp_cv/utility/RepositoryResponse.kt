package com.magicbytes.thedogapp_cv.utility


sealed class ServiceResponse<out T : Any> {
    class Success<out T : Any>(val data: T) : ServiceResponse<T>()
    class Error(val error: Exception = Exception()) : ServiceResponse<Nothing>()

    val isError: Boolean
        get() = this is Error

    val isSuccess: Boolean
        get() = this is Success

    val successData: T
        get() = (this as Success).data

    val possibleSuccessData: T?
        get() = (this as? Success)?.data

    fun onSuccess(action: (data: T) -> Unit): ServiceResponse<T> {
        if (this is Success) {
            action(data)
        }
        return this
    }

    suspend fun onSuccessCoroutine(action: suspend (data: T) -> Unit): ServiceResponse<T> {
        if (this is Success) {
            action(data)
        }
        return this
    }

    fun onError(action: (error: Exception) -> Unit): ServiceResponse<T> {
        if (this is Error) {
            action(error)
        }
        return this
    }

    suspend fun onErrorCoroutine(action: suspend (error: Exception) -> Unit): ServiceResponse<T> {
        if (this is Error) {
            action(error)
        }
        return this
    }
}
