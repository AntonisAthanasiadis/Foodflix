package org.future.foodflix.RecyclerViewInfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.future.foodflix.R;
import org.future.foodflix.RecyclerView_ShowSearchResults.ListItem;
import org.future.foodflix.RecyclerView_ShowSearchResults.RecyclerViewClickListener;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {



    Context ct;
    ListItem listItem;

    public MyAdapter(Context ct, List<ListItem> listItems, RecyclerViewClickListener listener) {
        this.ct = ct;
        this.listItem = listItem;
        ;
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
        holder.myIngredient.setText((position+1) + ": " + listItem.getIngredients().get(position));

    }

    @Override
    public int getItemCount() {
        return listItem.getIngredients().size();
    }

}
