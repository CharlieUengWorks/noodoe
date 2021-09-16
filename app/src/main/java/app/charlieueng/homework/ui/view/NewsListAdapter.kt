package app.charlieueng.homework.ui.view

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

import app.charlieueng.homework.databinding.NewsListItemBinding
import app.charlieueng.homework.model.NewsData

class NewsListAdapter( private var dataList: ArrayList<NewsData>) : RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            NewsListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

    inner class ViewHolder(binding: NewsListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val textchtmessage: TextView = binding.textchtmessage
        private val textcontent: TextView = binding.textcontent
        private val texturl: TextView = binding.texturl
        private val textendtime: TextView = binding.textendtime
        private val textengmessage: TextView = binding.textengmessage
        private val textstarttime: TextView = binding.textstarttime
        private val textupdatetime: TextView = binding.textupdatetime

        fun bind(item : NewsData){
            textchtmessage.text = "chtmessage="+item.chtmessage
            textcontent.text = "content="+item.content
            texturl.text  = "url="+item.url
            textengmessage.text  = "engmessage="+item.engmessage
            textstarttime.text  = "start time="+item.starttime
            textupdatetime.text  = "update time="+item.updatetime
            textendtime.text  = "end time="+item.endtime
        }

        override fun toString(): String {
            return super.toString() + " '" + textcontent.text + "'"
        }
    }

    fun updateList(list:ArrayList<NewsData>){
        dataList = list
    }
}