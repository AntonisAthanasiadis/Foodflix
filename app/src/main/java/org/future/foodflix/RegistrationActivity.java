package org.future.foodflix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.future.foodflix.RecyclerView.SecondActivity;
import org.future.foodflix.Storage.AsynchTasks.InsertDb;
import org.future.foodflix.Storage.Database.DatabaseSchema;
import org.future.foodflix.Storage.Database.User;
import org.future.foodflix.Storage.StorageActions;

import androidx.annotation.Nullable;
import androidx.room.Database;
import androidx.room.Room;

import com.google.android.material.textfield.TextInputEditText;

public class RegistrationActivity extends BaseActivities {
    @Nullable
    private DatabaseSchema db;
    @Override
    public int getLayoutId() {
        return R.layout.activity_registration;
    }
    @Override
    public void useUIElements() {
        db= Room.databaseBuilder(RegistrationActivity.this, DatabaseSchema.class,"foodflix").build();
        Button register = findViewById(R.id.signUp);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDestroyed() || isFinishing()) {
                    return;
                }

                TextInputEditText user = findViewById(R.id.regUser);
                String newUser = user.getText().toString();

                TextInputEditText name = findViewById(R.id.regFirst);
                String firstName = name.getText().toString();

                TextInputEditText Lname = findViewById(R.id.regLast);
                String lastName = Lname.getText().toString();

                TextInputEditText p1 = findViewById(R.id.regPass1);
                String pass1 = p1.getText().toString();

                TextInputEditText p2 = findViewById(R.id.regPass2);
                String pass2 = p2.getText().toString();

//                if(!pass1.equals(pass2))
//                    Toast.makeText(RegistrationActivity.this, "Passwords don't match!", Toast.LENGTH_SHORT).show();
//                else if(pass1.length()<6)
//                    Toast.makeText(RegistrationActivity.this, "Password is too short!", Toast.LENGTH_SHORT).show();
//                else if(newUser.length()>20 || pass1.length()>20 || firstName.length()>20 || lastName.length()>20)
//                    Toast.makeText(RegistrationActivity.this, "A maximum of 20 characters is accepted!", Toast.LENGTH_SHORT).show();
//                else if (newUser.equals("") || firstName.equals("") || lastName.equals(""))
//                    Toast.makeText(RegistrationActivity.this, "Please fill all the required fields!", Toast.LENGTH_SHORT).show();
//                else {
//                    Toast.makeText(RegistrationActivity.this, "Created new account successfully!", Toast.LENGTH_SHORT).show();
                CheckActions check = new CheckActions();
                String eval= check.eval(pass1, pass2, newUser, firstName, lastName);
                Toast.makeText(RegistrationActivity.this, eval, Toast.LENGTH_SHORT).show();
                if (eval.equals("Created new account successfully!")){
                    db = Room.databaseBuilder(RegistrationActivity.this,DatabaseSchema.class,"foodflix").build();

                    new InsertDb(db, new InsertDb.Listener() {
                        @Override
                        public void onResult(boolean result) {
                            Toast.makeText(RegistrationActivity.this, "Data inserted!!! " + result, Toast.LENGTH_SHORT).show();
                        }
                    }).execute(new User(newUser,firstName,lastName,pass1));
                    Intent intent = new Intent(RegistrationActivity.this, SeeDatabaseActivity.class);
                    startActivityForResult(intent, 1000);
                }

            }
        });
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getBaseContext().getResources().getString(R.string.app_name);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        //String name = getIntent().getExtras().getString("name");
        //Log.d("App",name);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //String name = getIntent().getExtras().getString("name");
        //Log.d("App",name);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private boolean secondTap=false;
    @Override
    public void stopOperations() {

    }
    @Override
    public void startOperations() {

    }
    @Override
    public void onBackPressed() {
        Toast.makeText(RegistrationActivity.this, "Please complete this form.", Toast.LENGTH_SHORT).show();
        if (secondTap==true){
            super.onBackPressed();
        }
        else{
            secondTap=true;
        }

    }
}