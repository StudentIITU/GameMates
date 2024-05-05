package com.damir.gamemates.fragments

import android.app.Activity
import androidx.appcompat.app.AlertDialog
import com.damir.gamemates.R

internal class LoadingDialog(private val activity: Activity) {
    private var alertDialog: AlertDialog? = null

    fun StartingLoadingAnimation() {
        val builder = AlertDialog.Builder(activity)

        val inflater = activity.layoutInflater
        builder.setView(R.layout.custom_dialog)
        builder.setCancelable(false)

        alertDialog = builder.create()
        alertDialog!!.show()
    }

    fun DismissLoadingAnimation() {
        alertDialog!!.dismiss()
    }
}
