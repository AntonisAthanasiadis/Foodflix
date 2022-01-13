package org.future.foodflix.RecyclerView_MainPage;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import org.future.foodflix.Network.JsonResponse.JsonResponse;
import org.future.foodflix.Network.NetWorkActivity;
import org.future.foodflix.R;
import org.future.foodflix.RecyclerView_ShowInfo.InfoActivity;
import org.future.foodflix.RecyclerView_ShowInfo.MyAdapter;
import org.future.foodflix.RecyclerView_ShowSearchResults.ListItem;
import org.future.foodflix.RecyclerView_ShowSearchResults.RecyclerViewClickListener;
import org.future.foodflix.RecyclerView_ShowSearchResults.ShowResultsActivity;
import org.future.foodflix.SeeDatabaseActivity;
import org.future.foodflix.Unused.Unused_RecyclerView.MainPageRecycler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class MainPageActivity extends AppCompatActivity {



    String[] randomFoods = {"chicken", "pizza","pasta"};
    Random rand = new Random();
    String randomFood = randomFoods[rand.nextInt(randomFoods.length)];
    Button buttonshare;
    public final String CHANNEL_ID2 = "2";

    String url = "https://api.edamam.com/api/recipes/v2?" +
            "type=public" +
            "&q=" +
             randomFood +
            "&app_id=85236044" +
            "&app_key=d2448eb147c0c48689ed8a40d9c107de" +
            "&random=true";


    RecyclerView recyclerView;
    MyAdapterMain myAdapter;
    List<ListItem> listItems = new ArrayList<>();
    RecyclerViewClickListener listener;

    private RequestQueue queue;
    private Gson gson;
    JsonResponse jsonResponse;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);




        queue = Volley.newRequestQueue(this);

        gson = new Gson();


        recyclerView = findViewById(R.id.RV3);

        setOnClickListener();






        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 18);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);




        buttonshare = (Button) findViewById(R.id.buttonshare);
        buttonshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody ="https://www.facebook.com/Edamam/" ;
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(myIntent, "Share using"));
            }
        });
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);



        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {



                        jsonResponse = gson.fromJson(response, JsonResponse.class);
                        JsonToObject(jsonResponse);

                        myAdapter = new MyAdapterMain(MainPageActivity.this,listItems,listener);

                        recyclerView.setAdapter(myAdapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainPageActivity.this));


                        ProgressBar progressBar = findViewById(R.id.progressbar1);
                        progressBar.setVisibility(View.GONE);

                        TextView randomfood = findViewById(R.id.mainRandomFood);
                        randomfood.setText("Here are some random suggestions including " +randomFood);



                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainPageActivity.this, "An error occured:\n"+ error.getMessage(),Toast.LENGTH_LONG).show();

            }
        });

        //   Add the request to the RequestQueue.
        queue.add(stringRequest);

        FloatingActionButton fab = findViewById(R.id.mainrecyclerFaButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDestroyed()||isFinishing()){
                    return;
                }
                Intent intent = new Intent(MainPageActivity.this, NetWorkActivity.class);
                startActivityForResult(intent,2200);
            }
        });
        FloatingActionButton fab2 = findViewById(R.id.profileFaButton);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDestroyed()||isFinishing()){
                    return;
                }
                Intent intent = new Intent(MainPageActivity.this, SeeDatabaseActivity.class);
                startActivityForResult(intent,2200);

                startNotification2();
            }
            @RequiresApi(api = Build.VERSION_CODES.O)
            public void startNotification2(){
                NotificationChannel channel2 = new NotificationChannel(CHANNEL_ID2,"2", NotificationManager.IMPORTANCE_DEFAULT);
                NotificationManager manager2 = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                manager2.createNotificationChannel(channel2);
                Notification.Builder builder2 = new Notification.Builder(MainPageActivity.this,CHANNEL_ID2);
                builder2.setSmallIcon(R.drawable.flix1024).setContentTitle("The presentation has started.")
                        .setPriority(Notification.PRIORITY_DEFAULT);
                NotificationManagerCompat compat2 = NotificationManagerCompat.from(MainPageActivity.this);
                compat2.notify(2,builder2.build());
            }
        });

    }

    private void setOnClickListener() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Data Loading...");
        listener= new RecyclerViewClickListener() {
            @Override
            public void OnClick(View v, int position) {

                Intent intent = new Intent(MainPageActivity.this, InfoActivity.class);
                intent.putExtra("Ingredients",listItems.get(position).getIngredients());
                startActivity(intent);


            }
        };
    }

    private void JsonToObject(JsonResponse jsonResponse) {

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