package app.charlieueng.homework.model

import com.google.gson.annotations.SerializedName

class NewsObjectData {
    @SerializedName("updateTime") val updateTime:String=""
    @SerializedName("News") val list:ArrayList<NewsData> = arrayListOf()
}