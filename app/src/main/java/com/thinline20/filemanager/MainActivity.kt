package com.thinline20.filemanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        val recyclerView: RecyclerView = findViewById(R.id.file_view)
        val fileList = mutableListOf(
            FileItem("file1", "/path/to/file1", false),
            FileItem("file2", "/path/to/file2", false),
            FileItem("file3", "/path/to/file3", false),
            FileItem("folder1", "/path/to/folder1", true),
            FileItem("folder2", "/path/to/folder2", true),
            FileItem("file4", "/path/to/file4", false),
        )
        val adapter = FileItemAdapter(this, fileList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)

        val recyclerViewDecoration =
            DividerItemDecoration(this, androidx.recyclerview.widget.LinearLayoutManager.VERTICAL)
        recyclerView.addItemDecoration(recyclerViewDecoration)
    }
}