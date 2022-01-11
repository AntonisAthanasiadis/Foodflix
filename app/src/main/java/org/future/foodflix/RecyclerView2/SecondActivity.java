package org.future.foodflix.RecyclerView2;


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
import org.future.foodflix.Network.JsonResponse.JsonResponse;


import java.util.*;

public class SecondActivity extends AppCompatActivity {

    private Gson gson = new Gson();

    RecyclerView recyclerView;
    MyAdapter myAdapter;
    List<ListItem> listItems = new ArrayList<>();
    JsonResponse jsonResponse;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        listItems = (List<ListItem>) getIntent().getExtras().getSerializable("response");
        recyclerView = findViewById(R.id.RV1);

        myAdapter = new MyAdapter(this,listItems);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //progressDialog.dismiss();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);




       // LoadRecyclerViewData(jsonResponse);
        ImageView imageView =findViewById(R.id.recyclerbackbtn);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Button toNetworkActivity = findViewById(R.id.Rbtn1);
        toNetworkActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDestroyed()||isFinishing()){
                    return;
                }
                Intent intent = new Intent(SecondActivity.this, NetWorkActivity.class);
                startActivityForResult(intent,2000);
            }
        });

        FloatingActionButton fab = findViewById(R.id.faButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDestroyed()||isFinishing()){
                    return;
                }
                Intent intent = new Intent(SecondActivity.this, NetWorkActivity.class);
                startActivityForResult(intent,2000);
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