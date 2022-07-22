package com.example.mvvm_login_signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_login_signup.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.btnLogin.setOnClickListener {
            val email = binding.edtGmail.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()
            viewModel.checkEmailAndPassword(email, password)
        }
        listenerSuccessEvent()
        listenerErrorEvent()
    }

    private fun listenerSuccessEvent() {
        viewModel.isSuccessEvent.observe(this) {
            if (it) {
                val email = binding.edtGmail.text.toString().trim()
                val password = binding.edtPassword.text.toString().trim()
                val student = Student(email, password)
                val intent = Intent(applicationContext, ProfileActivity::class.java)
                Toast.makeText(applicationContext,"Thành công",Toast.LENGTH_LONG).show()
                val bundle = Bundle()
                bundle.putParcelable(Constants.KEY_USER, student)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }

    private fun listenerErrorEvent() {
        viewModel.isErrorEvent.observe(this) {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Error")
            dialog.setMessage(it)
            dialog.show()
            // Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    }
}