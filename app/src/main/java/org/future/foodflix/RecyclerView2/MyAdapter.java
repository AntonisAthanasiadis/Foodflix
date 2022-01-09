package org.future.foodflix.RecyclerView2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.future.foodflix.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {


    Context ct;
    List<ListItem> listItems;

    public MyAdapter(Context ct, List<ListItem> listItems) {
        this.ct = ct;
        this.listItems = listItems;
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
        holder.myTitle.setText(listItems.get(position).getTitle());
        holder.myDesc.setText("" +listItems.get(position).getCalories());

        Picasso.with(ct)
                .load(listItems.get(position).getImageURL())
                .into(holder.myImage);


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }
}
