package com.example.demomvp.data.source.remote.fetchJson

import android.os.AsyncTask
import com.example.demomvp.data.source.remote.OnFetchDataListener
import org.json.JSONObject

class ParseDataWithJson<T>(private val listener: OnFetchDataListener<T>
): AsyncTask<String, Unit, String>() {

    private var exception: Exception? = null

    override fun doInBackground(vararg params: String?): String {
        var bookData = ""
        try {
            val getDataFromUrl = GetDataFromUrl()
            bookData = params[0]?.let { getDataFromUrl.getDataFromUrl(it).toString() }.toString()
        } catch (e: Exception) {
            exception = e
        }
        return bookData
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        if (result != null && result.isNotBlank()) {
            listener.onSuccess(ParseJson().parseJsonArray(JSONObject(result)) as T)
        } else listener.onError(exception)
    }
}
