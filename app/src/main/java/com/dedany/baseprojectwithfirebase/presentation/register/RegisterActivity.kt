package com.dedany.baseprojectwithfirebase.presentation.register

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import com.dedany.baseprojectwithfirebase.databinding.ActivityRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {

    private var binding: ActivityRegisterBinding? = null
    private var viewModel: RegisterViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[RegisterViewModel::class.java]
        setContentView(binding?.root)

        initListener()
        initObservers()

    }

    private fun initObservers() {
        viewModel?.name?.observe(this) {
        }
        viewModel?.age?.observe(this) {
        }
        viewModel?.email?.observe(this) {
        }
        viewModel?.country?.observe(this) {
        }
        viewModel?.nameHasError?.observe(this) { hasError ->
            binding?.tilName?.error = "Campo obligatorio , el máximo de caracteres permitidos es 50"
            binding?.tilName?.isErrorEnabled = hasError
        }
        viewModel?.ageHasError?.observe(this) { hasError ->
            binding?.tilAge?.error = "Campo obligatorio , no puedes tener mas de 200 años"
            binding?.tilAge?.isErrorEnabled = hasError
        }
        viewModel?.emailHasError?.observe(this) { hasError ->
            binding?.tilEmail?.error =
                "Campo obligatorio , el máximo de caracteres permitidos es 50"
            binding?.tilEmail?.isErrorEnabled = hasError
        }
        viewModel?.countryHasError?.observe(this) { hasError -> }

        viewModel?.passwordHasError?.observe(this) { hasError ->
            binding?.tilPassword?.error = "Campo obligatorio , introduce contraseña"
            binding?.tilPassword?.isErrorEnabled = hasError
        }
        viewModel?.repeatPasswordHasError?.observe(this) { hasError ->
            binding?.tilRepeatPassword?.error = "la contraseña no es la misma que la anterior"
            binding?.tilRepeatPassword?.isErrorEnabled = hasError
        }

        viewModel?.isRegisterSuccess?.observe(this) { isSuccess ->
            if (isSuccess) {
                Toast.makeText(
                    this,
                    "Registro exitoso",
                    Toast.LENGTH_SHORT
                )
            }

        }
    }


    private fun initListener() {
        with(binding) {
            this?.etName?.doOnTextChanged() { text, start, before, count ->
                viewModel?.setUsername(text.toString())
            }
            this?.etAge?.doOnTextChanged { text, start, before, count ->
                viewModel?.setAge(text.toString())
            }
            this?.etEmail?.doOnTextChanged { text, start, before, count ->
                viewModel?.setEmail(text.toString())
            }
                this?.etCountry?.doOnTextChanged { text, start, before, count ->
                    viewModel?.setCountry(text.toString())
                }
                this?.etPassword?.doOnTextChanged { text, start, before, count ->
                    viewModel?.setPassword(text.toString())
                }
                this?.etRepeatPassword?.doOnTextChanged { text, start, before, count ->
                    viewModel?.setRepeatPassword(text.toString())
                }
                this?.btRegister?.setOnClickListener {
                    viewModel?.register()
                }
            }
        }

    }
