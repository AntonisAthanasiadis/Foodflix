package org.future.foodflix.RecyclerView_ShowSearchResults;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import org.future.foodflix.Network.NetWorkActivity;
import org.future.foodflix.R;
import org.future.foodflix.RecyclerView_ShowInfo.InfoActivity;


import java.util.*;

public class ShowResultsActivity extends AppCompatActivity {

    private Gson gson = new Gson();

    RecyclerView recyclerView;
    MyAdapter myAdapter;
    List<ListItem> listItems = new ArrayList<>();
    RecyclerViewClickListener listener;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



        listItems = (ArrayList<ListItem>) getIntent().getExtras().getSerializable("response");
        recyclerView = findViewById(R.id.RV1);

        setOnClickListner();
        myAdapter = new MyAdapter(this,listItems,listener);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //progressDialog.dismiss();
    }

    private void setOnClickListner() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Data Loading...");
        listener= new RecyclerViewClickListener() {
            @Override
            public void OnClick(View v, int position) {
                progressDialog.show();
                Intent intent = new Intent(ShowResultsActivity.this, InfoActivity.class);
                intent.putExtra("Ingredients",listItems.get(position).getIngredients());
                startActivity(intent);

                progressDialog.dismiss();
            }
        };
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);




       // LoadRecyclerViewData(jsonResponse);
        ImageView imageView =findViewById(R.id.recyclerbackbtn1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        FloatingActionButton fab = findViewById(R.id.faButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDestroyed()||isFinishing()){
                    return;
                }
                onBackPressed();

            }
        });




        //String name= getIntent().getExtras().getString("name");
        //Log.d("APP",name);
    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        //String name= getIntent().getExtras().getString("name");
//        //Log.d("APP",name);
//    }
//
//    @Override
//    public void onBackPressed() {
//        Toast.makeText(SecondActivity.this,"Do you want to go back?",Toast.LENGTH_SHORT).show();
//        setResult(RESULT_OK);
//        SecondActivity.this.finish();
//    }


}