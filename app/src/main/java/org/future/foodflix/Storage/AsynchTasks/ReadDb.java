package org.future.foodflix.Storage.AsynchTasks;

import android.os.AsyncTask;

import org.future.foodflix.Storage.Database.DatabaseSchema;
import org.future.foodflix.Storage.Database.User;

import java.util.ArrayList;
import java.util.List;

public class ReadDb extends AsyncTask<Void,Void, List<User>> {
    public interface Listener{
        public void onResult(List<User> result);}

    private DatabaseSchema database;
    private Listener listener;

    public ReadDb(DatabaseSchema database, Listener listener) {
        this.database = database;
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<User> doInBackground(Void... voids) {
        try{
            return database.getUserDao().read();
        }catch(Exception exception){
            return new ArrayList<>();
        }
    }

    @Override
    protected void onPostExecute(List<User> userEntities) {
        super.onPostExecute(userEntities);
        listener.onResult(userEntities);
    }
}
