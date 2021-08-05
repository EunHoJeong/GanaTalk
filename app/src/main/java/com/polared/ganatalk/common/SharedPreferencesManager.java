package com.polared.ganatalk.common;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {
    public static final String USER_AUTO_LOGIN = "user_auto_login";

    public static void setAutoLogin(Context context, boolean isAutoLogin){
        SharedPreferences sharedPref = context.getSharedPreferences(USER_AUTO_LOGIN, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean(USER_AUTO_LOGIN, isAutoLogin);
        editor.commit();
    }

    public static boolean isAutoLogin(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences(USER_AUTO_LOGIN, Context.MODE_PRIVATE);
        return sharedPref.getBoolean(USER_AUTO_LOGIN, false);
    }
}
