package app.charlieueng.homework.model

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface ListApiService {
    @GET("news.json")
    fun getListData(): Single<Response<NewsObjectData>>
}