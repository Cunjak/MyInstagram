package com.example.myinstagramnew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.myinstagramnew.fragments.HomeFragment
import com.example.myinstagramnew.fragments.NotificationsFragment
import com.example.myinstagramnew.fragments.ProfileFragment
import com.example.myinstagramnew.fragments.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    private var selectedFragment: Fragment? = null

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener{
        when(it.itemId){
            R.id.nav_home -> {

                selectedFragment = HomeFragment()
            }
            R.id.nav_search ->
            {

                selectedFragment = SearchFragment()
            }
            R.id.nav_add_post ->
            {

                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_notifications ->
            {

               selectedFragment = NotificationsFragment()
            }
            R.id.nav_profile ->
            {

               selectedFragment = ProfileFragment()
            }
        }
        if (selectedFragment != null){
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, selectedFragment!!).commit()
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nav_view: BottomNavigationView = findViewById(R.id.nav_view)
        nav_view.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()

    }
}