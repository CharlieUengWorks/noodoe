package app.charlieueng.homework.model
import com.google.gson.annotations.SerializedName

class UserData {
    @SerializedName("username") val username:String=""
    @SerializedName("phone") val phone:String=""
    @SerializedName("createdAt") val createdAt:String=""
    @SerializedName("updatedAt") val updatedAt:String=""
    @SerializedName("objectId") val objectId:String=""
    @SerializedName("sessionToken") val sessionToken:String=""
}
