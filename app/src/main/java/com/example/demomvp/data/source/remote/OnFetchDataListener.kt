package com.example.demomvp.data.source.remote

interface OnFetchDataListener<T> {
    fun onSuccess(data: T)
    fun onError(exception: Exception?)
}
