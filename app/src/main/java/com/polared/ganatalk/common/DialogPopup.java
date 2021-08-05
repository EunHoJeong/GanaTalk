package com.polared.ganatalk.common;

import android.view.View;

import androidx.fragment.app.FragmentActivity;

import com.polared.ganatalk.common.dialog.OneButtonDialog;

public class DialogPopup {
    public static void showOneButtonDialog(FragmentActivity activity, String contentText, String buttonText, View.OnClickListener buttonListener){
        OneButtonDialog oneButtonDialog = OneButtonDialog.newInstance(contentText, buttonText, buttonListener);
        oneButtonDialog.show(activity.getSupportFragmentManager(), "OneButtonDialog");
    }
}
