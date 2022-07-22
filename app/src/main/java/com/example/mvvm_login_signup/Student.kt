package com.example.mvvm_login_signup

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Student(val email: String, val password: String) : Parcelable {
}