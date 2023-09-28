package com.example.appidiomas

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appidiomas.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        initListeners()
    }

    private fun initListeners() {
        binding.btnPtBr.setOnClickListener {
            setLocale("pt", "BR")
        }

        binding.btnEn.setOnClickListener {
            setLocale("en", "US")
        }

        binding.btnEs.setOnClickListener {
            setLocale("es", "ES")
        }
    }

    private fun setLocale(language: String, country: String) {
        val locale = Locale(language, country)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

        binding.tvText.text = resources.getString(R.string.info)
        binding.tvAppName.text = resources.getString(R.string.app_name)
    }
}