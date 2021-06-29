package com.example.demomvp.screen

import com.example.demomvp.data.model.Book
import com.example.demomvp.data.source.BookRepository
import com.example.demomvp.data.source.remote.OnFetchDataListener

class MainPresenter internal constructor(private val repository: BookRepository?) : MainContract.Presenter {

    private var view: MainContract.View? = null

    override fun start() {
        getBooks()
    }

    override fun setView(view: MainContract.View?) {
        this.view = view
    }

    override fun getBooks() {
        repository?.getBooks(object : OnFetchDataListener<MutableList<Book>> {
            override fun onSuccess(data: MutableList<Book>) {
                view?.getBooksSuccess(data)
            }

            override fun onError(exception: Exception?) {
                view?.error(exception)
            }
        })
    }
}
