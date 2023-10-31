package edu.farmingdale.alrajab.bcs421

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.farmingdale.alrajab.bcs421.database.DatabaseActivity
import edu.farmingdale.alrajab.bcs421.databinding.ActivityMainBinding
import edu.farmingdale.alrajab.bcs421.files.FileActivity
import edu.farmingdale.alrajab.bcs421.sharedPref.SharedPrefActivity

class MainActivity : AppCompatActivity() {

    // create binding view true - make sure to add it to the module build.gradle
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.databaseBtn.setOnClickListener {  processDatabase()}

        binding.filesBtn.setOnClickListener { processFiles() }

        binding.spBtn.setOnClickListener { processSharedPref() }

        // TODO 01:DB Edit the Database page so that you store  the first name and last name of the
        //  user input (EditView)

        // TODO 02:DB Update an existing name with a new one
        // TODO 03:DB Read from the files and write to the DB

    }

    /**
     * Move to the file activity
     */
    private fun processFiles() {
        startActivity( Intent(this, FileActivity::class.java) )
    }

    /**
     * Move to the database activity
     */
    private fun processDatabase() {
        startActivity( Intent(this, DatabaseActivity::class.java) )
    }
    /**
     * Move to the shared preferences activity
     */
    private fun processSharedPref() {
        startActivity( Intent(this, SharedPrefActivity::class.java) )
    }
}