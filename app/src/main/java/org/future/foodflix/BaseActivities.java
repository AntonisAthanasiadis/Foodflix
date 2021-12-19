package org.future.foodflix;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivities extends AppCompatActivity {
    abstract public int getLayoutId();
    abstract public void useUIElements();
    abstract public void startOperations();
    abstract public void stopOperations();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        useUIElements();
    }

    @Override
    protected void onResume() {
        super.onResume();
        startOperations();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onPause() {
        stopOperations();
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}

