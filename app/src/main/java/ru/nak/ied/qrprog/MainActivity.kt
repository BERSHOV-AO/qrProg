package ru.nak.ied.qrprog

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var bUserActivity: Button? = null;
    var textNum: EditText? = null;
    var textPass: EditText? = null

    var presetPersonNum = "1"
    var presetPass = "0000"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        bUserActivity = findViewById(R.id.bEntrance)
        textNum = findViewById(R.id.personNum)
        textPass = findViewById(R.id.password)

        bUserActivity?.setOnClickListener {
            val pass: String = textPass?.text.toString()
            val prNum: String = textNum?.text.toString()
            if (presetPass.equals(pass) && presetPersonNum.equals(prNum)) {
                startActivity(Intent(this, UserActivity::class.java))
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}