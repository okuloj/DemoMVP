package com.example.demomvp.data.source

import com.example.demomvp.data.model.Book
import com.example.demomvp.data.source.remote.BookRemoteDataSource
import com.example.demomvp.data.source.remote.OnFetchDataListener

class BookRepository private constructor(

    private val remote: BookDataSource.Remote) {

    fun getBooks(listener: OnFetchDataListener<MutableList<Book>>) {
        remote.getBooksFromRemote(listener)
    }

    companion object {
        val instance: BookRepository by lazy { BookRepository(BookRemoteDataSource.instance) }
    }
}
