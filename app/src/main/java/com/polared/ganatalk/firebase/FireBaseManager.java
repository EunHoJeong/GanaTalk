package com.polared.ganatalk.firebase;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.polared.ganatalk.base.BaseActivity;
import com.polared.ganatalk.common.ActivityOpener;
import com.polared.ganatalk.common.DialogPopup;

public class FireBaseManager {
    private static FireBaseManager fireBaseManager;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;

    public static FireBaseManager getInstance() {
        if (fireBaseManager == null) {
            fireBaseManager = new FireBaseManager();
            return fireBaseManager;
        }
        return null;
    }

    public FireBaseManager(){
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
    }

    public FirebaseAuth getAuth() {
        return mAuth;
    }

    /**
     * 로그인
     * @param activity
     * @param email
     * @param pw
     */
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

    /**
     * 비밀번호 찾기
     * @param activity
     * @param email
     */
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


    /**
     * 회원가입
     * @param activity
     * @param email
     * @param pw
     */
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

    public void getFriends(Activity activity, String email) {
        DatabaseReference myRef = database.getReference("Users")
                .child(email).child("friends");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void getFriendInformation(Activity activity, String email) {

    }




}
