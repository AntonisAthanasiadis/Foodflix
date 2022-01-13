package org.future.foodflix.Network;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.android.volley.*;
import com.android.volley.toolbox.*;
import com.google.android.material.slider.RangeSlider;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;

import org.future.foodflix.CheckActions;
import org.future.foodflix.Network.JsonResponse.JsonResponse;
import org.future.foodflix.OnErrorActivity;
import org.future.foodflix.R;
import org.future.foodflix.RecyclerView_ShowSearchResults.ListItem;
import org.future.foodflix.RecyclerView_ShowSearchResults.ShowResultsActivity;

import java.util.ArrayList;

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

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Data Loading...");

        RangeSlider slider = findViewById(R.id.slider);
        SwitchCompat switchCompat = findViewById(R.id.switchWidget);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CheckActions.switchCompatCheckedUI((SwitchCompat) buttonView,slider);
            }
        });
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



                CheckBox vegetarian = findViewById(R.id.vegetarian);
                CheckBox vegan = findViewById(R.id.vegan);
                CheckBox immune = findViewById(R.id.immunosupportive);
                CheckBox gluten = findViewById(R.id.gluten);

                CheckBox balanced = findViewById(R.id.balanced);
                CheckBox highProtein = findViewById(R.id.high_protein);
                CheckBox lowFat = findViewById(R.id.low_fat);
                CheckBox lowCarb = findViewById(R.id.low_carb);

                CheckBox[] Health = {vegetarian, vegan, immune, gluten};
                CheckBox[] Diet = {balanced, highProtein, lowFat, lowCarb};

                TextInputLayout ingredients = findViewById(R.id.ingrInput);
                String ingr = ingredients.getEditText().getText().toString();
                String diet = CheckActions.Checked(Diet, "diet");

                TextInputLayout Queries = findViewById(R.id.foodInput);
                String query = Queries.getEditText().getText().toString();
                String q = CheckActions.queries(query);
                String health = CheckActions.Checked(Health, "health");

                RangeSlider slider = findViewById(R.id.slider);
                SwitchCompat switchCompat = findViewById(R.id.switchWidget);
                switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        CheckActions.switchCompatCheckedUI((SwitchCompat) buttonView,slider);
                    }
                });
                final String[] SliderValues = {""};
                slider.addOnSliderTouchListener(new RangeSlider.OnSliderTouchListener() {
                    @Override
                    public void onStartTrackingTouch(@NonNull RangeSlider slider) {

                    }

                    @Override
                    public void onStopTrackingTouch(@NonNull RangeSlider slider) {
                        SliderValues[0] += CheckActions.calories(slider, SliderValues);
                    }
                });

                String calories = CheckActions.switchCompatCheckedCalories(switchCompat,slider,SliderValues);

                String url = "https://api.edamam.com/api/recipes/v2?type=public" +
                        "&q=" + q +
                        "&app_id=85236044&app_key=d2448eb147c0c48689ed8a40d9c107de";

                url=CheckActions.ingrCheck(url,ingr,diet,health,calories);
//                Toast.makeText(NetWorkActivity.this, "URL\n"+ url,Toast.LENGTH_LONG).show();

                //    Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                progressDialog.show();
                                jsonResponse = gson.fromJson(response, JsonResponse.class);
                                LoadRecyclerViewData(jsonResponse);

                                if(listItems.isEmpty()) {
                                    Intent intent = new Intent(NetWorkActivity.this, OnErrorActivity.class);
                                    startActivity(intent);
                                    progressDialog.dismiss();
                                }
                            else{

                                Intent intent = new Intent(NetWorkActivity.this, ShowResultsActivity.class);
                                intent.putExtra("response", listItems);
                                startActivity(intent);

                                progressDialog.dismiss();}
                                //    Display the first 500 characters of the response string.
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Intent intent = new Intent(NetWorkActivity.this, OnErrorActivity.class);
                        startActivity(intent);
                    }
                });

                //   Add the request to the RequestQueue.
                queue.add(stringRequest);
            }
        });
    }

    private void LoadRecyclerViewData(JsonResponse jsonResponse) {

        listItems.clear();

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