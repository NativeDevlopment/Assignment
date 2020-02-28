package com.amarendra.todos.ui.main

import android.os.Bundle
import com.amarendra.weather.R
import com.amarendra.weather.databinding.TodosFragmentBinding
import com.amarendra.weather.BR
import com.amarendra.weather.ui.WeatherViewModel

class WeatherFragment : BaseFragment<TodosFragmentBinding,WeatherViewModel>() {

    companion object {
        fun newInstance() = WeatherFragment()
    }

    override fun layoutId(): Int = R.layout.todos_fragment
    override fun provideViewModelClass(): Class<WeatherViewModel> =WeatherViewModel::class.java

    override val bindingVariable: Int
        get() = BR.viewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
        viewModel.zipcode= arguments?.getString("zipcode")!!;
        viewModel.addreessName.postValue( arguments?.getString("name")!!);

        viewModel.getData()



    }

}
