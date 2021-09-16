package app.charlieueng.homework.ui.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import app.charlieueng.homework.R
import app.charlieueng.homework.databinding.TimezoneFragmentBinding
import app.charlieueng.homework.viewmodel.MainViewModel
import app.charlieueng.homework.viewmodel.TimeZoneViewModel
import okhttp3.MediaType
import org.json.JSONObject
import okhttp3.RequestBody

class TimeZoneFragment : Fragment() {
    private lateinit var viewModel: TimeZoneViewModel
    private lateinit var binding: TimezoneFragmentBinding
    private lateinit var mainViewModel: MainViewModel

    companion object {
        fun newInstance() = TimeZoneFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(TimeZoneViewModel::class.java)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.timezone_fragment,
            container,
            false
        )

        binding.timezoneTextView.text = "Email:"+mainViewModel.userData.value?.username.orEmpty()

        mainViewModel.userData.observe(viewLifecycleOwner,{
            binding.timezoneTextView.text = "Email:"+mainViewModel.userData.value?.username.orEmpty()
        })

        binding.timezoneToolbar.setNavigationOnClickListener{
            mainViewModel.appState.value=MainViewModel.AppState.News
        }

        binding.button.setOnClickListener{
            var token = mainViewModel.userData.value?.sessionToken
            var id = mainViewModel.userData.value?.objectId
            var phone = binding.editTextPhone.text.toString()
            val jsonObject = JSONObject()
            jsonObject.put("phone", phone)
            val requestBody = RequestBody.create(MediaType.get("application/json; charset=utf-8"),jsonObject.toString())
            viewModel.viewUpdatePhone(token!!,id!!,requestBody)
        }

        return binding.root
    }

    fun setMainViewModel(mvm:MainViewModel){
        mainViewModel=mvm
    }
}