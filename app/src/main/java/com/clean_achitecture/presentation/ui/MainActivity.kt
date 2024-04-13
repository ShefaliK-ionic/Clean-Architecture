package com.clean_achitecture.presentation.ui
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.clean_achitecture.R
import com.clean_achitecture.databinding.ActivityMainBinding
import com.clean_achitecture.domain.model.ImageModel
import com.clean_achitecture.presentation.viewmodel.ImageViewmodel
import com.clean_achitecture.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var activityMainBinding: ActivityMainBinding
    private val dashboardViewModel: ImageViewmodel by viewModels()

    var token="43273217-5998d18a51a9dfe7084ec890d"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        clickEvents()
        attachObserver()


    }

    private fun attachObserver() {
        lifecycleScope.launch {
            dashboardViewModel.dashboard.collect {
                when (it) {
                    is Resource.Loading -> {
                        Toast.makeText(this@MainActivity, "Loading", Toast.LENGTH_SHORT).show();
                    }
                    is Resource.Success -> {
                        Toast.makeText(this@MainActivity, "Success" + it.data, Toast.LENGTH_SHORT)
                            .show();
                    }
                    is Resource.error -> {
                        Toast.makeText(this@MainActivity, "Failed" + it.message, Toast.LENGTH_SHORT)
                            .show();
                    }
                }
            }
        }

    }

    private fun clickEvents() {
        activityMainBinding.btnLoadData.setOnClickListener{

            dashboardViewModel.fetchDashBoard("sun",token)
        }
    }
}