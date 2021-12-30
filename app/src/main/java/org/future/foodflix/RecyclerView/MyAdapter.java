package org.future.foodflix.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.future.foodflix.R;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context ct;
    String titles[], desc[];
    int images[];

    public MyAdapter(Context ct, String titles[], String desc[], int images[]) {
        this.ct = ct;
        this.titles = titles;
        this.desc = desc;
        this.images = images;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ct);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myTitle.setText(titles[position]);
        holder.myDesc.setText(desc[position]);
        holder.myImage.setImageResource(images[position]);


    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
