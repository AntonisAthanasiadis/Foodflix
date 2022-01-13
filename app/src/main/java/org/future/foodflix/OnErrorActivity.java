package org.future.foodflix;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.future.foodflix.Network.NetWorkActivity;
import org.future.foodflix.RecyclerView_MainPage.MainPageActivity;

public class OnErrorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_error);






    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Button toastButton = findViewById(R.id.makeToast);
        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OnErrorActivity.this, "Here's some toast with extra bacon!", Toast.LENGTH_SHORT).show();
            }
        });

        FloatingActionButton fab = findViewById(R.id.mainrecyclerFaButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDestroyed()||isFinishing()){
                    return;
                }
                Intent intent = new Intent(OnErrorActivity.this, NetWorkActivity.class);
                startActivityForResult(intent,2200);
            }
        });
    }
}