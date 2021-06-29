package com.example.demomvp.data.source

import com.example.demomvp.data.source.remote.BookRemoteDataSource
import com.example.demomvp.data.source.remote.OnFetchDataListener
import com.example.demomvp.data.model.Book

class BookRepository private constructor(
    private val remote: BookDataSource.Remote) {

    private object Holder {
        val INSTANCE = BookRepository(BookRemoteDataSource.instance)
    }

    fun getBooks(listener: OnFetchDataListener<MutableList<Book>>) {
        remote.getBooksFromRemote(listener)
    }

    companion object {
        val instance: BookRepository by lazy { Holder.INSTANCE }
    }
}
