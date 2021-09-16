package app.charlieueng.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import app.charlieueng.homework.ui.view.LoginFragment
import app.charlieueng.homework.ui.view.NewsFragment
import app.charlieueng.homework.ui.view.TimeZoneFragment
import app.charlieueng.homework.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.supportActionBar?.hide();

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setContentView(R.layout.main_activity)

        viewModel.appState.observe(this,{
            if(it == MainViewModel.AppState.Login)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, LoginFragment.newInstance(viewModel))
                    .commitNow()
            else if(it == MainViewModel.AppState.News){
                var f = NewsFragment.newInstance()
                f.setMainViewModel(viewModel)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, f)
                    .commitNow()
            }else if(it == MainViewModel.AppState.Timezone){
                var f = TimeZoneFragment.newInstance()
                f.setMainViewModel(viewModel)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, f)
                    .commitNow()
            }
        })
    }
}