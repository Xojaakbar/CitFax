package uz.unzosoft.demofirst.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit


/**
 * Created by Abdurashidov Shahzod on 13/11/22 23:56.
 * company QQBank
 * shahzod9933@gmail.com
 */

object SharedPreferenceUI {

    private const val NAME = "myPref"
    private const val MODE = Context.MODE_PRIVATE
    lateinit var sharedPreferences: SharedPreferences


    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.editor(operator: (SharedPreferences.Editor) -> Unit) {
        var editor = edit()
        operator(editor)
        editor.apply()
    }

    var user: String?
        get() = sharedPreferences.getString("user", "")
        set(value) = SharedPreferenceUI.sharedPreferences.edit() {
            if (value != null) {
                this.putString("user", value)
            }
        }
}