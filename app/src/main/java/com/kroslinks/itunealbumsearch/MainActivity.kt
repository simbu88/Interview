package com.kroslinks.itunealbumsearch

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kroslinks.itunealbumsearch.adapter.AlbumAdapter
import com.kroslinks.itunealbumsearch.model.Result
import com.kroslinks.itunealbumsearch.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.content_main.*
import java.util.ArrayList


class MainActivity : AppCompatActivity(),AlbumAdapter.SelectedItem {

    private lateinit var linearLayoutManager: LinearLayoutManager
    var adapter: AlbumAdapter? = null
    var filterList = arrayOf("Collection Name", "Track name", "Artist name", "Collection price")
    var listOfAlbum:List<Result>?=null
    var sortListOfAlbum:List<Result>?=null
    var selectedResult:List<Result>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        loadRecyclerView()


    }

    private fun loadRecyclerView() {
        linearLayoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = linearLayoutManager
        var mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val itemDecor = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
        recycler_view.addItemDecoration(itemDecor)
        mViewModel.getAlbumList().observe(this, Observer { it ->
            listOfAlbum=it!!.results
            adapter = AlbumAdapter(this, listOfAlbum!!.distinctBy { it.trackName }.sortedByDescending { it.releaseDate },this)
            recycler_view.adapter = adapter
        })

        image_view_filter.setOnClickListener {
            openDialog()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        var mSearch: MenuItem = menu.findItem(R.id.action_search)
        val mSearchView: SearchView = mSearch.actionView as SearchView
        mSearchView.setQueryHint("Search")
        mSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter!!.filter.filter(newText)
                return true
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        if(item.itemId==R.id.addcart){
           var intent= Intent(MainActivity@this,CartActivity::class.java)
           if(selectedResult!=null) {
               intent.putParcelableArrayListExtra(
                   "Selecteditem",
                   selectedResult as ArrayList<out Parcelable>
               )
               startActivity(intent)
           }else{
               Toast.makeText(this,"Select any one item",Toast.LENGTH_LONG).show()
           }
           return true
        }

        return false
    }

    fun openDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Filter By")
        val checkedItem = 0 // cow
        builder.setSingleChoiceItems(filterList, checkedItem){ dialog, which ->
            when (which) {

                0 -> {
                    dialog.dismiss()
                    sortListOfAlbum=listOfAlbum?.sortedBy { it.collectionName }
                }
                1 -> {
                    dialog.dismiss()
                    sortListOfAlbum=listOfAlbum?.sortedBy { it.trackName }
                }
                2 -> {
                    dialog.dismiss()
                    sortListOfAlbum=listOfAlbum?.sortedBy { it.artistName }
                }
                3 -> {
                    dialog.dismiss()
                    sortListOfAlbum=listOfAlbum?.sortedByDescending { it.collectionPrice }
                }
            }
            adapter = AlbumAdapter(this, sortListOfAlbum!!.distinctBy { it.trackName }, this)
            recycler_view.adapter=adapter
            adapter!!.notifyDataSetChanged()

        }
        val dialog = builder.create()
        dialog.show()

    }

    override fun onSelectedItem(listItems: List<Result>) {
        selectedResult=listItems.filter { it.isSelected }
    }
}