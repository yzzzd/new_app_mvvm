package id.nuryaz.newapp.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.nuryaz.newapp.R
import id.nuryaz.newapp.ui.base.BaseActivity
import id.nuryaz.newapp.ui.form.input.FormInputActivity

class SplashActivity : BaseActivity<SplashViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        lifecycle.addObserver(viewModel)
        observeData()
        viewModel.delayCountDown(3000)
    }

    private fun observeData() {
        viewModel.splashNotifier.observe(this, {
            if (it) {
                val formIntent = Intent(this, FormInputActivity::class.java)
                startActivity(formIntent)
                finish()
            }
        })
    }
}