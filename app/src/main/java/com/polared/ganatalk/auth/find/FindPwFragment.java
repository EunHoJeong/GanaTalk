package com.polared.ganatalk.auth.find;

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

import com.polared.ganatalk.R;
import com.polared.ganatalk.base.BaseFragment;
import com.polared.ganatalk.firebase.FireBaseManager;

public class FindPwFragment extends BaseFragment {
    private TextView toolbarTitle;
    private EditText email;
    private Button sendEmail;

    public static Fragment newInstance() {
        FindPwFragment findPwFragment = new FindPwFragment();
        return findPwFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find_password, container, false);

        widgetFindId(view);

        initToolbar();

        initWidget();

        return view;
    }

    private void initToolbar() {
        toolbarTitle.setText("회원가입");


    }

    private void initWidget() {
        sendEmail.setOnClickListener(v -> {
            String email = this.email.getText().toString();

            FireBaseManager.getInstance().findPassword(getActivity(), email);
        });
    }

    private void widgetFindId(View view) {
        toolbarTitle = view.findViewById(R.id.toolbar_title);

        email = view.findViewById(R.id.find_pw_email);
        sendEmail = view.findViewById(R.id.find_pw_sendEmail);
    }
}
