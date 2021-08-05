package com.polared.ganatalk.main;


import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.polared.ganatalk.R;
import com.polared.ganatalk.base.BaseActivity;
import com.polared.ganatalk.base.BaseFragment;
import com.polared.ganatalk.main.friend.FriendsFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private long backKeyPressedTime = 0;
    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private FragmentStateAdapter vpAdapter;

    private ArrayList<BaseFragment> fragmentsList;
    private ArrayList<Integer> iconList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        widgetFindId();

        initList();

        init();

    }
    private void init(){
        vpAdapter = new FragmentStateAdapter(this){
            @Override
            public int getItemCount() {
                return fragmentsList.size();
            }

            @NonNull
            @Override
            public Fragment createFragment(int position){
                return fragmentsList.get(position);
            }
        };

        viewPager.setAdapter(vpAdapter);

        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(TabLayout.Tab tab, int position) {

                viewPager.setCurrentItem(position);
            }
        }).attach();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //NOTING
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //NOTING
            }
        });
        for (int i = 0; i < 2; i++) {
            tabLayout.getTabAt(i).setIcon(iconList.get(i));
        }
    }

    private void initList() {
        fragmentsList = new ArrayList<>();
        fragmentsList.add((BaseFragment) FriendsFragment.newInstance());
        fragmentsList.add((BaseFragment) ChattingListFragment.newInstance());

        iconList = new ArrayList<>();
        iconList.add(R.drawable.friend);
        iconList.add(R.drawable.chat);

    }

    private void widgetFindId() {
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + 2500) {
            backKeyPressedTime = System.currentTimeMillis();
            Toast.makeText(this, "뒤로 가기 버튼을 한 번 더 누르시면 종료됩니다.", Toast.LENGTH_LONG).show();
            return;
        } else {
            super.onBackPressed();
        }

    }

}