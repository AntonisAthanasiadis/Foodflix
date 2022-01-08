package org.future.foodflix.RecyclerView;

import android.widget.TextView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.future.foodflix.R;

import java.util.ArrayList;

public class ParentRecyclerViewAdapter extends RecyclerView.Adapter<ParentRecyclerViewAdapter.MyViewHolder>

{

    private ArrayList<ParentModel> parentModelArrayList;
    public Context cxt;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView category;
        public RecyclerView childRecyclerView;

        public MyViewHolder(View itemView) {
            super(itemView);

            category = itemView.findViewById(R.id.Food_category);
            childRecyclerView = itemView.findViewById(R.id.child_recyclerview);
        }
    }

    public ParentRecyclerViewAdapter(ArrayList < ParentModel > exampleList, Context context) {
        this.parentModelArrayList = exampleList;
        this.cxt = context;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public int getItemCount () {
        return parentModelArrayList.size();
    }

    @Override
    public void onBindViewHolder (@NonNull MyViewHolder holder, int position){

        ParentModel currentItem = parentModelArrayList.get(position);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(cxt, LinearLayoutManager.HORIZONTAL, false);
        holder.childRecyclerView.setLayoutManager(layoutManager);
        holder.childRecyclerView.setHasFixedSize(true);

        holder.category.setText(currentItem.foodCategory());
        ArrayList<ChildModel> arrayList = new ArrayList<>();

        if (parentModelArrayList.get(position).foodCategory().equals("Meat")) {
            arrayList.add(new ChildModel(R.drawable.pastitsio,"Pastitsio","Pastitsio"));
            arrayList.add(new ChildModel(R.drawable.souvlaki," Souvlaki"," Souvlaki"));
        }

        if (parentModelArrayList.get(position).foodCategory().equals("Snack")) {
            arrayList.add(new ChildModel(R.drawable.toast, "Toast","Toast"));
            arrayList.add(new ChildModel(R.drawable.tiropita, "Tiropita","Tiropita" ));
        }
        ChildRecyclerViewAdapter childRecyclerViewAdapter = new ChildRecyclerViewAdapter(arrayList, holder.childRecyclerView.getContext());
        holder.childRecyclerView.setAdapter(childRecyclerViewAdapter);
    }
}