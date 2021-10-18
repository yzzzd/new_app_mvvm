package id.nuryaz.newapp.ui.form.output

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.nuryaz.newapp.injection.anotation.ViewModelKey

@Module
abstract class FormOutputModule {
    @Binds
    @IntoMap
    @ViewModelKey(FormOutputViewModel::class)
    abstract fun bindViewModel(formOutputViewModel: FormOutputViewModel): ViewModel
}