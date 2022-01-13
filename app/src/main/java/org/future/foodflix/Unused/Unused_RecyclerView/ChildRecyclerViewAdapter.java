package org.future.foodflix.Unused.Unused_RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.future.foodflix.R;

import java.util.ArrayList;

public class ChildRecyclerViewAdapter extends RecyclerView.Adapter<ChildRecyclerViewAdapter.MyViewHolder> {
    public ArrayList<ChildModel> childModelArrayList;
    Context cxt;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView Image;
        public TextView foodName;
        public TextView foodDetails;


        public MyViewHolder(View itemView) {
            super(itemView);
            Image = itemView.findViewById(R.id.image_view2);
            foodName = itemView.findViewById(R.id.textViewTitle2);
            foodDetails = itemView.findViewById(R.id.textViewDetails2);

        }
    }

    public ChildRecyclerViewAdapter(ArrayList<ChildModel> arrayList, Context mContext) {
        this.cxt = mContext;
        this.childModelArrayList = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ChildModel currentItem = childModelArrayList.get(position);
        holder.Image.setImageResource(currentItem.getImage_view2());
        holder.foodName.setText(currentItem.getTextViewTitle2());
        holder.foodDetails.setText(currentItem.getTextViewDetails2());

    }

    @Override
    public int getItemCount() {
        return childModelArrayList.size();
    }
}