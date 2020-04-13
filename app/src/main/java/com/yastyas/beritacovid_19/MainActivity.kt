package com.yastyas.beritacovid_19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yastyas.beritacovid_19.modeldata.Berita
import com.yastyas.beritacovid_19.modeldata.BeritaData
import com.yastyas.beritacovid_19.R
import com.yastyas.beritacovid_19.adapter.CardViewBeritaAdapter
import com.yastyas.beritacovid_19.adapter.CardViewGalleryAdapter
import com.yastyas.beritacovid_19.adapter.GridGalleryAdapter
import com.yastyas.beritacovid_19.adapter.ListBeritaAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private var list: ArrayList<Berita> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.addAll(BeritaData.listData)
        recyclerView = findViewById(R.id.rv_berita)
        recyclerView.setHasFixedSize(true)
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                showRecyclerList()
            }
            R.id.action_grid -> {
                showRecyclerGrid()
            }
            R.id.action_list_cardview -> {
                showCardViewList()
            }
            R.id.action_grid_cardview -> {
                showCardViewGrid()
            }
        }
    }

    private fun showCardViewGrid() {
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        val cardViewGalleryAdapter = CardViewGalleryAdapter(list)
        recyclerView.adapter = cardViewGalleryAdapter

        cardViewGalleryAdapter.setOnItemClickCallback(object :CardViewGalleryAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Berita) {
                showSelectedBerita(data)
            }
        })
    }

    private fun showCardViewList() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val cardViewBeritaAdapter = CardViewBeritaAdapter(list)
        recyclerView.adapter = cardViewBeritaAdapter

        cardViewBeritaAdapter.setOnItemClickCallback(object :CardViewBeritaAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Berita) {
                showSelectedBerita(data)
            }
        })
    }

    private fun showRecyclerList() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val listBeritaAdapter = ListBeritaAdapter(list)
        recyclerView.adapter = listBeritaAdapter

        listBeritaAdapter.setOnItemClickCallback(object :ListBeritaAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Berita) {
                showSelectedBerita(data)
            }
        })
    }

    private fun showRecyclerGrid() {
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        val gridGalleryAdapter = GridGalleryAdapter(list)
        recyclerView.adapter = gridGalleryAdapter

        gridGalleryAdapter.setOnItemClickCallback(object :GridGalleryAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Berita) {
                showSelectedBerita(data)
            }
        })
    }

    private fun showSelectedBerita(berita: Berita){
        Toast.makeText(this, "Kamu memilih " + berita.judul, Toast.LENGTH_LONG).show()
        val beritaIntent = Intent(this@MainActivity, BeritaActivity::class.java)
        startActivity(beritaIntent)
    }
}
