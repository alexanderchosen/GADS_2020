package com.example.gads2020leaderboard;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabPageAdapter extends FragmentPagerAdapter {

        private android.content.Context Context;
        private String[] tabTitles = {"Learning Leaders ", "SKILL IQ Leaders"};

        public TabPageAdapter(@NonNull FragmentManager fm, Context context) {
            super(fm);
            this.Context = context;
        }


        @NonNull
        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    LearningLeaders fragment1 = new LearningLeaders();
                    return fragment1;
                case 1:
                    SkillsIQLeaders fragment2 = new SkillsIQLeaders();
                    return fragment2;
                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            return 2;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }

    }