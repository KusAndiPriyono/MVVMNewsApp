package com.bangkit.mvvmnewsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.bangkit.mvvmnewsapp.databinding.ActivityMainBinding
import com.bangkit.mvvmnewsapp.presentation.adapter.NewsAdapter
import com.bangkit.mvvmnewsapp.presentation.viewmodel.NewsViewModel
import com.bangkit.mvvmnewsapp.presentation.viewmodel.NewsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: NewsViewModelFactory

    @Inject
    lateinit var newsAdapter: NewsAdapter
    lateinit var viewModel: NewsViewModel

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_activity_main_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val bottomNav = binding.bottomNavigationView
        bottomNav.setupWithNavController(navController)

        viewModel = ViewModelProvider(this, factory)[NewsViewModel::class.java]
    }
}