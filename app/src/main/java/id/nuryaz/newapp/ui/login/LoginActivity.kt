package id.nuryaz.newapp.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import id.nuryaz.newapp.R
import id.nuryaz.newapp.ui.base.BaseActivity
import id.nuryaz.newapp.ui.form.list.VisitListActivity

class LoginActivity : BaseActivity<LoginViewModel>() {

    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnFCM: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        observeData()

        inputEmail = findViewById(R.id.input_email)
        inputPassword = findViewById(R.id.input_password)
        btnLogin = findViewById(R.id.btn_login)
        btnFCM = findViewById(R.id.btn_check_fcm)

        btnLogin.setOnClickListener {
            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()

            viewModel.login(email, password)
        }

        btnFCM.setOnClickListener {
            checkFcmToken()
        }
    }

    private fun observeData() {
        viewModel.userNotifier.observe(this, {
            if (!it.isNullOrEmpty()) {

                val dialogWelcome = DialogWelcomeFragment(it) {
                    val formIntent = Intent(this, VisitListActivity::class.java)
                    startActivity(formIntent)
                    finish()
                }

                dialogWelcome.show(supportFragmentManager, "login")
            }
        })
    }

    private fun checkFcmToken() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("new app", "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result

            // Log and toast
            Log.d("new app", "$token")
        })
    }
}