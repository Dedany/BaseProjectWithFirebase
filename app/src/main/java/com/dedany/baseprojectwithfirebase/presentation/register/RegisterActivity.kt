package com.dedany.baseprojectwithfirebase.presentation.register

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.dedany.baseprojectwithfirebase.R
import com.dedany.baseprojectwithfirebase.databinding.ActivityHomeBinding
import com.dedany.baseprojectwithfirebase.databinding.ActivityRegisterBinding
import com.dedany.baseprojectwithfirebase.presentation.home.HomeActivityViewModel

class RegisterActivity : AppCompatActivity() {

    private var binding: ActivityRegisterBinding? = null
    private var viewModel: RegisterActivityViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[RegisterActivityViewModel::class.java]
         setContentView(binding?.root)

        binding?.btnRegister?.setOnClickListener {
    }
}