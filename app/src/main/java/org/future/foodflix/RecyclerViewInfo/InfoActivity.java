package org.future.foodflix.RecyclerViewInfo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.gson.Gson;

import org.future.foodflix.Network.JsonResponse.JsonResponse;
import org.future.foodflix.R;
import org.future.foodflix.RecyclerView_ShowSearchResults.ListItem;

import java.util.ArrayList;
import java.util.List;

public class InfoActivity extends AppCompatActivity {

    private Gson gson = new Gson();

    RecyclerView recyclerView;
    MyAdapter myAdapter;
    List<String> ingredients = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);


       // ingredients =  getIntent().getExtras().getSerializableExtra("Ingredients");
        recyclerView = findViewById(R.id.RV2);

       // myAdapter = new MyAdapter(this,listItems);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageView imageView =findViewById(R.id.recyclerbackbtn2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

//        setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }


