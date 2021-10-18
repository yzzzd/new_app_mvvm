package id.nuryaz.newapp.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.nuryaz.newapp.R
import id.nuryaz.newapp.ui.base.BaseActivity

class SplashActivity : BaseActivity<SplashViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }
}