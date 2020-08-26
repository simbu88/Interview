package com.kroslinks.itunealbumsearch

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kroslinks.itunealbumsearch.adapter.CartAdapter
import com.kroslinks.itunealbumsearch.model.Result
import com.kroslinks.itunealbumsearch.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.content_main.recycler_view

class CartActivity : AppCompatActivity() {
    private lateinit var linearLayoutManager: LinearLayoutManager
    var adapter: CartAdapter? = null
    var listOfAlbum: List<Result>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        listOfAlbum = intent.getParcelableArrayListExtra("Selecteditem")

        if (listOfAlbum.isNullOrEmpty()) {
           no_item.visibility= View.VISIBLE
            recycler_view.visibility=View.GONE
        } else {
            no_item.visibility= View.GONE
            recycler_view.visibility=View.VISIBLE
            loadRecyclerView()
        }
    }

    private fun loadRecyclerView() {
        linearLayoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = linearLayoutManager
        var mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val itemDecor = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
        recycler_view.addItemDecoration(itemDecor)
        adapter = CartAdapter(this, listOfAlbum!!)
        recycler_view.adapter = adapter


    }
}