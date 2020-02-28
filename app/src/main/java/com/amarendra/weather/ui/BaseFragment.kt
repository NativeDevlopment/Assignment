package com.amarendra.todos.ui.main

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider



abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    abstract fun provideViewModelClass(): Class<VM>
    abstract fun layoutId(): Int
    abstract val bindingVariable: Int

    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewBinding: VB
    protected lateinit var viewModel: VM
    private lateinit var progressAlertDialog: AlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[provideViewModelClass()]
        handleObserver()
        onInitLabels()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(layoutId(), container, false)
        viewBinding = DataBindingUtil.bind(view)!!
        viewBinding.lifecycleOwner = this
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.setVariable(bindingVariable, viewModel)
        viewBinding.executePendingBindings()
    }

    /**
     * Method call to initialize the remote config in View Model
     */
    open fun onInitLabels() {
        viewModel.initConfig()
    }

    private fun handleObserver() {
      /*  observe(viewModel.mErrorLiveData, ::observeError)
        observe(viewModel.mLoadingLiveData, ::observeLoading)
        navigationContract?.subscribeNavigationEvent()
        navigationContract?.subscribeNetworkResponse()*/
    }

/*
    internal fun observeError(error: SingleEvent<Entity.ErrorEntity>) {
        // handle error here
        error.getContentIfNotHandled()?.let {
            it.errors?.let {
                context?.let { it1 ->
                    it[0].errorMessage.toast(it1)

                }

            }
        }
    }
*/

    /**
     * Method to observer loading
     */
    internal fun observeLoading(loadingInProgress: Boolean) {
        if (loadingInProgress) {
            //showLoading()
        } else {
            hideLoading()
        }
    }

 /*   protected fun showLoading() {
        hideLoading()
        val dialogBuilder = AlertDialog.Builder(context)
        val inflater = context?.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater?
        val dialogView = inflater?.inflate(R.layout.dialog_progress, null)
        dialogBuilder.setView(dialogView)
        dialogBuilder.setCancelable(false)
        progressAlertDialog = dialogBuilder.create()
        progressAlertDialog.show()
        progressAlertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

    }*/

    protected fun hideLoading() {
        if (::progressAlertDialog.isInitialized)
            progressAlertDialog.dismiss()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}