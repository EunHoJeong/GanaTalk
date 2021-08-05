package com.polared.ganatalk.common;

import android.content.Context;
import android.content.Intent;

import com.polared.ganatalk.main.MainActivity;

public class ActivityOpener {

    public static void openActivity(Context context, Class activity, int[] flags) {
        Intent intent = new Intent(context, activity);
        if (flags != null) {
            for (int flag : flags) {
                intent.addFlags(flag);
            }
        }
        context.startActivity(intent);
    }


}
