package org.future.foodflix.RecyclerViewInfo;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.future.foodflix.R;

public class MyViewHolder extends RecyclerView.ViewHolder  {

    TextView myIngredient;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        myIngredient = itemView.findViewById(R.id.Ingredient);


    }

}

