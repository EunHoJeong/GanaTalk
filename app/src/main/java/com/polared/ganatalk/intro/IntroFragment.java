package com.polared.ganatalk.intro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseUser;
import com.polared.ganatalk.R;
import com.polared.ganatalk.auth.SignInActivity;
import com.polared.ganatalk.base.BaseFragment;
import com.polared.ganatalk.common.ActivityOpener;
import com.polared.ganatalk.firebase.FireBaseManager;
import com.polared.ganatalk.main.MainActivity;

public class IntroFragment extends BaseFragment {
    public static Fragment newInstance(){
        IntroFragment introFragment = new IntroFragment();
        return introFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intro, container, false);

        FirebaseUser user = FireBaseManager.getInstance().getAuth().getCurrentUser();
        if (user == null) {
            ActivityOpener.openActivity(getContext(), SignInActivity.class, null);
        } else {
            ActivityOpener.openActivity(getContext(), MainActivity.class, null);
        }

        getActivity().finish();

        return view;
    }


}
