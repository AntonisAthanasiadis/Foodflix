package org.future.foodflix.Storage.AsynchTasks;

import android.os.AsyncTask;

import org.future.foodflix.Storage.Database.DatabaseSchema;
import org.future.foodflix.Storage.Database.User;

public class InsertDb extends AsyncTask<User,Void,Boolean> {
    public interface Listener{
        public void onResult(boolean result);}

    private DatabaseSchema database;
    private Listener listener;

    public InsertDb(DatabaseSchema database, Listener listener) {
        this.database = database;
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(User... userEntities) {
        try{
            for(User user: userEntities){
                database.getUserDao().save(user);
            }
            return true;
        }catch(Exception exception){
            return false;}
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        listener.onResult(aBoolean);
    }
}
