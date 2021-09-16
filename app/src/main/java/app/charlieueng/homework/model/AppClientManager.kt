package app.charlieueng.homework.model

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class AppClientManager private constructor() {
    private val retrofit = buildRetrofit("https://watch-master-staging.herokuapp.com/api/")
    private val _apiService : ApiService =retrofit.create(ApiService::class.java)

    private val retrofitL = buildRetrofit("https://tcgbusfs.blob.core.windows.net/dotapp/")
    private val _listService : ListApiService = retrofitL.create(ListApiService::class.java)

    init {

    }

    private fun buildRetrofit(url :String):Retrofit{
        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    companion object {
        private val instance :AppClientManager
            get() = AppClientManager()
        val client: Retrofit
            get() = instance.retrofit
        val apiService : ApiService
            get() = instance._apiService
        val listApiService = instance._listService
    }
}