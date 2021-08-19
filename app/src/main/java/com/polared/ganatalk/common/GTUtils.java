package com.polared.ganatalk.common;

import com.google.gson.Gson;

public class GTUtils {
    public static String convertObjToJSon(Object obj) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(obj);
            return json;
        } catch (Exception e) {
            return "";
        }
    }

    public static String getEmail(String email) {
        return email.replace(".", "");
    }
}
