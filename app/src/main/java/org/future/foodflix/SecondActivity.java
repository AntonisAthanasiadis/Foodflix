package org.future.foodflix;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getBaseContext().getResources().getString(R.string.app_name);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        String name= getIntent().getExtras().getString("name");
        Log.d("APP",name);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String name= getIntent().getExtras().getString("name");
        Log.d("APP",name);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(SecondActivity.this,"Do you want to go back?",Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK);
        SecondActivity.this.finish();
    }
}