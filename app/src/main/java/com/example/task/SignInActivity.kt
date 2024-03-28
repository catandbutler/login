package com.example.task

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signin)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

        val ID = findViewById<EditText>(R.id.id)
        val PW = findViewById<EditText>(R.id.pw)
        val Login = findViewById<Button>(R.id.login)
        val Join = findViewById<Button>(R.id.join)



        Join.setOnClickListener{
            Join()
        }
        Login.setOnClickListener {
            val IID = ID.text.toString()
            val IPW = PW.text.toString()
            check(this,IID,IPW)
        }

    }

    private fun Toastm(context: Context,message: String){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
    }

    private fun check(signInActivity: SignInActivity, IID: String, IPW: String) {
        val TID = IID.trim()
        val TPW = IPW.trim()
        if(TID.isEmpty() || TPW.isEmpty()) {
            Toastm(this,"아이디/비밀번호를 확인해주세요")
        } else {
            Toastm(signInActivity,"로그인 성공")
            val intent = Intent(this,HomeActivity::class.java)
            intent.putExtra("ID",IID)
            startActivity(intent)
        }
    }
    private fun Join(){
        val intent = Intent (this,SignUpActivity::class.java)
        startActivity(intent)
    }
}