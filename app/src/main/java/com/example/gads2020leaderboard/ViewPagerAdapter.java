package com.example.gads2020leaderboard;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    int mnumOfTabs;

    public ViewPagerAdapter(@NonNull FragmentManager fragment, int NumOfTabs) {
        super(fragment);
        this.mnumOfTabs = NumOfTabs;
    }




    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                LearningLeaders learning_leaders=new LearningLeaders();
                return learning_leaders;

            case 1:
                SkillsIQLeaders skills_iq_leaders= new SkillsIQLeaders();
                return skills_iq_leaders;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mnumOfTabs;
    }
}
