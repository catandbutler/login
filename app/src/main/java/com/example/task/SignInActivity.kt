package com.example.task


import android.app.Activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge

import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


lateinit var login:ActivityResultLauncher<Intent>

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
        setResult()
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

        if(IID.isEmpty() || IPW.isEmpty()) {
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

        login.launch(intent)
    }

    private fun setResult(){
        login = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
            if (result.resultCode == Activity.RESULT_OK){
                val data: Intent? = result.data
                val TID = data?.getStringExtra("id")
                val TPW = data?.getStringExtra("pw")
                val GID = findViewById<EditText>(R.id.id)
                GID.setText(TID)
                val GPW = findViewById<EditText>(R.id.pw)
                GPW.setText(TPW)
            }
        }

    }
}