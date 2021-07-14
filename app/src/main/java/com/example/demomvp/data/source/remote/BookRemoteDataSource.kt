package com.example.demomvp.data.source.remote

import com.example.demomvp.data.model.Book
import com.example.demomvp.data.source.BookDataSource
import com.example.demomvp.data.source.remote.fetchJson.ParseDataWithJson
import com.example.demomvp.utils.Constant

class BookRemoteDataSource: BookDataSource.Remote {

    companion object{
        val instance: BookRemoteDataSource by lazy { BookRemoteDataSource() }
    }

    override fun getBooksFromRemote(listener: OnFetchDataListener<MutableList<Book>>) {
        ParseDataWithJson(listener).execute(Constant.BASE_URL)
    }
}
