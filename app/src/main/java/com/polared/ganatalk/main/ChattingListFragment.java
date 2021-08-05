package com.polared.ganatalk.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.polared.ganatalk.R;
import com.polared.ganatalk.base.BaseFragment;

public class ChattingListFragment extends BaseFragment {
    private TextView toolbarTitle;

    public static Fragment newInstance() {
        ChattingListFragment fragment = new ChattingListFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chatting_list, container, false);

        widgetFindId(view);

        initToolbar();

        return view;
    }

    private void widgetFindId(View view) {
        toolbarTitle = view.findViewById(R.id.toolbar_title);
    }

    private void initToolbar() {
        toolbarTitle.setText("채팅");
    }
}
