package id.nuryaz.newapp.ui.barcode

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.nuryaz.newapp.injection.anotation.ViewModelKey

@Module
abstract class BarcodeModule {
    @Binds
    @IntoMap
    @ViewModelKey(BarcodeViewModel::class)
    abstract fun bindViewModel(barcodeViewModel: BarcodeViewModel): ViewModel
}