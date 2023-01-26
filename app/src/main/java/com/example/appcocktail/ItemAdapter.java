package com.example.appcocktail;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
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

    private Context context;
    private Intent[] intents;

    public ItemAdapter(ArrayList<ItemCategory> viewPager2ArrayList) {
        this.viewPager2ArrayList = viewPager2ArrayList;
        this.context = context;
        this.intents = intents;
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


        //Le holder stock les éléments afin d'éviter de devoir les recréer à chaque fois
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
            itemView.setOnClickListener(view -> {

                Intent intents1 = new Intent(view.getContext(), GinPageActivity.class);
                Intent intents2 = new Intent(view.getContext(), RhumPageActivity.class);
                Intent intents3 = new Intent(view.getContext(), WhiskyPageActivity.class);
                Intent intents4 = new Intent(view.getContext(), VodkaPageActivity.class);

            });
        }
    }
}
