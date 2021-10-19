package id.nuryaz.newapp.ui.form.list

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.nuryaz.newapp.injection.anotation.ViewModelKey

@Module
abstract class VisitListModule {
    @Binds
    @IntoMap
    @ViewModelKey(VisitListViewModel::class)
    abstract fun bindViewModel(visitListViewModel: VisitListViewModel): ViewModel
}