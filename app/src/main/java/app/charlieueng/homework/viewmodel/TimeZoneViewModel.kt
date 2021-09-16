package app.charlieueng.homework.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.charlieueng.homework.model.*
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.RequestBody
import retrofit2.Response

class TimeZoneViewModel : ViewModel() {
    val data = MutableLiveData<UpdateData>()

    private fun updatePhone(token:String, id: String, body:RequestBody): Single<Response<UpdateData>> {
        return DataModel.updatePhone(token, id, body)
    }

    fun viewUpdatePhone(token:String, id: String, body:RequestBody){
        updatePhone(token, id, body)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { r ->
                data.value = r.body()
            }
    }
}