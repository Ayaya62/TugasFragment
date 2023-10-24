package com.example.pppbpertemuan8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.pppbpertemuan8.databinding.ActivityMainBinding
import com.example.pppbpertemuan8.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "MyTabLayout"
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_option, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_quit ->{
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}