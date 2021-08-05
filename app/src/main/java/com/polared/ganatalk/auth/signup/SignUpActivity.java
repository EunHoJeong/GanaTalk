package com.polared.ganatalk.auth.signup;

import android.os.Bundle;

import com.polared.ganatalk.R;
import com.polared.ganatalk.base.BaseActivity;

public class SignUpActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        replaceFragment(SignUpFragment.newInstance());
    }
}
