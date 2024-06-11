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
import androidx.lifecycle.asLiveData
import ru.nak.ied.qrprog.data.databaseConnection.MainDb

class MainActivity : AppCompatActivity() {


    var bUserActivity: ConstraintLayout? = null;
    var nameUser: String? = null;
    var bSettingsActivity: ConstraintLayout? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        bUserActivity = findViewById(R.id.bEntrance)
        bSettingsActivity = findViewById(R.id.bSettings)
        val personNum: TextView = findViewById(R.id.personNum)
        val pass: TextView = findViewById(R.id.password)
        nameUser = "Алексей"

        val db = MainDb.getDb(this)

        bSettingsActivity?.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        bUserActivity?.setOnClickListener {
            if (personNum.text.isNotEmpty() || pass.text.isNotEmpty()) {
                db.getUserDao().getAllUsers().asLiveData().observe(this) { list ->
                    var userFound = false
                    list.forEach {
                        if (it.userNumber.toString() == personNum.text.toString() &&
                            it.userPassword.toString() == pass.text.toString()
                        ) {
                            Toast.makeText(
                                this, "Вход выполнен! " +
                                        "\nЗдравствуйте ${it.name} ${it.surname}!",
                                Toast.LENGTH_LONG
                            ).show()

                            personNum.text = ""
                            pass.text = ""

                            startActivity(Intent(this, OneUserActivity::class.java))

                            userFound = true
                            return@forEach  // Завершаем цикл, так как пользователь найден
                        }
                    }

                    if (!userFound) {
                        Toast.makeText(
                            this, "Ошибка аутентификации. \nПожалуйста," +
                                    " проверьте ваш логин и пароль и повторите попытку!",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }

//            if (pass.text.isEmpty() || pass.text.contains(" ")) {
//                Toast.makeText(this, "Проверьте пароль!", Toast.LENGTH_LONG).show()
//            } else if (personNum.text.isEmpty() || personNum.text.length != 6) {
//                Toast.makeText(
//                    this, "Проверьте табельный номер!" +
//                            " \nТабельный номер должен быть 6 цифр!",
//                    Toast.LENGTH_LONG
//                ).show()
//            } else if (presetPass.equals(pass.text.toString()) &&
//                presetPersonNum.equals(personNum.text.toString())
//            ) {
//                Toast.makeText(
//                    this, "Вход выполнен! \nЗдравствуйте ${nameUser}!",
//                    Toast.LENGTH_LONG
//                ).show()
//                startActivity(Intent(this, OneUserActivity::class.java))
//
//            } else {
//                Toast.makeText(
//                    this, "Ошибка аутентификации. " +
//                            "\nПожалуйста,проверьте ваш логин и пароль и повторите попытку!",
//                    Toast.LENGTH_LONG
//                ).show()
//            }
//        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}