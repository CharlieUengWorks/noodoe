package app.charlieueng.homework.model

import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import java.util.*

interface ApiService {
    @Headers(
        "X-Parse-Application-Id: vqYuKPOkLQLYHhk4QTGsGKFwATT4mBIGREI2m8eD"
    )
    @GET("login")
    fun login(@Query("username", encoded = true) username:String, @Query("password", encoded = true) pass:String): Call<UserData>
    /**
     *
    curl -X GET \
    -H "X-Parse-Application-Id: ${APPLICATION_ID}" \
    -H "X-Parse-REST-API-Key: ${REST_API_KEY}" \
    -H "X-Parse-Revocable-Session: 1" \
    -G \
    --data-urlencode 'username=cooldude6' \
    --data-urlencode 'password=p_n7!-e8' \
    https://YOUR.PARSE-SERVER.HERE/parse/login
     */
    @Headers(
        "X-Parse-Application-Id: vqYuKPOkLQLYHhk4QTGsGKFwATT4mBIGREI2m8eD"
    )
    @GET("login")
    fun loginRX(
        @Query("username", encoded = true) username:String,
        @Query("password", encoded = true) pass:String)
    : Single<Response<UserData>>

    /**
     *
    curl -X PUT \
    -H "X-Parse-Application-Id: ${APPLICATION_ID}" \
    -H "X-Parse-REST-API-Key: ${REST_API_KEY}" \
    -H "X-Parse-Session-Token: r:pnktnjyb996sj4p156gjtp4im" \
    -H "Content-Type: application/json" \
    -d '{"phone":"415-369-6201"}' \
    https://YOUR.PARSE-SERVER.HERE/parse/users/g7y9tkhB7O
    */
    @Headers(
        "Content-Type: application/json",
        "X-Parse-Application-Id: vqYuKPOkLQLYHhk4QTGsGKFwATT4mBIGREI2m8eD"/*,
        "X-Parse-Session-Token: {token}"*/
    )
    @PUT("users/{id}")
    fun updateUser(
        @Header("X-Parse-Session-Token") token :String,
        @Path ("id") objectID:String,
        @Body requestBody: RequestBody
    )
    : Single<Response<UpdateData>>
}