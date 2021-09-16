package app.charlieueng.homework.model
import com.google.gson.annotations.SerializedName

class NewsData {
    @SerializedName("chtmessage") var chtmessage:String=""
    @SerializedName("engmessage") var engmessage:String=""
    @SerializedName("starttime") var starttime:String=""
    @SerializedName("endtime") var endtime:String=""
    @SerializedName("updatetime") var updatetime:String=""
    @SerializedName("content") var content:String=""
    @SerializedName("url") var url:String=""
}