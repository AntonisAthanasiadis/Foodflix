package org.future.foodflix.Network;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;

import org.future.foodflix.CheckActions;
import org.future.foodflix.R;
import org.future.foodflix.ShowSearch;

public class NetWorkActivity extends AppCompatActivity {

    private RequestQueue queue;
    private Gson gson;

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



        ImageView imageView =findViewById(R.id.searchbackbtn);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Button nwbtn= findViewById(R.id.search_button);
        nwbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox vegetarian=findViewById(R.id.vegetarian);
                CheckBox vegan = findViewById(R.id.vegan);
                CheckBox lowFat= findViewById(R.id.low_fat);
                CheckBox pork= findViewById(R.id.pork);
                CheckBox gluten =findViewById(R.id.gluten);
                CheckBox immune= findViewById(R.id.immunosupportive);
                CheckBox wheat= findViewById(R.id.wheat);
                CheckBox shellfish= findViewById(R.id.shellfish);
                CheckBox[] Health= {vegetarian,vegan,lowFat,pork,gluten,immune,wheat,shellfish};

                TextInputLayout ingrs= findViewById(R.id.foodInput);
                String ingr= ingrs.getEditText().getText().toString();
                String query= CheckActions.ingredients(ingr);
                String health= CheckActions.Checked(Health);

                String url = "https://api.edamam.com/api/food-database/v2/parser?" +
                        "app_id=c0bb7b58"+
                        "&app_key=ad2b9082c4731f6b6a1e4193b90607e7"+
                        "&ingr="+ query+
                        health;

                Toast.makeText(NetWorkActivity.this,url,Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(NetWorkActivity.this, ShowSearch.class);
                startActivityForResult(intent,5257);

                // Request a string response from the provided URL.
//                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
//                        new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//                                Log.d("ELA", response.substring(0, 200));
//                                JsonResponse jsonResponse = gson.fromJson(response, JsonResponse.class);
//                                if (jsonResponse != null) {
//
//                                }
                                // Display the first 500 characters of the response string.
//                            }
//                        }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Log.e("TAG", error.getMessage());
//                           }
//                });

                // Add the request to the RequestQueue.
//                queue.add(stringRequest);
            }

            });






    }
}

