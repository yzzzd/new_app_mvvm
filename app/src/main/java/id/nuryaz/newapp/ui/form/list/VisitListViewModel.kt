package id.nuryaz.newapp.ui.form.list

import android.util.Log
import androidx.lifecycle.viewModelScope
import id.nuryaz.newapp.data.room.visit.Visit
import id.nuryaz.newapp.data.room.visit.VisitDao
import id.nuryaz.newapp.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class VisitListViewModel @Inject constructor(val visitDao: VisitDao) : BaseViewModel() {
    fun getData(done: (visit: List<Visit>) -> Unit) = viewModelScope.launch {
        val datas = visitDao.getAll()
        done(datas)
    }
}