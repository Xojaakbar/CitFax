package uz.unzosoft.demofirst

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uz.unzosoft.demofirst.databinding.ActivityAnimationBinding
import uz.unzosoft.demofirst.model.User
import uz.unzosoft.demofirst.utils.SharedPreferenceUI

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimationBinding
    private lateinit var gson: Gson

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        SharedPreferenceUI.init(this)
        gson = Gson()

        binding.btnSave.setOnClickListener {
            val user = SharedPreferenceUI.user
            val userName = binding.edtUsername.text.toString()
            val userAge = binding.edtAge.text.toString()
            val sex = "Male"

            if (user!=""){

                val typeJson = object : TypeToken<List<User>>() {}.type
                val fromJsonListUser = gson.fromJson<List<User>>(user, typeJson)

                for (list in fromJsonListUser) {
                    if (list.nameUser.trim() == userName && list.age.toString()
                            .trim() == userAge.trim()
                    ) {
                        showToast("Tizimga xush kelibsiz!!!!!")
                    }

                    if (!user.equals(userName) && !user.equals(userAge)) {
                        showToast("Login yoki parol xato!!!!!")
                    }
                   
                }
            }
        }
    }
}


fun Activity.showToast(str: String) {
    Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
}