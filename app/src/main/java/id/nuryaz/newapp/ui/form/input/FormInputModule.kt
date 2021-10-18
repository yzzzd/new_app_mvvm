package id.nuryaz.newapp.ui.form.input

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.nuryaz.newapp.injection.anotation.ViewModelKey

@Module
abstract class FormInputModule {
    @Binds
    @IntoMap
    @ViewModelKey(FormInputViewModel::class)
    abstract fun bindViewModel(formInputViewModel: FormInputViewModel): ViewModel
}