package org.future.foodflix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends BaseActivities {

    @Override
    public int getLayoutId() {
        return R.layout.activity_registration;
    }
    @Override
    public void useUIElements() {
        Button register = findViewById(R.id.signUp);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (isDestroyed() || isFinishing()) {
                    return;
                }

                TextView user = findViewById(R.id.regUser);
                String newUser = user.getText().toString();

                TextView name = findViewById(R.id.regFirst);
                String firstName = name.getText().toString();

                TextView Lname = findViewById(R.id.regLast);
                String lastName = Lname.getText().toString();

                TextView p1 = findViewById(R.id.regPass1);
                String pass1 = p1.getText().toString();

                TextView p2 = findViewById(R.id.regPass2);
                String pass2 = p2.getText().toString();

                if(!pass1.equals(pass2))
                    Toast.makeText(RegistrationActivity.this, "Passwords don't match!", Toast.LENGTH_SHORT).show();
                else if(pass1.length()<6)
                    Toast.makeText(RegistrationActivity.this, "Password is too short!", Toast.LENGTH_SHORT).show();
                else if(newUser.length()>20 || pass1.length()>20 || firstName.length()>20 || lastName.length()>20)
                    Toast.makeText(RegistrationActivity.this, "A maximum of 20 characters is accepted!", Toast.LENGTH_SHORT).show();
                else if (newUser.equals("") || firstName.equals("") || lastName.equals(""))
                    Toast.makeText(RegistrationActivity.this, "Please fill all the required fields!", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(RegistrationActivity.this, "Created new account successfully!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegistrationActivity.this, SecondActivity.class);
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