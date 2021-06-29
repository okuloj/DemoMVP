package com.example.demomvp.data.source.remote

import com.example.demomvp.data.model.Book
import com.example.demomvp.data.source.remote.fetchJson.ParseDataWithJson
import com.example.demomvp.utils.Constant
import com.example.demomvp.data.source.BookDataSource

class BookRemoteDataSource: BookDataSource.Remote {

    private object Holder{
        val INSTANCE = BookRemoteDataSource()
    }

    companion object{
        val instance: BookRemoteDataSource by lazy { Holder.INSTANCE }
    }

    override fun getBooksFromRemote(listener: OnFetchDataListener<MutableList<Book>>) {
        ParseDataWithJson(listener).execute(Constant.BASE_URL)
    }
}
