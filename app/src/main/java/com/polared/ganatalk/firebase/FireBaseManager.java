package com.polared.ganatalk.firebase;

import android.app.Activity;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.polared.ganatalk.base.BaseActivity;
import com.polared.ganatalk.common.ActivityOpener;
import com.polared.ganatalk.common.DialogPopup;

public class FireBaseManager {
    private static FireBaseManager fireBaseManager;
    private FirebaseAuth mAuth;

    public static FireBaseManager getInstance() {
        if (fireBaseManager == null) {
            return new FireBaseManager();
        }
        return null;
    }

    public FireBaseManager(){
        mAuth = FirebaseAuth.getInstance();
    }

    public FirebaseAuth getmAuth() {
        return mAuth;
    }

    public void signIn(Activity activity, String email, String pw) {
        mAuth.signInWithEmailAndPassword(email, pw)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            DialogPopup.showOneButtonDialog((FragmentActivity) activity, "아이디와 비밀번호를 확인해주세요.", "확인", null);
                            return;
                        }

                        if (mAuth.getCurrentUser().isEmailVerified()) {
                            ((BaseActivity)activity).baseViewModel.postValue(true);
                        } else {
                            DialogPopup.showOneButtonDialog((FragmentActivity) activity, "이메일 인증을 해주세요.", "확인", null);
                        }

                    }
                });
    }

    public void findPassword(Activity activity, String email) {
        mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(activity, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(Task<Void> task) {
                        if (!task.isSuccessful()) {
                            DialogPopup.showOneButtonDialog((FragmentActivity) activity, "이메일을 확인해주세요.", "확인", null);
                            return;
                        }

                        DialogPopup.showOneButtonDialog((FragmentActivity) activity, "이메일을 보냈습니다 비밀번호를 재설정해주세요.", "확인", null);
                        activity.finish();
                    }
                });
    }

    public void signUp(FragmentActivity activity, String email, String pw) {
        mAuth.createUserWithEmailAndPassword(email, pw)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(activity, "회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show();
                            return ;
                        }

                        mAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(Task<Void> task) {
                                DialogPopup.showOneButtonDialog(activity, "이메일인증 메일을 보냈습니다.\n이메일 인증을 하지 않으면 로그인 할 수 없습니다.", "확인"
                                        , new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                activity.finish();
                                            }
                                        });
                            }
                        });

                    }
                });
    }
}
