package com.example.demomvp.screen

import com.example.demomvp.data.model.Book
import com.example.demomvp.utils.BasePresenter
import java.lang.Exception

interface MainContract {

    interface View {
        fun getBooksSuccess(book: MutableList<Book>)
        fun error(exception: Exception?)
    }

    interface Presenter: BasePresenter<View> {
        fun getBooks()
    }
}
