package com.example.demomvp.data.source.remote.fetchJson

import com.example.demomvp.data.model.Book
import com.example.demomvp.data.model.BookEntry
import org.json.JSONException
import org.json.JSONObject

class ParseJson {

    fun bookParseJson(jsonObject: JSONObject) = jsonObject.getJSONObject(BookEntry.VOLUMEINFO).run {

        Book(
            getString(BookEntry.TITLE),
            getString(BookEntry.AUTHORS).toString(),
            getString(BookEntry.DESCRIPTION),
            getJSONObject(BookEntry.IMAGELINK).getString(BookEntry.URL_THUMBNAIL)
        )
    }

    fun parseJsonArray(jsonObject: JSONObject): MutableList<Book> {
        var data: MutableList<Book> = mutableListOf()
        try {
            val jsonArray = jsonObject?.getJSONArray(BookEntry.ITEMS)
            for (i in 0 until (jsonArray?.length() ?: 0)) {
                val item = jsonArray?.getJSONObject(i)?.let { bookParseJson(it) }
                item?.let { data.add(it) }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return data
    }
}
