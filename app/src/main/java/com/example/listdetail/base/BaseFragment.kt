package com.example.listdetail.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import es.dmoral.toasty.Toasty

abstract class BaseFragment<VB : ViewBinding> : Fragment() {


    private var _binding: VB? = null
    abstract val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> VB

    protected val binding: VB
        get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = bindLayout.invoke(inflater, container, false)
        return requireNotNull(_binding).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareView(savedInstanceState)
    }

    abstract fun prepareView(savedInstanceState: Bundle?)

    protected fun showSuccessToast(msg: String) {
        Toasty.success(
            requireContext(),
            msg,
            Toast.LENGTH_SHORT
        ).show()
    }

    protected fun showInfoToast(msg: String) {
        Toasty.info(
            requireContext(),
            msg,
            Toast.LENGTH_SHORT
        ).show()
    }


    protected fun showErrorToast(msg: String) {
        Toasty.error(
            requireContext(),
            msg,
            Toast.LENGTH_SHORT
        ).show()
    }

    protected fun showLongToast(msg: String) {
        Toast.makeText(
            context,
            msg,
            Toast.LENGTH_LONG
        ).show()
    }

    protected fun showShortToast(msg: String) {
        Toast.makeText(
            context,
            msg,
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}