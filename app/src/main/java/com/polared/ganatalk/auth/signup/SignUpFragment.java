package com.polared.ganatalk.auth.signup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.polared.ganatalk.R;
import com.polared.ganatalk.base.BaseFragment;
import com.polared.ganatalk.common.DialogPopup;
import com.polared.ganatalk.firebase.FireBaseManager;

public class SignUpFragment extends BaseFragment {
    private TextView toolbarTitle;
    private EditText email;
    private EditText pw;
    private Button signUp;
    private TextView emailErrorMessage;
    private TextView pwErrorMessage;

    public static Fragment newInstance() {
        SignUpFragment signUpFragment = new SignUpFragment();
        return signUpFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        widgetFindId(view);

        initToolbar();

        initClickEvent();

        return view;
    }

    private void initToolbar() {
        toolbarTitle.setText("회원가입");


    }

    private void initClickEvent() {
        signUp.setOnClickListener(v -> {
            String email = this.email.getText().toString();
            String pw = this.pw.getText().toString();

            if (checkToError()) {
                FireBaseManager.getInstance().signUp(getActivity(), email, pw);
            }

        });
    }

    private boolean checkToError(){
        if (emailErrorMessage.getVisibility() == View.VISIBLE) {
            Toast.makeText(getContext(), "이메일 확인", Toast.LENGTH_SHORT).show();
            return false;
        } else if (pwErrorMessage.getVisibility() == View.VISIBLE) {
            Toast.makeText(getContext(), "비밀번호 확인", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void widgetFindId(View view) {
        toolbarTitle = view.findViewById(R.id.toolbar_title);

        email = view.findViewById(R.id.signup_email);
        pw = view.findViewById(R.id.signup_pw);
        signUp = view.findViewById(R.id.signup);
        emailErrorMessage = view.findViewById(R.id.signup_email_error);
        pwErrorMessage = view.findViewById(R.id.signup_pw_error);

    }
}
