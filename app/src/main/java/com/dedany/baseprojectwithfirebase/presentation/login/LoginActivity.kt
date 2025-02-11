package com.dedany.baseprojectwithfirebase.presentation.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import com.dedany.baseprojectwithfirebase.databinding.ActivityLoginBinding
import com.dedany.baseprojectwithfirebase.presentation.home.HomeActivity
import com.dedany.baseprojectwithfirebase.presentation.register.RegisterActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private var binding: ActivityLoginBinding? = null
    private var viewModel: LoginViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        setContentView(binding?.root)

        initListener()
        initObservers()

    }

    private fun initObservers() {
        viewModel?.isLoginSuccess?.observe(this) { isSuccess ->
            if (isSuccess) {
                startActivity(Intent(this, HomeActivity::class.java))

            } else {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel?.canDoLogin?.observe(this) { isEnabled ->
            binding?.btnLogin?.isEnabled = isEnabled
        }


    }


    private fun initListener() {
        binding?.etEmail?.doOnTextChanged { text, star, before, count ->
            viewModel?.setEmail(text.toString())
        }
        binding?.etPassword?.doOnTextChanged { text, star, before, count ->
            viewModel?.setPassword(text.toString())
        }

        binding?.btnLogin?.doOnTextChanged { text, star, before, count ->
            viewModel?.login()
        }

        binding?.tvRegister?.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        binding?.btnLogin?.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

    }
}

