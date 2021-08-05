package com.polared.ganatalk.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.polared.ganatalk.R;
import com.polared.ganatalk.base.BaseFragment;

public class FriendsFragment extends BaseFragment {
    private TextView toolbarTitle;


    public static Fragment newInstance() {
        FriendsFragment mainFragment = new FriendsFragment();
        return mainFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends, container, false);

        widgetFindId(view);

        initToolbar();

        return view;
    }

    private void widgetFindId(View view) {
        toolbarTitle = view.findViewById(R.id.toolbar_title);
    }

    private void initToolbar() {
        toolbarTitle.setText("친구");
    }
}
