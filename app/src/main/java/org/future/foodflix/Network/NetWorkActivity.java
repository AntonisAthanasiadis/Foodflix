package org.future.foodflix.Network;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import org.future.foodflix.R;

public class NetWorkActivity extends AppCompatActivity {

    private RequestQueue queue;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_work);
        queue = Volley.newRequestQueue(this);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        gson = new Gson();

        String query= findViewById(R.id.searchInput).toString();

        // Instantiate the RequestQueue.
        String url = "https://api.edamam.com/api/food-database/v2/parser?" +
                "app_id=c0bb7b58"+
                "&app_key=ad2b9082c4731f6b6a1e4193b90607e7"+
                "&ingr="+ query;


        Button nwbtn= findViewById(R.id.searchbtn);
        nwbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.d("ELA", response.substring(0, 200));
                                JsonResponse jsonResponse = gson.fromJson(response, JsonResponse.class);
                                if (jsonResponse != null) {

                                }
                                // Display the first 500 characters of the response string.
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("TAG", error.getMessage());
                           }
                });

                // Add the request to the RequestQueue.
                queue.add(stringRequest);
            }

            });






    }
}

