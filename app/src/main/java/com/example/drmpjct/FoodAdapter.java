package com.example.drmpjct;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Food> foods;

    public FoodAdapter(LayoutInflater inflater, List<Food> foods) {
        this.inflater = inflater;
        this.foods = foods;
    }


    @NonNull
    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.food, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.ViewHolder holder, int position) {
        Food food = foods.get(position);
        holder.foodImg.setImageResource(food.getFoto());
        holder.kcalView.setText(food.getKcal());
        holder.foodnameView.setText(food.getFoodname());
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView foodImg;
        final TextView foodnameView, kcalView;
        ViewHolder(View view){
            super(view);
            foodImg = view.findViewById(R.id.foodImg);
            foodnameView = view.findViewById(R.id.txtFood);
            kcalView = view.findViewById(R.id.txtKcal);
        }

}
}
