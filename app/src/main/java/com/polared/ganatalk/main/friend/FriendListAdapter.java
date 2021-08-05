package com.polared.ganatalk.main.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.polared.ganatalk.R;

import java.util.ArrayList;

public class FriendListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<FriendResponseDTO> friendList;


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_friend_list, parent, false);

        return new Friend(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof Friend) {
            Friend friend = (Friend)holder;

        }
    }

    @Override
    public int getItemCount() {
        return friendList.size();
    }

    public class Friend extends RecyclerView.ViewHolder{
        private ImageView profile_icon;
        private TextView friend_nicName;

        public Friend(View itemView) {
            super(itemView);

        }
    }
}
