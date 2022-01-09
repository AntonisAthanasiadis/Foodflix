package org.future.foodflix.Network;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.slider.RangeSlider;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;

import org.future.foodflix.CheckActions;
import org.future.foodflix.R;
import org.future.foodflix.RecyclerView.SecondActivity;
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

        RangeSlider slider = findViewById(R.id.slider);
        SwitchCompat switchCompat=findViewById(R.id.switchWidget);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    slider.setEnabled(true);
                }else{
                    slider.setEnabled(false);
                }
            }
        });

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

                TextInputLayout Queries= findViewById(R.id.foodInput);
                String query= Queries.getEditText().getText().toString();
                String q= CheckActions.ingredients(query);
                String health= CheckActions.Checked(Health);


                RangeSlider slider = findViewById(R.id.slider);
                SwitchCompat switchCompat=findViewById(R.id.switchWidget);
                switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked){
                            slider.setEnabled(true);
                        }else{
                            slider.setEnabled(false);
                        }
                    }
                });


                final String[] SliderValues = {""};
                slider.addOnSliderTouchListener(new RangeSlider.OnSliderTouchListener() {
                    @Override
                    public void onStartTrackingTouch(@NonNull RangeSlider slider) {

                    }

                    @Override
                    public void onStopTrackingTouch(@NonNull RangeSlider slider) {
                        SliderValues[0] +=CheckActions.calories(slider,SliderValues);
                    }
                });
                if (switchCompat.isChecked()){
                    SliderValues[0]=CheckActions.calories(slider,SliderValues);
                }
                else{
                    SliderValues[0]="0-1000";
                }

                String sliderValues= SliderValues[0];


                String url = "https://api.edamam.com/api/food-database/v2/parser?" +
                        "app_id=c0bb7b58"+
                        "&app_key=ad2b9082c4731f6b6a1e4193b90607e7"+
                        "&ingr="+ q+ "&nutrition-type=cooking"+health +
                        "&calories="+ sliderValues;

//                Toast.makeText(NetWorkActivity.this, SliderValues[0], Toast.LENGTH_SHORT).show();
                Toast.makeText(NetWorkActivity.this,url,Toast.LENGTH_SHORT).show();

                Intent intent =new Intent(NetWorkActivity.this, SecondActivity.class);
                intent.putExtra("URL",url);
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

