package uz.unzosoft.demosecond.adapters

import android.transition.CircularPropagation
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.bumptech.glide.Glide
import uz.unzosoft.demofirst.R
import uz.unzosoft.demofirst.databinding.ListItemBinding
import uz.unzosoft.demosecond.models.Profile


/**
 * Created by Abdurashidov Shahzod on 04/12/22 19:59.
 * company QQBank
 * shahzod9933@gmail.com
 */
class ProfileAdapter(private val list: List<Profile>,private val onClick: OnClick) :
    RecyclerView.Adapter<ProfileAdapter.MyViewHolder>() {


    inner class MyViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ListItemBinding.bind(itemView)
        fun render(profile: Profile) {
            binding.tv.text = profile.title
            binding.image.load(profile.image) {
                crossfade(true)
                placeholder(R.drawable.ic_launcher_background).transformations(
                    CircleCropTransformation()
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(parent.inflate(R.layout.list_item))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.render(list[position])
        holder.binding.container.setOnClickListener {
            onClick.clickProfile(list[position])
        }
    }

    override fun getItemCount(): Int = list.size


}


fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}
interface OnClick{
    fun clickProfile(profile: Profile)
}