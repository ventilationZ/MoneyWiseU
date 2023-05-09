package com.example.moneywiseu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var Btnlogin : Button
    private lateinit var BtnRegister : Button
    private lateinit var EdtEmail : TextView
    private lateinit var EdtPassword : TextView
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Btnlogin = findViewById(R.id.btnlogin)
        BtnRegister = findViewById(R.id.btnregister)
        EdtEmail = findViewById(R.id.edtemail)
        EdtPassword = findViewById(R.id.edtpassword)

        auth= FireBaseAuth.getInstance()
        BtnRegister.setOnClickListener {
            var gotoreg = Intent(this,RegisterActivity::class.java)
            startActivity(gotoreg)
        }
        Btnlogin.setOnClickListener {
            var email = EdtEmail.text.toString().trim()
            var password = EdtPassword.text.toString().trim()
            if (email.isEmpty()||password.isEmpty())
                Toast.makeText(this, "Can't submit an Empty Field", Toast.LENGTH_SHORT).show()
            else{
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "User Created Successfully", Toast.LENGTH_SHORT).show()
                        var gotomain = Intent(this, MainActivity::class.java)
                        startActivity(gotomain)


                    }   else {
                        Toast.makeText(this, "Failed to create an Account", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}