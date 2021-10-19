package id.nuryaz.newapp.ui.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import id.nuryaz.newapp.api.ApiResponse
import id.nuryaz.newapp.api.ApiService
import id.nuryaz.newapp.data.Session
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

open class BaseViewModel: ViewModel(), LifecycleObserver {

    @Inject
    lateinit var session: Session
    @Inject
    lateinit var gson: Gson
    @Inject
    open lateinit var apiService: ApiService

    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    val apiResponse = MutableLiveData<ApiResponse>()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}