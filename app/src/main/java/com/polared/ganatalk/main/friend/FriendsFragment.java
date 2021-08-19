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

import com.bumptech.glide.Glide;
import com.polared.ganatalk.R;
import com.polared.ganatalk.base.BaseActivity;
import com.polared.ganatalk.base.BaseFragment;
import com.polared.ganatalk.base.Observer;
import com.polared.ganatalk.firebase.FireBaseManager;

import java.util.ArrayList;

public class FriendsFragment extends BaseFragment {
    private TextView toolbarTitle;

    private ImageView profileIcon;
    private TextView myNicName;
    private TextView myStatus;
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

        initMyInfo();

        initRecyclerView();



        return view;
    }

    private void initMyInfo() {
        FireBaseManager.getInstance().getMyInfo(getActivity());
    }

    private void setViewModel() {


        Observer<FriendResponseDTO> observer = new Observer<FriendResponseDTO>(){
            @Override
            public void onChanged(FriendResponseDTO friendResponseDTO) {
                myNicName.setText(friendResponseDTO.getNicName());

                if (!friendResponseDTO.getProfileStatus().equals("")) {
                    myStatus.setVisibility(View.VISIBLE);
                    myStatus.setText(friendResponseDTO.getProfileStatus());
                }

                if (!friendResponseDTO.getProfileImage().equals("")) {
                    Glide.with(getContext())
                            .load(friendResponseDTO.getProfileImage())
                            .into(profileIcon);
                }

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
        myStatus = (TextView) view.findViewById(R.id.my_status);
        friendRecyclerView = (RecyclerView) view.findViewById(R.id.friend_list);
    }

    private void initToolbar() {
        toolbarTitle.setText("친구");
    }
}
