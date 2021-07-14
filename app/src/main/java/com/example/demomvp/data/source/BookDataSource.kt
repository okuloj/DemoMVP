package com.example.demomvp.data.source

import com.example.demomvp.data.source.remote.OnFetchDataListener
import com.example.demomvp.data.model.Book

interface BookDataSource {
    interface Remote{
        fun getBooksFromRemote(listener: OnFetchDataListener<MutableList<Book>>)
    }
}
