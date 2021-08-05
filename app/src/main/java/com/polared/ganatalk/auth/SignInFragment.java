package com.polared.ganatalk.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.polared.ganatalk.R;
import com.polared.ganatalk.auth.find.FindPwActivity;
import com.polared.ganatalk.auth.signup.SignUpActivity;
import com.polared.ganatalk.base.BaseActivity;
import com.polared.ganatalk.base.BaseFragment;
import com.polared.ganatalk.common.ActivityOpener;
import com.polared.ganatalk.firebase.FireBaseManager;
import com.polared.ganatalk.main.MainActivity;

public class SignInFragment extends BaseFragment {
    private TextView toolbarTitle;
    private EditText email;
    private EditText pw;
    private Button signIn;
    private TextView findPw;
    private TextView signUp;



    public static Fragment newInstance() {
        SignInFragment signInFragment = new SignInFragment();
        return signInFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signin, container, false);

        widgetFindId(view);

        initToolbar();

        initClickEvent();

        initLiveData();

        return view;
    }

    private void initLiveData() {
        Observer<Boolean> observer = new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    ActivityOpener.openActivity(getContext(), MainActivity.class, null);
                    getActivity().finish();
                }
            }
        };



        ((BaseActivity)getActivity()).baseViewModel.getCurrentName().observe(getViewLifecycleOwner(), observer);
    }

    private void initClickEvent() {
        signIn.setOnClickListener(v -> {
            String email = this.email.getText().toString();
            String pw = this.pw.getText().toString();
            FireBaseManager.getInstance().signIn(getActivity(), email, pw);
        });

        findPw.setOnClickListener(v -> {
            ActivityOpener.openActivity(getContext(), FindPwActivity.class, null);
        });

        signUp.setOnClickListener(v -> {
            ActivityOpener.openActivity(getContext(), SignUpActivity.class, null);
        });
    }

    private void initToolbar() {
        toolbarTitle.setText("로그인");


    }

    private void widgetFindId(View view) {
        toolbarTitle = (TextView) view.findViewById(R.id.toolbar_title);


        email = (EditText) view.findViewById(R.id.signin_email);
        pw = (EditText) view.findViewById(R.id.signin_pw);

        signIn = (Button) view.findViewById(R.id.signin_button);

        findPw = (TextView) view.findViewById(R.id.signin_find_pw);
        signUp = (TextView) view.findViewById(R.id.signin_signup);
    }
}
