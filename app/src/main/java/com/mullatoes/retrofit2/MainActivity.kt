package com.mullatoes.retrofit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var sizeTextView: TextView
    private lateinit var viewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = RetrofitInstance
            .getRetrofitInstance()
            .create(ApiInterface::class.java)
        val repository = UserRepository(retrofit)

        viewModel =
            ViewModelProvider(this, UserViewModelFactory(repository))[UserViewModel::class.java]

        sizeTextView = findViewById(R.id.tv_size)
        viewModel.getAllUsers()
        viewModel.users.observe(this) {
            sizeTextView.text = it.size.toString()

            for (user in it) {
                sizeTextView.text = user.name
                break
            }
        }
    }
}