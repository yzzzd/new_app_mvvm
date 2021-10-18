package id.nuryaz.newapp

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import id.nuryaz.newapp.injection.DaggerAppComponent

class Core : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this).build()
    }
}