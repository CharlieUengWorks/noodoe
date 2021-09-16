package app.charlieueng.homework.model

import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object DataModel {

    open interface onDataReadyCallback {
        fun onDataReady(data:UserData)
    }

    private val apiService = AppClientManager.apiService

    fun login(mail:String, pass:String, callback: onDataReadyCallback){
        apiService.login(mail,pass).enqueue(object : Callback<UserData>{
            override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                val userData = response.body()
                if (userData != null && response.code()==200) {
                    callback.onDataReady(userData)
                }
            }

            override fun onFailure(call: Call<UserData>, t: Throwable) {

            }
        })
    }

    fun loginRX(mail:String, pass:String): Single<Response<UserData>> {
        return apiService.loginRX(mail,pass)
    }

    fun getListData():Single<Response<NewsObjectData>>{
        return AppClientManager.listApiService.getListData()
    }

    fun updatePhone(token:String, id: String, body: RequestBody): Single<Response<UpdateData>>{
        return AppClientManager.apiService.updateUser(token,id,body)
    }
}