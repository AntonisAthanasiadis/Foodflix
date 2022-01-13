package org.future.foodflix.RecyclerView;

import static android.app.AlarmManager.INTERVAL_DAY;
import static android.app.AlarmManager.RTC_WAKEUP;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.Context;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.future.foodflix.Network.NetWorkActivity;
import org.future.foodflix.R;
import org.future.foodflix.SeeDatabaseActivity;
import java.util.ArrayList;
import java.util.Calendar;

public class MainPageRecycler extends AppCompatActivity {
    Button buttonshare;
    private Object AlarmManager;
    public final String CHANNEL_ID = "1";
    private RecyclerView parentRecyclerView;
    private RecyclerView.Adapter ParentAdapter;
    ArrayList<ParentModel> parentModelArrayList = new ArrayList<>();
    private RecyclerView.LayoutManager parentLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpagerecycler);

        parentModelArrayList.add(new ParentModel("Meat"));
        parentModelArrayList.add(new ParentModel("Snack"));
        parentModelArrayList.add(new ParentModel("Category3"));
        parentModelArrayList.add(new ParentModel("Category4"));
        parentModelArrayList.add(new ParentModel("Category5"));
        parentModelArrayList.add(new ParentModel("Category6"));
        parentRecyclerView = findViewById(R.id.parent_recyclerview);
        parentRecyclerView.setHasFixedSize(true);
        parentLayoutManager = new LinearLayoutManager(this);
        ParentAdapter = new ParentRecyclerViewAdapter(parentModelArrayList, org.future.foodflix.RecyclerView.MainPageRecycler.this);
        parentRecyclerView.setLayoutManager(parentLayoutManager);
        parentRecyclerView.setAdapter(ParentAdapter);
        ParentAdapter.notifyDataSetChanged();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 1);
        calendar.set(Calendar.MINUTE, 21);
        calendar.set(Calendar.SECOND, 00);

        Intent i = new Intent(getApplicationContext(), NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 100, i, PendingIntent.FLAG_UPDATE_CURRENT);
        android.app.AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(RTC_WAKEUP, calendar.getTimeInMillis(), INTERVAL_DAY, pendingIntent);}
        @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        FloatingActionButton fab = findViewById(R.id.mainrecyclerFaButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDestroyed()||isFinishing()){
                    return;
                }
                Intent intent = new Intent(MainPageRecycler.this, NetWorkActivity.class);
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
                Intent intent = new Intent(MainPageRecycler.this, SeeDatabaseActivity.class);
                startActivityForResult(intent,2200);
            }
        });
        buttonshare = (Button) findViewById(R.id.buttonshare);
        buttonshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = "https://www.facebook.com/Edamam/";
                String shareSub = "Your subject";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                myIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(myIntent, "Share using"));
            }
        });}}