package ru.nak.ied.qrprog

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OneUserActivity : AppCompatActivity() {

    var bScannerQR: Button? = null;
    var textViewQR: TextView? = null;
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_one_user)
        bScannerQR = findViewById(R.id.bScanQR)
        textViewQR = findViewById(R.id.textViewQtCode)

        bScannerQR?.setOnClickListener {
            startActivity(Intent(this, ScannerActivity::class.java))
            finish()
        }

        val responseValue = intent.getStringExtra("key");
        textViewQR?.setText(responseValue)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}