package com.example.demomvp.screen

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.demomvp.R
import com.example.demomvp.data.model.Book
import com.example.demomvp.data.source.BookRepository
import com.example.demomvp.screen.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private val adapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    private fun initData() {
        MainPresenter(BookRepository.instance).apply {
            setView(this@MainActivity)
            start()
        }
    }

    private fun initView() {
        recyclerviewBook.setHasFixedSize(true)
        adapter?.let {
            recyclerviewBook.adapter = it
        }
    }

    override fun getBooksSuccess(book: MutableList<Book>) {
        adapter.updateData(book)
    }

    override fun error(exception: Exception?) {
        Toast.makeText(this, exception?.message, Toast.LENGTH_LONG).show()
    }
}
