package org.future.foodflix;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.accessibility.AccessibilityViewCommand;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends BaseActivities {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void useUIElements() {
        ImageView imageView =findViewById(R.id.backbtn);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        TextView textView =findViewById(R.id.loginText);
        textView.setText(getString(R.string.Joke));

        Button loginbtn= findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDestroyed()||isFinishing()){
                    return;
                }
                Snackbar.make(v,"Login Button is Clicked!", Snackbar.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("name","Hungry");
                startActivityForResult(intent,1000);

            }
        });
        Button forgotbtn =findViewById(R.id.forgotbtn);
        forgotbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("APP","Forgot button clicked");
                Toast.makeText(MainActivity.this,"Forgot button clicked",Toast.LENGTH_SHORT).show();
            }
        });

        Button noAccount = findViewById(R.id.NoAccountbtn);
        noAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDestroyed()||isFinishing()){
                    return;
                }
                Snackbar.make(v,"You want to make a new account? Don't worry!", Snackbar.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,RegistrationActivity.class);
                intent.putExtra("name","Hungry");
                startActivityForResult(intent,2000);
            }
        });
    }

    @Override
    public void startOperations() {

    }

    @Override
    public void stopOperations() {

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(MainActivity.this,"Forgot button clicked",Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data!=null){
            if (data.getExtras()!=null){
                String name = data.getExtras().getString("name");
                Toast.makeText(MainActivity.this,name,Toast.LENGTH_SHORT).show();

            }
        }
    }
}
