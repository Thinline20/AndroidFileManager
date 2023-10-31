package com.thinline20.filemanager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FileItemAdapter(private val context: Context, private val fileList: MutableList<FileItem>) :
    RecyclerView.Adapter<FileItemAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val filename: TextView = itemView.findViewById(R.id.filename)
        val fileDesc: TextView = itemView.findViewById(R.id.fileDesc)
        val fileIcon: ImageView = itemView.findViewById(R.id.fileIcon)
        val fileItem: LinearLayout = itemView.findViewById(R.id.fileItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val fileItemView =
            LayoutInflater.from(parent.context).inflate(R.layout.file_item, parent, false)
        return ViewHolder(fileItemView)
    }

    override fun getItemCount() = fileList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fileItem = fileList[position]
        holder.filename.text = fileItem.name
        holder.fileDesc.text = fileItem.isDirectory.toString()
        if (fileItem.isDirectory) {
            holder.fileIcon.setImageResource(R.drawable.baseline_folder_24)
        } else {
            holder.fileIcon.setImageResource(R.drawable.baseline_description_24)
        }

        holder.fileItem.setOnClickListener {
            holder.fileDesc.text = "Clicked"
        }
    }
}