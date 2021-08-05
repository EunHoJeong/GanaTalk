package com.polared.ganatalk.main.friend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.polared.ganatalk.R;
import com.polared.ganatalk.base.BaseActivity;
import com.polared.ganatalk.base.BaseFragment;
import com.polared.ganatalk.base.Observer;

import java.util.ArrayList;

public class FriendsFragment extends BaseFragment {
    private TextView toolbarTitle;

    private ImageView profileIcon;
    private TextView myNicName;
    private RecyclerView friendRecyclerView;
    private FriendListAdapter mAdapter;

    private ArrayList<FriendResponseDTO> friendList;



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

        setViewModel();

        initRecyclerView();



        return view;
    }

    private void setViewModel() {


        Observer<FriendResponseDTO> observer = new Observer<FriendResponseDTO>(){
            @Override
            public void onChanged(FriendResponseDTO friendResponseDTO) {
                friendList.add(friendResponseDTO);
            }
        };
        ((BaseActivity)getActivity()).baseViewModel.getCurrentName().observeForever(observer);
    }

    private void initRecyclerView() {
        mAdapter = new FriendListAdapter();
        friendList = new ArrayList<>();
        friendRecyclerView.setAdapter(mAdapter);
    }

    private void widgetFindId(View view) {
        toolbarTitle = (TextView) view.findViewById(R.id.toolbar_title);

        profileIcon = (ImageView) view.findViewById(R.id.profile_icon);
        myNicName = (TextView) view.findViewById(R.id.my_nicName);
        friendRecyclerView = (RecyclerView) view.findViewById(R.id.friend_list);
    }

    private void initToolbar() {
        toolbarTitle.setText("친구");
    }
}
