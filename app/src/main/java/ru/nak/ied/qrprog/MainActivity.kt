package ru.nak.ied.qrprog

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var bScanner: Button? = null;
    var bUserActivity: Button? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        bScanner = findViewById(R.id.bScan)
        bUserActivity = findViewById(R.id.bEntrance)
        bScanner?.setOnClickListener{
            startActivity(Intent(this, ScannerActivity::class.java))
        }

        bUserActivity?.setOnClickListener{
            startActivity(Intent(this, UserActivity::class.java))
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}