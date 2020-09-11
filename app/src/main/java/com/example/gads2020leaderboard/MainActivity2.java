package com.example.gads2020leaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.gads2020leaderboard.services.MessageService;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {
    private LeadersAdapter adapter;
    private SkillsAdapter adapter1;
    private RecyclerView recyclerview,recyclerview1;
    private Button submit;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);






        progressDialog= new ProgressDialog(MainActivity2.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        MessageService messageService= RetroClass.getRetrofitInstance().create(MessageService.class);
        Call<List<GadsRetrofitSkills>> call1= messageService.getALLSkills();
        call1.enqueue(new Callback<List<GadsRetrofitSkills>>() {
            @Override
            public void onResponse(Call<List<GadsRetrofitSkills>> call, Response<List<GadsRetrofitSkills>> response) {
                progressDialog.dismiss();
                generateSkillList(response.body());
            }

            @Override
            public void onFailure(Call<List<GadsRetrofitSkills>> call, Throwable t) {

            }
        });
        Call<List<GadsRetrofitLeaders>> call= messageService.getAllLeaders();
        call.enqueue(new Callback<List<GadsRetrofitLeaders>>() {
            @Override
            public void onResponse(Call<List<GadsRetrofitLeaders>> call, Response<List<GadsRetrofitLeaders>> response) {
                progressDialog.dismiss();
                generateLeaderList(response.body());
            }

            @Override
            public void onFailure(Call<List<GadsRetrofitLeaders>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity2.this, "Check your Internet Connection",Toast.LENGTH_LONG).show();

            }
        });



        submit=findViewById(R.id.submit_txt);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });




        TabLayout mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.addTab(mTabLayout.newTab().setText("Learning Leaders "));
        mTabLayout.addTab(mTabLayout.newTab().setText("Skill IQ Leaders "));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = findViewById(R.id.pager);
        final ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
        TabPageAdapter sectionsPagerAdapter=new TabPageAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(sectionsPagerAdapter);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


    private void generateLeaderList(List<GadsRetrofitLeaders> leadersList) {
        recyclerview=findViewById(R.id.recycler);
        adapter=new LeadersAdapter(this,leadersList);
        recyclerview.setAdapter(adapter);
        recyclerview.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(linearLayoutManager);

    }
    private void generateSkillList(List<GadsRetrofitSkills> skillLists){
        recyclerview1 = findViewById(R.id.reclerskill);
        adapter1 = new SkillsAdapter(this, skillLists);
        recyclerview1.setAdapter(adapter1);
        recyclerview1.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager1= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerview1.setLayoutManager(linearLayoutManager1);


    }


}
