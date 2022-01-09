package org.future.foodflix.RecyclerView;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.future.foodflix.R;

import java.util.ArrayList;

public class MainPageRecycler extends AppCompatActivity {
    private RecyclerView parentRecyclerView;
    private RecyclerView.Adapter ParentAdapter;
    ArrayList<ParentModel> parentModelArrayList = new ArrayList<>();
    private RecyclerView.LayoutManager parentLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpagerecycler);

        //set the Categories for each array list set in the `ParentViewHolder`
        parentModelArrayList.add(new ParentModel("Meat"));
        parentModelArrayList.add(new ParentModel("Snack"));
        parentModelArrayList.add(new ParentModel("Category3"));
        parentModelArrayList.add(new ParentModel("Category4"));
        parentModelArrayList.add(new ParentModel("Category5"));
        parentModelArrayList.add(new ParentModel("Category6"));
        parentModelArrayList.add(new ParentModel("Category7"));
        parentModelArrayList.add(new ParentModel("Category8"));
        parentRecyclerView = findViewById(R.id.parent_recyclerview);
        parentRecyclerView.setHasFixedSize(true);
        parentLayoutManager = new LinearLayoutManager(this);
        ParentAdapter = new ParentRecyclerViewAdapter(parentModelArrayList, org.future.foodflix.RecyclerView.MainPageRecycler.this);
        parentRecyclerView.setLayoutManager(parentLayoutManager);
        parentRecyclerView.setAdapter(ParentAdapter);
        ParentAdapter.notifyDataSetChanged();
    }
}
