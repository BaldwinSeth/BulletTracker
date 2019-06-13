package com.tests.baldwin.bullet_tracker.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tests.baldwin.bullet_tracker.R;
import com.tests.baldwin.bullet_tracker.room_entities.Bullet;

import java.util.List;

public class BulletAdapter extends RecyclerView.Adapter<BulletAdapter.ViewHolder> {

    List<Bullet> bullets;
    public BulletAdapter(List<Bullet> bullets){
        this.bullets = bullets;
    }

    @NonNull
    @Override
    public BulletAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bullet_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BulletAdapter.ViewHolder viewHolder, int i){
        Bullet bullet = bullets.get(i);
        viewHolder.Date.setText(bullet.getDate().toString());
        viewHolder.Category.setText(bullet.getCategory().toString());
        viewHolder.Description.setText(bullet.getDescription());
    }

    @Override
    public int getItemCount() {return bullets.size();}

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Date;
        public TextView Category;
        public TextView Description;
        public TextView Tags;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Date = itemView.findViewById(R.id.Date);
            Category = itemView.findViewById(R.id.Category);
            Description = itemView.findViewById(R.id.Description);
            Tags = itemView.findViewById(R.id.Tags);
        }
    }
}
