package com.example.task

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets



        }

        val img = findViewById<ImageView>(R.id.imageView)
        when(Random.nextInt(1,5)){
            1 -> img.setImageResource(R.drawable.cat)
            2 -> img.setImageResource(R.drawable.cat2)
            3 -> img.setImageResource(R.drawable.cat3)
            4 -> img.setImageResource(R.drawable.cat4)
            5 -> img.setImageResource(R.drawable.cat5)
        }
        val id = intent.getStringExtra("ID")
        val ID = findViewById<TextView>(R.id.user_id)
        ID.text = id

        val End = findViewById<Button>(R.id.end)
        End.setOnClickListener {
            finish()
        }

    }
}