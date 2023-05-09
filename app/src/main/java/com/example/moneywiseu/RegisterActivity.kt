package com.example.moneywiseu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {
    private lateinit var Btncreateacc : Button
    private lateinit var EdtNameReg : TextView
    private lateinit var EdtEmailReg : TextView
    private lateinit var EdtPasswordReg : TextView
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        Btncreateacc = findViewById(R.id.btncreateacc)
        EdtNameReg = findViewById(R.id.edtname)
        EdtEmailReg = findViewById(R.id.edtemailreg)
        EdtPasswordReg = findViewById(R.id.edtpasswordreg)
        auth= FirebaseAuth.getInstance()
        Btncreateacc.setOnClickListener {
            var name = EdtNameReg.text.toString().trim()
            var email = EdtEmailReg.text.toString().trim()
            var password = EdtPasswordReg.text.toString().trim()
            if (name.isEmpty()||email.isEmpty()||password.isEmpty())
                Toast.makeText(this, "Can't submit an Empty Field", Toast.LENGTH_SHORT).show()
            else{
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) {
                    if (it.isSuccessful){
                        Toast.makeText(this, "User Created Successfully", Toast.LENGTH_SHORT).show()
                        var gotologin = Intent(this, LoginActivity::class.java)
                        startActivity(gotologin)
                    }else {
                        Toast.makeText(this, "Failed to create an Account", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }
}