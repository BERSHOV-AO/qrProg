package ru.nak.ied.qrprog

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class UserActivity : AppCompatActivity() {

    var bScannerQrcode: Button? = null;
    var viewText: TextView? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user)

        bScannerQrcode = findViewById(R.id.buttonScanner)
        viewText = findViewById(R.id.textView)

        bScannerQrcode?.setOnClickListener {
            startActivity(Intent(this, ScannerActivity::class.java))
            finish()
        }

        val responseValue = intent.getStringExtra("key");
        viewText?.setText(responseValue)

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}