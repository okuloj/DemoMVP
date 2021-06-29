package com.example.demomvp.utils

interface BasePresenter<T>{
    fun start()
    fun setView(view: T?)
}
