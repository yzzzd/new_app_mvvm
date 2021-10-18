package id.nuryaz.newapp.injection

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.nuryaz.newapp.ui.splash.SplashActivity
import id.nuryaz.newapp.ui.splash.SplashModule

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [SplashModule::class])
    abstract fun bindSplashActivity(): SplashActivity
}