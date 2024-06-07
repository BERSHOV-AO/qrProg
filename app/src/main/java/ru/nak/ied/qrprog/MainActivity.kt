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
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    var bUserActivity: ConstraintLayout? = null;
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
                startActivity(Intent(this, OneUserActivity::class.java))
            } else {
               showAlertDialog(this, "Предупреждение!",
                   "Ошибка аутентификации. Пожалуйста, " +
                           "проверьте ваш логин и пароль и повторите попытку")
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun showAlertDialog(context: Context, title: String, message: String) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
        builder.setMessage(message)

        // Добавляем кнопку "OK"
        builder.setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }

        val dialog = builder.create()
        dialog.show()
    }
}