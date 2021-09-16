package app.charlieueng.homework.ui.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import app.charlieueng.homework.R
import app.charlieueng.homework.databinding.LoginFragmentBinding
import app.charlieueng.homework.viewmodel.MainViewModel
import io.reactivex.android.schedulers.AndroidSchedulers

import io.reactivex.schedulers.Schedulers.io

class LoginFragment(private val viewModel:MainViewModel) : Fragment() {

    companion object {
        fun newInstance(model:MainViewModel) = LoginFragment(model)
    }

    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.login_fragment,
            container,
            false
        )

        binding.button2.setOnClickListener{
            checkFormatRX(
                binding.editTextTextEmailAddress.text.toString(),
                binding.editTextTextPassword.text.toString())
        }

        return binding.root
    }

    private fun checkFormatRX(mail: String, pass: String){

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
            Toast.makeText(context,"FORMAT ERROR",Toast.LENGTH_SHORT).show()
        }

        viewModel
            .loginRX(mail,pass)
            .subscribeOn(io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { r ->
                if(r.code() == 200) {
                    viewModel.appState.value = MainViewModel.AppState.News
                    viewModel.userData.value = r.body()!!
                }else{
                    Toast.makeText(context,"LOGIN FAILED",Toast.LENGTH_SHORT).show()
                }

            }
        //.subscribeOn(Schedulers.io())

    }
}

