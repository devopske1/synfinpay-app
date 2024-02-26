package com.example.synfinpay.utils

import android.app.Activity
import android.util.Log
import com.example.synfinpay.databinding.AppToolBarLayoutBinding
import com.example.synfinpay.databinding.ToolbarLayoutBinding

fun setToolbarTitle(
    toolBarBinding: AppToolBarLayoutBinding,
    activity: Activity,
    title: String,
    action: (() -> Unit)? = null
) {
    toolBarBinding.tvTitle.text = title
    toolBarBinding.ivBack.setOnClickListener {
        Log.e("BACK", "")
        // activity.onBackPressed()
        if (action == null) {
            activity.onBackPressed()
        } else {
            action.invoke()

        }
    }
}



fun setToolbarTitleTransparent(
    toolBarBinding: ToolbarLayoutBinding,
    activity: Activity,
    title: String,
    action: (() -> Unit)? = null
) {
    toolBarBinding.tvTitle.text = title
    toolBarBinding.ivBack.setOnClickListener {
        Log.e("BACK", "")
        // activity.onBackPressed()
        if (action == null) {
            activity.onBackPressed()
        } else {
            action.invoke()

        }
    }
}