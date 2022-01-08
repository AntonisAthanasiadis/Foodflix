package org.future.foodflix.Storage.AsynchTasks;

import android.os.AsyncTask;
import android.util.Log;

import org.future.foodflix.Storage.Database.DatabaseSchema;
import org.future.foodflix.Storage.Database.User;

import java.util.ArrayList;
import java.util.List;

public class LoginCheck extends AsyncTask<String,Void, Boolean> {

    public interface Listener{
        public void onResult(boolean result);
    }

    private DatabaseSchema database;
    private LoginCheck.Listener listener;

    public LoginCheck(DatabaseSchema database, Listener listener) {
        this.database = database;
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        try{
            return database.getUserDao().checkLogin(strings[0],strings[1]);
        }catch (Exception e){
            return false;
        }
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        listener.onResult(aBoolean);
    }
}

