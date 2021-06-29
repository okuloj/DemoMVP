package com.example.demomvp.screen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demomvp.R
import com.example.demomvp.data.model.Book
import com.example.demomvp.utils.getImage
import kotlinx.android.synthetic.main.item_book.view.*


class MainAdapter(): RecyclerView.Adapter<MainAdapter.ViewHolder?>() {

    private val books = mutableListOf<Book>()

    fun updateData(books: MutableList<Book>?) {
        books?.let {
            this.books.clear()
            this.books.addAll(it)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(books[position])
    }

    override fun getItemCount() = books.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(book: Book) {
            with(itemView) {
                textTitle.text = book.title.toString()
                textAuthor.text = book.author.toString()
                imageBook.getImage(book.urlThumbnail.toString())
            }
        }
    }
}
