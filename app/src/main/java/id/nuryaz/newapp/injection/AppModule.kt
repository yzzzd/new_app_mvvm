package id.nuryaz.newapp.injection

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import id.nuryaz.newapp.api.ApiResponse
import id.nuryaz.newapp.data.Session
import id.nuryaz.newapp.ui.base.ViewModelFactory
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Binds
    abstract fun provideContext(application: Application): Context

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    companion object {
        @JvmStatic
        @Provides
        @Singleton
        fun provideSession(context: Context) = Session(context)

        @JvmStatic
        @Provides
        fun provideApiResponse() = ApiResponse()
    }
}
