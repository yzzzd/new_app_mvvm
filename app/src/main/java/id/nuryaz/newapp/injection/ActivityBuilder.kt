package id.nuryaz.newapp.injection

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.nuryaz.newapp.ui.form.input.FormInputActivity
import id.nuryaz.newapp.ui.form.input.FormInputModule
import id.nuryaz.newapp.ui.form.list.VisitListActivity
import id.nuryaz.newapp.ui.form.list.VisitListModule
import id.nuryaz.newapp.ui.form.output.FormOutputActivity
import id.nuryaz.newapp.ui.form.output.FormOutputModule
import id.nuryaz.newapp.ui.splash.SplashActivity
import id.nuryaz.newapp.ui.splash.SplashModule

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [SplashModule::class])
    abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [FormInputModule::class])
    abstract fun bindFormInputActivity(): FormInputActivity

    @ContributesAndroidInjector(modules = [FormOutputModule::class])
    abstract fun bindFormOutputActivity(): FormOutputActivity

    @ContributesAndroidInjector(modules = [VisitListModule::class])
    abstract fun bindVisitListActivity(): VisitListActivity
}