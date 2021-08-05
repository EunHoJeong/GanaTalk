package com.polared.ganatalk.auth.find;

import android.os.Bundle;

import com.polared.ganatalk.R;
import com.polared.ganatalk.base.BaseActivity;

public class FindPwActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        replaceFragment(FindPwFragment.newInstance());
    }
}
