package app.charlieueng.homework.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.charlieueng.homework.model.DataModel
import app.charlieueng.homework.model.NewsData
import app.charlieueng.homework.model.NewsObjectData
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class ListViewModel :ViewModel() {
    val dataList = MutableLiveData<ArrayList<NewsData>>()

    private fun getListData():Single<Response<NewsObjectData>>{
        return DataModel.getListData()
    }

    fun viewGetListData(){
        getListData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { r ->
                dataList.value = r.body()?.list
            }
    }
}