package com.example.demomvp.data.model

data class Book(
    val title: String?,
    val author: String?,
    val description: String?,
    val urlThumbnail: String?
)

object BookEntry {
    const val OBJECT = "books"
    const val ITEMS = "items"
    const val TITLE = "title"
    const val AUTHORS = "authors"
    const val VOLUMEINFO = "volumeInfo"
    const val IMAGELINK = "imageLinks"
    const val DESCRIPTION = "description"
    const val URL_THUMBNAIL = "smallThumbnail"
}
