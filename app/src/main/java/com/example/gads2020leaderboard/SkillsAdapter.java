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

public class SkillsAdapter extends RecyclerView.Adapter<SkillsAdapter.skillViewHolder> {
    private Context context;

    public SkillsAdapter(Context context, List<GadsRetrofitSkills> skillLists) {
        this.context = context;
        mSkillLists = skillLists;
    }

    private List<GadsRetrofitSkills> mSkillLists;

    @NonNull
    @Override
    public skillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.skill_list_item, parent, false);
        return new skillViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull skillViewHolder holder, int position) {
        holder.textName.setText(mSkillLists.get(position).getName());
        holder.textDetails.setText(mSkillLists.get(position).getScore() + " " + "skill IQ Score," + " " + mSkillLists.get(position)
                .getCountry());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(mSkillLists.get(position).getBatchUrl())
                .placeholder((R.drawable.skillbadge))
                .into(holder.coverImage);

    }

    @Override
    public int getItemCount() {
        return mSkillLists.size();
    }

    public class skillViewHolder extends RecyclerView.ViewHolder {
        TextView textName;
        TextView textDetails;
        ImageView coverImage;


        public skillViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.ls_Names);
            textDetails = itemView.findViewById(R.id.ls_details);
            coverImage = itemView.findViewById(R.id.image2);

        }
    }
}
