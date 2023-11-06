package com.deksi.bpsfmmobileapp.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.deksi.bpsfmmobileapp.login.api.LoginApiService
import com.deksi.bpsfmmobileapp.login.api.LoginRequest
import com.deksi.bpsfmmobileapp.login.api.LoginResponse
import com.deksi.bpsfmmobileapp.password.ForgotPasswordActivity
import com.deksi.bpsfmmobileapp.databinding.ActivityLoginBinding
import com.deksi.bpsfmmobileapp.signup.SignupActivity
import com.deksi.bpsfmmobileapp.home.HomeActivity
import com.deksi.bpsfmmobileapp.home.api.DashboardApiService
import com.deksi.bpsfmmobileapp.home.api.DashboardRequest
import com.deksi.bpsfmmobileapp.home.api.DashboardResponse
import okhttp3.Headers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        setUpListeners()
        userLogin()

    }

    private fun setUpListeners() {

        binding.textViewSignUp.setOnClickListener {
//            Snackbar.make(binding.textViewSignUp, "Radi!", Snackbar.LENGTH_LONG).show()
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        binding.textViewForgotPassword.setOnClickListener {
            val intentForgotPassword = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intentForgotPassword)
        }

    }

    private fun userLogin() {

        binding.buttonLogin.setOnClickListener {

            val email = binding.editTextEmailAddress.text.toString().trim()
            val password = binding.editTextPassword.text.toString().trim()

            if (email.isEmpty()) {
                binding.editTextEmailAddress.error = "Email required"
                binding.editTextEmailAddress.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                binding.editTextPassword.error = "Password required"
                binding.editTextPassword.requestFocus()
                return@setOnClickListener
            }


            val retrofit = Retrofit.Builder()
                .baseUrl("https://bps-fms-staging.azurewebsites.net/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            val loginService = retrofit.create(LoginApiService::class.java)

            val loginRequest = LoginRequest(email, password)

            val call = loginService.login(loginRequest)
            call.enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {
                        val token = response.body()?.transferObject
                        val userId = response.body()?.userId

                        if (token != null) {
                            val sharedPrefs = getSharedPreferences("AuthToken", Context.MODE_PRIVATE)
                            val editor = sharedPrefs.edit()
                            editor.putString("transferObject", token)
                            editor.apply()

                        }


                        val intent = Intent(applicationContext, HomeActivity::class.java)
                        intent.putExtra("email", email)
                        startActivity(intent)
                    } else {
                        Toast.makeText(applicationContext, "Wrong email or password", Toast.LENGTH_LONG)
                            .show()
                    }
//                    Toast.makeText(
//                        applicationContext,
//                        "Email:  $email Password: $password ",
//                        Toast.LENGTH_LONG
//                    ).show()
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })

        }
    }
}