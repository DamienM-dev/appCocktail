package com.example.appcocktail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{

    public ItemAdapter(ArrayList<ItemCategory> viewPager2ArrayList) {
        this.viewPager2ArrayList = viewPager2ArrayList;
    }

    ArrayList<ItemCategory> viewPager2ArrayList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ItemCategory itemCategory = viewPager2ArrayList.get(position);

        holder.imageView.setImageResource(itemCategory.imageID);
        holder.titleView.setText(itemCategory.title);

    }

    @Override
    public int getItemCount() {
        return viewPager2ArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView titleView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_item);
            titleView = itemView.findViewById(R.id.title_item);
        }
    }
}
