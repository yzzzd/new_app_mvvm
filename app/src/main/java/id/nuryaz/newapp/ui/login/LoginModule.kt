package id.nuryaz.newapp.ui.login

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.nuryaz.newapp.injection.anotation.ViewModelKey

@Module
abstract class LoginModule {
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindViewModel(loginViewModel: LoginViewModel): ViewModel
}