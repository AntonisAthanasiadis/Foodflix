package org.future.foodflix;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

import static java.util.Collections.emptyList;

import androidx.annotation.Nullable;
import androidx.room.Database;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import org.future.foodflix.RecyclerView.SecondActivity;
import org.future.foodflix.Storage.AsynchTasks.LoginCheck;
import org.future.foodflix.Storage.AsynchTasks.ReadDb;
import org.future.foodflix.Storage.Database.DatabaseSchema;
import org.future.foodflix.Storage.Database.User;

import java.util.Collection;
import java.util.List;


public class MainActivity extends BaseActivities {
    @Nullable
    private DatabaseSchema db;
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
//            @SneakyThrows
            @Override
            public void onClick(View v) {
                if (isDestroyed()||isFinishing()){
                    return;
                }

                TextInputEditText user = findViewById(R.id.usernameInput);
                String existingUser = user.getText().toString();

                TextInputEditText pass = findViewById(R.id.passwordInput);
                String existingPassword = pass.getText().toString();

                db = Room.databaseBuilder(MainActivity.this, DatabaseSchema.class,"foodflix").build();
                new  ReadDb(db, new ReadDb.Listener() {
                    @Override
                    public void onResult(List<User> result) {
                        Toast.makeText(MainActivity.this, "Read", Toast.LENGTH_SHORT).show();
                    }
                }).execute();
                if(existingPassword.equals(""))
                    Toast.makeText(MainActivity.this,"Please input your password!", Toast.LENGTH_SHORT).show();
                else if(existingUser.equals("")) {
                    Toast.makeText(MainActivity.this, "Please input your Username!", Toast.LENGTH_SHORT).show();
                }

                AsyncTask<String, Void, Boolean> check = new LoginCheck(db, new LoginCheck.Listener() {
                    @Override
                    public void onResult(boolean result) {
                        Toast.makeText(MainActivity.this,String.valueOf(result),Toast.LENGTH_SHORT).show();
                        if (result) {
                            Toast.makeText(MainActivity.this, "Logged in successfully!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, SeeDatabaseActivity.class);
                            startActivityForResult(intent, 1000);
                        } else {
                            Toast.makeText(MainActivity.this, "Please Try Again!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).execute(existingUser,existingPassword);
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
                Intent intent = new Intent(MainActivity.this,NavigationDrawerActivity.class);
                startActivity(intent);
                startActivityForResult(intent,1000);

            }
        });


        Button forgotbtn =findViewById(R.id.forgotbtn);
        forgotbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SeeDatabaseActivity.class);
                startActivityForResult(intent,1000);
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
