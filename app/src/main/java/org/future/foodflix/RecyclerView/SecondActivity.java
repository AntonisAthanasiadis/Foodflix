package org.future.foodflix.RecyclerView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.future.foodflix.MainActivity;
import org.future.foodflix.Network.NetWorkActivity;
import org.future.foodflix.R;
import org.future.foodflix.RecyclerView.MyAdapter;
import org.future.foodflix.RegistrationActivity;

public class SecondActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter myAdapter;

    String titles[], desc[];
    int images[] = {R.drawable.food3,
            R.drawable.food2,
            R.drawable.food3,
            R.drawable.food2,
            R.drawable.food3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        recyclerView = findViewById(R.id.RV1);

        titles = getResources().getStringArray(R.array.Titles);
        desc = getResources().getStringArray(R.array.Descriptions);

        myAdapter = new MyAdapter(this,titles,desc,images);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
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