package com.example.itemmenu

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.itemmenu.databinding.ActivityNotelistBinding

class NotelistActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNotelistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNotelistBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_notelist);
        setSupportActionBar(binding.toolbar)
        val list_item: ListView = findViewById(R.id.list_item)
        val navController = findNavController(R.id.nav_host_fragment_content_notelist)
        val dm = datamanager()
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
           val activityIntent = Intent(this,MainActivity::class.java)
            startActivity(activityIntent)
        }
        list_item.adapter = ArrayAdapter(this,
        android.R.layout.simple_list_item_1,
            dm.notes

        )

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_notelist)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}