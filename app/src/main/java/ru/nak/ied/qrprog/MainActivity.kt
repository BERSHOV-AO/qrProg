package ru.nak.ied.qrprog

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.app.AlertDialog
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    var bUserActivity: ConstraintLayout? = null;
    var presetPersonNum = "123456"
    var presetPass = "0000"
    var nameUser: String? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        bUserActivity = findViewById(R.id.bEntrance)
        val personNum: TextView = findViewById(R.id.personNum)
        val pass: TextView = findViewById(R.id.password)
        nameUser = "Алексей"

        bUserActivity?.setOnClickListener {

            if (pass.text.isEmpty() || pass.text.contains(" ")) {
                Toast.makeText(this, "Проверьте пароль!", Toast.LENGTH_LONG).show()
            } else if (personNum.text.isEmpty() || personNum.text.length != 6) {
                Toast.makeText(
                    this, "Проверьте табельный номер!" +
                            " \nТабельный номер должен быть 6 цифр!",
                    Toast.LENGTH_LONG
                ).show()
            } else if (presetPass.equals(pass.text.toString()) &&
                presetPersonNum.equals(personNum.text.toString())
            ) {
                Toast.makeText(
                    this, "Вход выполнен! \nЗдравствуйте ${nameUser}!",
                    Toast.LENGTH_LONG
                ).show()
                startActivity(Intent(this, OneUserActivity::class.java))

            } else {
                Toast.makeText(
                    this, "Ошибка аутентификации. " +
                            "\nПожалуйста,проверьте ваш логин и пароль и повторите попытку!",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}