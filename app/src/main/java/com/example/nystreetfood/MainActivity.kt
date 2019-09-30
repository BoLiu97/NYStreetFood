package com.example.nystreetfood
import java.io.FileReader
import androidx.appcompat.app.AppCompatActivity


import android.os.Bundle

import com.opencsv.CSVReader;

import java.io.File
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.setupWithNavController
//import com.example.nystreetfood.Rest.Companion.readRestData
import kotlinx.android.synthetic.main.activity_main.*

import java.io.IOException


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        readRestData()
        setSupportActionBar(findViewById(R.id.toolbar))
        val navController=findNavController(R.id.nav_host_frag)
        toolbar.setupWithNavController(navController)
        toolbar.title = "Home"

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId) {
            R.id.action_home->findNavController(R.id.nav_host_frag).navigate(R.id.action_global_welcomeFragment)
            R.id.action_favourite->findNavController(R.id.nav_host_frag).navigate(R.id.action_global_savedRestMainFragment)
            R.id.action_style->findNavController(R.id.nav_host_frag).navigate(R.id.action_global_styleListMainFragment)
            R.id.action_food->findNavController(R.id.nav_host_frag).navigate(R.id.action_global_foodScreenMainFragment)
        }
        return super.onOptionsItemSelected(item)

    }

    var listOfRest = ArrayList<Rest>()
    fun readRestData(){
        try {
            val reader = CSVReader(FileReader("times_square_food_beverage_locations"))
            var nextLine: Array<String>? = null
            while (nextLine != null) {
                // nextLine[] is an array of values from the line
                println(nextLine[0] + nextLine[1] + "etc...")
                nextLine[0]
                listOfRest.add(
                    Rest(
                        nextLine[0],
                        nextLine[1],
                        nextLine[2],
                        nextLine[3],
                        nextLine[4],
                        nextLine[5],
                        nextLine[6],
                        0

                    )
                )
                nextLine = reader.readNext()
            }
        } catch (e: IOException) {
        }
    }


}
