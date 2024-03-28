package com.example.task

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

        val Name = findViewById<EditText>(R.id.name)
        val ID = findViewById<EditText>(R.id.id)
        val PW = findViewById<EditText>(R.id.pw)
        val Join = findViewById<Button>(R.id.join)

        Join.setOnClickListener {
            val iname = Name.text.toString()
            val iid = ID.text.toString()
            val ipw = PW.text.toString()

            check(this,iname,iid,ipw)
        }
    }

    private  fun Toastm(context: Context,message: String){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
    }

    private fun check(signUpActivity: SignUpActivity, iname: String, iid: String, ipw: String) {

        val TName = iname.trim()
        val TID = iid.trim()
        val TPW = ipw.trim()
        if(TID.isEmpty() || TPW.isEmpty() || TName.isEmpty()) {
            Toastm(this,"입력되지 않은 정보가 있습니다")
        } else {
            val intent = Intent(this,SignInActivity::class.java)
            startActivity(intent)
            finish()

        }

    }
}