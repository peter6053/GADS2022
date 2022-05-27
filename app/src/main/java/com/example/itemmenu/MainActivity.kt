package com.example.itemmenu

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.itemmenu.databinding.ActivityMainBinding
import android.view.LayoutInflater
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private var noteposition = position_not_set
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main);

        setSupportActionBar(binding.toolbar)
        val spinner: Spinner = findViewById(R.id.spinnercourses)
        val dm = datamanager()
        val adaptercouses = ArrayAdapter<Courseinfo>(
            this,

            android.R.layout.simple_spinner_item,
            dm.corses.values.toList()
        )
        adaptercouses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adaptercouses

        noteposition = intent.getIntExtra(Extar_note_positin, position_not_set)
        if (noteposition != position_not_set)
            displayNote()

    }

    private fun displayNote() {
        val dm = datamanager()
        val textnote: TextView = findViewById(R.id.editTextTextMultiLine)
        val textnote2: TextView = findViewById(R.id.editTextTextMultiLine2)
        val note = dm.notes[noteposition]
        textnote.setText(note.tittle)
        textnote2.setText(note.text)
        val spinner: Spinner = findViewById(R.id.spinnercourses)

        //val courseposition = dm.corses.values.indexOf(note.course)
        // spinner.setSelection(courseposition)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            R.id.next->{
                moveNext()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun moveNext() {
      ++noteposition
        displayNote()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    override fun onPause() {
        super.onPause()
        savenote()
    }

    private fun savenote() {
        val dm = datamanager()
        val note = dm.notes[noteposition]
        val textnote: TextView = findViewById(R.id.editTextTextMultiLine)
        val textnote2: TextView = findViewById(R.id.editTextTextMultiLine2)
        val spinner: Spinner = findViewById(R.id.spinnercourses)
       textnote.text.toString()
        textnote2.text.toString()
note.course = spinner.selectedItem as String

    }

}