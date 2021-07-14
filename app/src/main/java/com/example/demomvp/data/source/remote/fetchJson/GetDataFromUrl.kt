package com.example.demomvp.data.source.remote.fetchJson

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class GetDataFromUrl {

    fun getDataFromUrl(url: String): String? {
        var urlConn: HttpURLConnection? = null
        var result = ""
        try {
            urlConn = URL(url).openConnection() as HttpURLConnection
            urlConn?.run {
                val code = this.responseCode
                if (code != 200) {
                    throw IOException("Invalid response from server: $code")
                }
                val rd = BufferedReader(InputStreamReader(this.inputStream))
                var isCheck = true
                while (true) {
                    var line = rd.readLine()
                    if (line == null) {
                        break
                    } else {
                        if (isCheck){
                            result += line
                            isCheck = false
                        }
                        else {
                            result += "\n" +  line
                        }
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            urlConn?.disconnect()
        }
        return result
    }
}
