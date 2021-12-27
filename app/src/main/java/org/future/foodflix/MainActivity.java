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

                TextView user = findViewById(R.id.usernameInput);
                String existingUser = user.getText().toString();

                TextView pass = findViewById(R.id.passwordInput);
                String existingPassword = pass.getText().toString();

                if(existingUser.equals("") || existingPassword.equals(""))
                    Toast.makeText(MainActivity.this,"Please input your logins!", Toast.LENGTH_SHORT).show();
                else if(existingUser.equals("user") && existingPassword.equals("name")) {
                    Toast.makeText(MainActivity.this,"Logged in successfully!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivityForResult(intent, 1000);
                }

            }
        });

        Button guestbtn= findViewById(R.id.guestbtn);
        guestbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDestroyed()||isFinishing()){
                    return;
                }
                Toast.makeText(MainActivity.this,"Logged in as guest!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
                startActivityForResult(intent,1000);

            }
        });


        Button forgotbtn =findViewById(R.id.forgotbtn);
        forgotbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("APP","Forgot button clicked");
                Toast.makeText(MainActivity.this,"Forgot button clicked!",Toast.LENGTH_SHORT).show();
            }
        });

        Button noAccount = findViewById(R.id.NoAccountbtn);
        noAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDestroyed()||isFinishing()){
                    return;
                }
                Toast.makeText(MainActivity.this,"New account coming right up!",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,RegistrationActivity.class);
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
