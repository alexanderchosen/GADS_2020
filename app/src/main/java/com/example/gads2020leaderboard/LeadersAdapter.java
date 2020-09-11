package com.example.gads2020leaderboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LeadersAdapter extends RecyclerView.Adapter<LeadersAdapter.leadersViewHolder> {
        private List<GadsRetrofitLeaders> mLeadersList;
        private Context context;
        public LeadersAdapter(Context context, List<GadsRetrofitLeaders> mleadersList) {
            this.context = context;
            mLeadersList = mleadersList;

        }
        @NonNull
        @Override
        public leadersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater= LayoutInflater.from(context);
            View view = layoutInflater.inflate(R.layout.leaderslistitem,parent, false);
            return new leadersViewHolder(view);
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(@NonNull leadersViewHolder holder, int position) {

            holder.textName.setText(mLeadersList.get(position).getName());
            holder.textDetails.setText(mLeadersList.get(position).getHours() +" "+ "learning hours"+ " "+ mLeadersList.get(position)
                    .getCountry() );

            Picasso.Builder builder= new Picasso.Builder(context);
            builder.downloader(new OkHttp3Downloader(context));
            builder.build().load(mLeadersList.get(position).getBatchUrl())
                    .placeholder((R.drawable.toplearner))
                    .into(holder.coverImage);
        }

        @Override
        public int getItemCount() {
            return mLeadersList.size();
        }

        public static class  leadersViewHolder extends RecyclerView.ViewHolder{



            TextView textName;
            TextView textDetails;
            ImageView coverImage;

            public leadersViewHolder(@NonNull View itemView) {
                super(itemView);
                textName=itemView.findViewById(R.id.ld_Names);
                textDetails=itemView.findViewById(R.id.ld_details);
                coverImage=itemView.findViewById(R.id.images1);

            }
        }

    }
