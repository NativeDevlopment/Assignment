package com.amarendra.weather.ui

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amarendra.todos.ui.main.BaseViewModel
import com.amarendra.weather.BR
import com.amarendra.weather.OnOptionClickListener
import com.amarendra.weather.R
import com.amarendra.weather.SingleLiveEvent
import com.amarendra.weather.network.Forecast
import com.amarendra.weather.network.PostOffice
import com.amarendra.weather.network.Zipcode
import me.tatarka.bindingcollectionadapter2.ItemBinding

class ZipcodeViewModel : BaseViewModel() {
    var postOfficeList: ObservableList<PostOffice> =
        ObservableArrayList<PostOffice>()
    val postOfficeClicked: SingleLiveEvent<PostOffice> = SingleLiveEvent()
    var myPostOfficeListBinding= ItemBinding.of<PostOffice>{ todoListBinding, _, _->
        todoListBinding.set(BR.item, R.layout.item_postofc_list).bindExtra(BR.listener, object :
            OnOptionClickListener<PostOffice> {
            override fun onOptionClick(option: PostOffice) {
                postOfficeClicked.postValue(option)
            }
        })

    }

    fun getZipCodeData() {
        postOfficeList.clear()
        postOfficeList.addAll(Zipcode.getZipCodeList())

    }
}
