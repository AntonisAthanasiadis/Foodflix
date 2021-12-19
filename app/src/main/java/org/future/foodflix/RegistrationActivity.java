package org.future.foodflix;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        getBaseContext().getResources().getString(R.string.app_name);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        String name = getIntent().getExtras().getString("name");
        Log.d("App",name);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String name = getIntent().getExtras().getString("name");
        Log.d("App",name);
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