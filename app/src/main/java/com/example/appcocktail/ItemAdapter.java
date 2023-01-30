package com.example.appcocktail;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{

    private Context context;
    private ArrayList<ItemCategory> viewPager2ArrayList;

    public ItemAdapter(ArrayList<ItemCategory> viewPager2ArrayList, Context context) {
        this.viewPager2ArrayList = viewPager2ArrayList;
        this.context = context;
    }

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
            itemView.setOnClickListener(view -> {
                Intent intent;

                switch (getBindingAdapterPosition()) {
                    case 0:
                        intent = new Intent(view.getContext(), GinPageActivity.class);
                        break;
                    case 1:
                        intent = new Intent(view.getContext(), RhumPageActivity.class);
                        break;
                    case 2:
                        intent = new Intent(view.getContext(), WhiskyPageActivity.class);
                        break;
                    case 3:
                        intent = new Intent(view.getContext(), VodkaPageActivity.class);
                        break;
                    default:
                        intent = new Intent(view.getContext(), MainActivity.class);
                        break;
                }
                context.startActivity(intent);
            });
        }
    }
}
