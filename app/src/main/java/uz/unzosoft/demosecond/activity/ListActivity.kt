package uz.unzosoft.demosecond.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import uz.unzosoft.demofirst.databinding.ActivityListBinding
import uz.unzosoft.demofirst.showToast
import uz.unzosoft.demosecond.adapters.OnClick
import uz.unzosoft.demosecond.adapters.ProfileAdapter
import uz.unzosoft.demosecond.models.Profile

class ListActivity : AppCompatActivity() {
    lateinit var binding: ActivityListBinding

    private var list = ArrayList<Profile>()
    lateinit var adapterProfile: ProfileAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()
        initUI()
    }

    private fun initUI() = with(binding) {
        adapterProfile = ProfileAdapter(list = list, object : OnClick {
            override fun clickProfile(profile: Profile) {
                showToast(profile.toString())
            }

        })
        binding.rv.adapter = adapterProfile
    }

    private fun loadData() {
        list.add(
            Profile(
                "Kunuz",
                "https://storage.kun.uz/source/thumbnails/_medium/9/rNA90YWRA0ZfMT0REkpTv4ID2y7Nad7O_medium.jpg"
            )
        )
        list.add(
            Profile(
                "Daryo",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR39cE-Rceq0XIm8ND75Ucme37DcDFl5oS0Iw&usqp=CAU"
            )
        )
        list.add(
            Profile(
                "Kunuz",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQqslVkK_kyC0CIgRBD9lreNynXhF0Z5pFdDA&usqp=CAU"
            )
        )
        list.add(
            Profile(
                "Aplesin",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZpwbXKQOSsmzYauvS87wACsu3y_Zj-NEnWA&usqp=CAU"
            )
        )
        list.add(
            Profile(
                "Kunuz",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRE4FbZQo-ne_9huQKrvMjWvYabu9fu4ISBMA&usqp=CAU"
            )
        )
        list.add(
            Profile(
                "Daryo",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR39cE-Rceq0XIm8ND75Ucme37DcDFl5oS0Iw&usqp=CAU"
            )
        )
        list.add(
            Profile(
                "Kunuz",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQqslVkK_kyC0CIgRBD9lreNynXhF0Z5pFdDA&usqp=CAU"
            )
        )
        list.add(
            Profile(
                "Aplesin",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZpwbXKQOSsmzYauvS87wACsu3y_Zj-NEnWA&usqp=CAU"
            )
        )
        list.add(
            Profile(
                "Kunuz",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRE4FbZQo-ne_9huQKrvMjWvYabu9fu4ISBMA&usqp=CAU"
            )
        )
        list.add(
            Profile(
                "Daryo",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR39cE-Rceq0XIm8ND75Ucme37DcDFl5oS0Iw&usqp=CAU"
            )
        )
        list.add(
            Profile(
                "Kunuz",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQqslVkK_kyC0CIgRBD9lreNynXhF0Z5pFdDA&usqp=CAU"
            )
        )
        list.add(
            Profile(
                "Aplesin",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSZpwbXKQOSsmzYauvS87wACsu3y_Zj-NEnWA&usqp=CAU"
            )
        )

    }
}

