package com.example.mytestwork

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.mytestwork.databinding.ActivityUserBinding
import com.example.mytestwork.db.UserEntity

class UserActivity : AppCompatActivity() {
    lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var user = intent.getParcelableExtra<UserEntity>("user")
        println(user)
        binding.id.text = user?.id.toString()
        binding.name1.text = user?.userName
        binding.src.text = user?.api
        Glide.with(this).load(user?.image).error(R.drawable.ic_launcher_foreground).into(binding.imageView2)

    }
}