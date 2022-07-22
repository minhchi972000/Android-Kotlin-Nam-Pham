package com.example.mvvm_login_signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.mvvm_login_signup.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private  lateinit var binding:ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_profile)
        val bundle= intent.extras
        bundle?.let {
            val student : Student? = it.getParcelable(Constants.KEY_USER)
            student?.let {
                binding.tvProfile.text ="${student.email} - ${student.password}"
            }

        }
    }
}