package org.future.foodflix.Network;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.*;
import com.android.volley.toolbox.*;
import com.google.gson.Gson;

import org.future.foodflix.Network.JsonResponse.JsonResponse;
import org.future.foodflix.R;
import org.future.foodflix.RecyclerView2.ListItem;
import org.future.foodflix.RecyclerView2.SecondActivity;

import java.util.ArrayList;
import java.util.List;

public class NetWorkActivity extends AppCompatActivity {

    private RequestQueue queue;
    private Gson gson;
    JsonResponse jsonResponse;
    ArrayList<ListItem> listItems = new ArrayList<ListItem>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_fragment);
        queue = Volley.newRequestQueue(this);

    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        gson = new Gson();

        String url = "https://api.edamam.com/api/recipes/v2?type=public" +
                "&q=chicken" +
                "&app_id=85236044&app_key=d2448eb147c0c48689ed8a40d9c107de" +
                "&random=true";


        //    Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                         jsonResponse = gson.fromJson(response, JsonResponse.class);
                        LoadRecyclerViewData(jsonResponse);
                        //    Display the first 500 characters of the response string.
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage());
            }
        });

        //   Add the request to the RequestQueue.
        queue.add(stringRequest);

        CheckBox vegetarian = findViewById(R.id.vegetarian);
        CheckBox vegan = findViewById(R.id.vegan);
        CheckBox lowFat = findViewById(R.id.low_fat);
        CheckBox pork = findViewById(R.id.pork);
        CheckBox gluten = findViewById(R.id.gluten);
        CheckBox immune = findViewById(R.id.immunosupportive);
        CheckBox wheat = findViewById(R.id.wheat);
        CheckBox shellfish = findViewById(R.id.shellfish);
        CheckBox[] Health = {vegetarian, vegan, lowFat, pork, gluten, immune, wheat, shellfish};


        ImageView imageView = findViewById(R.id.searchbackbtn);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Button nwbtn = findViewById(R.id.search_button);
        nwbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NetWorkActivity.this, SecondActivity.class);
               intent.putExtra("response",listItems);
                startActivity(intent);
            }

        });


        }

    private void LoadRecyclerViewData(JsonResponse jsonResponse) {
//        ProgressBar progressBar = new ProgressBar(this);
//        progressBar.set("Loading data...");
//        progressBar.show();

        int i ;
        for ( i=0; i < jsonResponse.getHits().size(); i++)
            listItems.add( new ListItem(
                    jsonResponse.getHits().get(i).getRecipe().getLabel(),
                    jsonResponse.getHits().get(i).getRecipe().getCalories(),
                    jsonResponse.getHits().get(i).getRecipe().getIngredientLines(),
                    jsonResponse.getHits().get(i).getRecipe().getImages().getSMALL().getUrl()
            ));
    }
}


