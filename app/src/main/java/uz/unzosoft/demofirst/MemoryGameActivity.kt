package uz.unzosoft.demofirst

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import uz.unzosoft.demofirst.databinding.ActivityMemoryGameBinding

class MemoryGameActivity : AppCompatActivity() {
    lateinit var binding: ActivityMemoryGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemoryGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSend.setOnClickListener {
            val edit = binding.editStr.text.toString()
            val intent = Intent()
            intent.putExtra("first", edit)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}