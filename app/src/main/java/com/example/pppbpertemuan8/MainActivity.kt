package com.example.pppbpertemuan8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.pppbpertemuan8.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var viewPager2:ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = "MyTabLayout"
//        supportActionBar?.hide()

        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
           viewPager.adapter = TabAdapter(this@MainActivity)
            viewPager2 = viewPager

            TabLayoutMediator(tabLayout, viewPager){
                tab, position ->
                tab.text = when(position){
                    0 -> "Register"
                    1 -> "Log In"
                    else -> ""
                }
            }.attach()
        }
    }
    fun toLoginPage(){
        viewPager2.setCurrentItem(1, true)
    }
}