package org.future.foodflix.RecyclerView_MainPage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.future.foodflix.R;
import org.future.foodflix.RecyclerView_ShowSearchResults.ListItem;
import org.future.foodflix.RecyclerView_ShowSearchResults.RecyclerViewClickListener;

import java.util.List;

public class MyAdapterMain extends RecyclerView.Adapter<MyAdapterMain.MyViewHolder> {

    RecyclerViewClickListener listener;
    Context ct;
    List<ListItem> listItems;

    public MyAdapterMain(Context ct, List<ListItem> listItems, RecyclerViewClickListener listener) {
        this.ct = ct;
        this.listItems = listItems;
        this.listener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView myTitle, myDesc;
        ImageView myImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myTitle = itemView.findViewById(R.id.Title);
            myDesc = itemView.findViewById(R.id.Description);
            myImage = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            listener.OnClick(v,getAdapterPosition());
        }
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
        holder.myDesc.setText("Calories: " +listItems.get(position).getCalories());

        Picasso.with(ct)
                .load(listItems.get(position).getImageURL())
                .into(holder.myImage);


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }
}
