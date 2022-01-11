package org.future.foodflix.RecyclerView2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.future.foodflix.R;


public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView myTitle, myDesc;
    ImageView myImage;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        myTitle = itemView.findViewById(R.id.Title);
        myDesc = itemView.findViewById(R.id.Description);
        myImage = itemView.findViewById(R.id.imageView);

    }
}
