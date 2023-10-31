package edu.farmingdale.alrajab.bcs421.sharedPref

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.farmingdale.alrajab.bcs421.MainActivity
import edu.farmingdale.alrajab.bcs421.R
import edu.farmingdale.alrajab.bcs421.databinding.ActivitySharedPrefBinding

class SharedPrefActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySharedPrefBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var recyclerView: RecyclerView
    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref)
        binding = ActivitySharedPrefBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        recyclerView = findViewById(R.id.recycler)
        firstName = findViewById(R.id.firstName)
        lastName = findViewById(R.id.lastName)

        binding.save.setOnClickListener {  saveFile() }

        binding.read.setOnClickListener { readFiles() }

        binding.update.setOnClickListener { updateFile() }

        binding.back.setOnClickListener { back() }
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
    /**
     * Saves input into shared preferences
     */
    private fun saveFile() {
        val key = firstName.text.toString()
        val value = lastName.text.toString()
        if (key.isNotBlank() && value.isNotBlank()){
            val editor = sharedPreferences.edit()
            editor.putString(key, value)
            editor.apply()
        }
    }

    /**
     * Reads from shared preferences
     */
    private fun readFiles() {
        updateFile()
    }
    /**
     * Updates the current file from shared preferences
     */
    private fun updateFile() {
        val dataList = getAllValues()
        val myAdapter = MyAdapter(this, dataList)
        recyclerView.adapter = myAdapter
    }
    /**
     * Updates the current file from shared preferences
     */
    private fun back() {
        startActivity( Intent(this, MainActivity::class.java) )
    }
    private fun getAllValues(): Map<String, *> {
        return sharedPreferences.all as Map<String, String>
    }
}