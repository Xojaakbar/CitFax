package uz.unzosoft.demofirst

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uz.unzosoft.demofirst.databinding.ActivityLoginBinding
import uz.unzosoft.demofirst.model.User
import uz.unzosoft.demofirst.utils.SharedPreferenceUI

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private lateinit var gson: Gson
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        SharedPreferenceUI.init(this)
        gson = Gson()

        binding.apply {

            btnSave.setOnClickListener {

                val userName = edtUsername.text.toString()
                val userAge = edtUsername.text.toString()

                val userList = arrayListOf<User>()
                val user1 = SharedPreferenceUI.user
                val user = User(userName, userAge,"Male")

                if (user1 != "") {

                    val typeJson = object : TypeToken<List<User>>() {}.type
                    val fromJsonListUser = gson.fromJson<List<User>>(user1, typeJson)


                    userList.addAll(fromJsonListUser)
                    userList.add(user)
                    val toJsonUser = gson.toJson(userList)
                    SharedPreferenceUI.user = toJsonUser

                } else {
                    userList.add(user)
                    val toJsonUser = gson.toJson(userList)
                    SharedPreferenceUI.user = toJsonUser
                }
                if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(userAge)) {
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    showToast("Siz muvaffaqiyatli ro'yxatdan o'tdingiz")
                    finish()

                } else {
                    showToast("Login yoki parol kiritilmadi!!!")
                }
            }
        }
    }
}