package com.example.mytestwork

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mytestwork.databinding.ItemUserBinding
import com.example.mytestwork.db.UserEntity

class RvAdapter(val list: MutableList<UserEntity> ): RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.binding.name.text = list[position].userName
        holder.binding.api.text = list[position].api
        holder.binding.constrainLayout.setOnClickListener {
            val intent = Intent(holder.binding.root.context, UserActivity::class.java)
            intent.putExtra("user", list[position])
            holder.binding.root.context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return list.size
    }
    fun setList(list: List<UserEntity>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}

class UserViewHolder (val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root){

}

