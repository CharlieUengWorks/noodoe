package app.charlieueng.homework.ui.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import app.charlieueng.homework.R
import app.charlieueng.homework.databinding.NewsFragmentBinding
import app.charlieueng.homework.viewmodel.ListViewModel
import app.charlieueng.homework.viewmodel.MainViewModel

class NewsFragment() : Fragment() {

    private lateinit var viewModel : ListViewModel
    private lateinit var binding: NewsFragmentBinding
    private lateinit var _mainViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)

        //viewModel.dataList.observe(this,{list->mAdapter.updateList(list)})
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val view = inflater.inflate(R.layout.news_fragment, container, false)
        binding = DataBindingUtil.inflate(inflater,R.layout.news_fragment,container,false)

        binding.list.layoutManager = LinearLayoutManager(context)
        //binding.list.adapter = mAdapter
        //Log.d("blah",mAdapter.itemCount.toString())

        viewModel.dataList.observe(viewLifecycleOwner,{list->binding.list.adapter = NewsListAdapter(list)})
        viewModel.viewGetListData()
        binding.NewToolbar.inflateMenu(R.menu.list_toolbar)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.NewToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_timezone -> {
                    _mainViewModel?.appState.value = MainViewModel.AppState.Timezone
                    true
                }
                else -> false
            }
        }
    }

    fun setMainViewModel(mvm:MainViewModel){
        _mainViewModel = mvm
    }

    companion object {
        @JvmStatic
        fun newInstance() = NewsFragment()
    }
}