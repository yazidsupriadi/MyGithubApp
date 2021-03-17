package com.example.mygithub

import Github
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListGithubAdapter(val listGithub: ArrayList<Github>) : RecyclerView.Adapter<ListGithubAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_github, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val github = listGithub[position]
        Glide.with(holder.itemView.context)
            .load(github.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvName.text = github.name
        holder.tvDetail.text = github.username

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listGithub[holder.adapterPosition]) }

    }

    override fun getItemCount(): Int {
        return listGithub.size
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: Github)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_username)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}
