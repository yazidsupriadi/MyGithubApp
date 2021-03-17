package com.example.mygithub

import Github
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvGithubs: RecyclerView
    private var list: ArrayList<Github> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvGithubs = findViewById(R.id.rv_github)
        rvGithubs.setHasFixedSize(true)
        list.addAll(GithubData.listData)
        showRecyclerList()
    }
    private fun showRecyclerList() {
        rvGithubs.layoutManager = LinearLayoutManager(this)
        val listGithubAdapter = ListGithubAdapter(list)
        rvGithubs.adapter = listGithubAdapter

        listGithubAdapter.setOnItemClickCallback(object : ListGithubAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Github) {
                showSelectedGithub(data)
            }
        })
    }

    private fun showSelectedGithub(github: Github) {
        Toast.makeText(this, "Kamu memilih " + github.name, Toast.LENGTH_SHORT).show()
    }

}