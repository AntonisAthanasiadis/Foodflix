package org.future.foodflix.RecyclerView_ShowInfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.future.foodflix.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {



    Context ct;
    ArrayList<String> ingredients;

    public MyAdapter(Context ct, ArrayList<String> ingredients) {
        this.ct = ct;
        this.ingredients = ingredients;

    }





    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ct);
        View view = inflater.inflate(R.layout.ingredient,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myIngredient.setText(ingredients.get(position));

    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

}
