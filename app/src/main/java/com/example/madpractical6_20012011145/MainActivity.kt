package com.example.madpractical6_20012011145


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.example.madpractical6_20012011145.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initVideoPlayer()

        binding.fButton.setOnClickListener{
            Intent(this, YoutubeActivity::class.java).apply {startActivity(this)}
        }
    }


    private fun initVideoPlayer(){
        val mediaController = MediaController(this)
        val uri: Uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.thestoryoflight)
        binding.myVideo.setMediaController(mediaController)
        mediaController.setAnchorView(binding.myVideo)
        binding.myVideo.setVideoURI(uri)
        binding.myVideo.requestFocus()
        binding.myVideo.start()
    }
}