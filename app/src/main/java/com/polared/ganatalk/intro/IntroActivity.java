package com.polared.ganatalk.intro;


import android.os.Bundle;

import com.polared.ganatalk.R;
import com.polared.ganatalk.base.BaseActivity;

public class IntroActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        replaceFragment(IntroFragment.newInstance());

    }

}