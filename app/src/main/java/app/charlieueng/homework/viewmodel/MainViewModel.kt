package app.charlieueng.homework.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.charlieueng.homework.model.ApiService
import app.charlieueng.homework.model.AppClientManager
import app.charlieueng.homework.model.DataModel
import app.charlieueng.homework.model.UserData
import io.reactivex.Single
import retrofit2.Response

class MainViewModel : ViewModel() {

    enum class AppState{
        Login,News,Timezone
    }

    val appState = MutableLiveData<AppState>()
    val userData = MutableLiveData<UserData>()

    //val dataModel = DataModel()
    init {
        appState.value=AppState.Login
    }

    fun loginRX(email:String, pass:String): Single<Response<UserData>> {
        return DataModel.loginRX(email,pass)
    }
}