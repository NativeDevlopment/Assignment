package com.amarendra.weather.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import com.amarendra.todos.ui.main.BaseFragment
import com.amarendra.todos.ui.main.WeatherFragment
import com.amarendra.weather.BR
import com.amarendra.weather.R
import com.amarendra.weather.databinding.ZipcodeFragmentBinding

class ZipcodeFragment : BaseFragment<ZipcodeFragmentBinding,ZipcodeViewModel>() {

    companion object {
        fun newInstance() = ZipcodeFragment()
    }

    override fun layoutId(): Int = R.layout.zipcode_fragment
    override fun provideViewModelClass(): Class<ZipcodeViewModel> = ZipcodeViewModel::class.java

    override val bindingVariable: Int
        get() = BR.viewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
        viewModel.getZipCodeData()


viewModel.postOfficeClicked.observe(viewLifecycleOwner, Observer {

    val todosFragment=WeatherFragment.newInstance()
     val b= Bundle()
    b.putString("zipcode",it.pincode)
    b.putString("name",it.name)
    todosFragment.arguments=b;
    activity?.supportFragmentManager?.beginTransaction()
        ?.add(R.id.container, todosFragment)?.addToBackStack(null)
        ?.commit()
})
    }


}
