package com.example.covid19realtime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.covid19realtime.base.OnToolbarAvailableListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    private val navController: NavController by lazy {
        findNavController(R.id.navHostFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
    }

    private fun setupViews(){
        toolbar.setupWithNavController(navController)
    }
}
