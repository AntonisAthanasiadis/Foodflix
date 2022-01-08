package org.future.foodflix;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.future.foodflix.Storage.AsynchTasks.ReadDb;
import org.future.foodflix.Storage.Database.DatabaseSchema;
import org.future.foodflix.Storage.Database.User;

import java.util.List;

public class SeeDatabaseActivity extends AppCompatActivity {

    @Nullable
    private DatabaseSchema db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_database);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        db = Room.databaseBuilder(SeeDatabaseActivity.this, DatabaseSchema.class,"foodflix").build();
        Button see = findViewById(R.id.show);
        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ReadDb(db, new ReadDb.Listener() {
                    @Override
                    public void onResult(List<User> result) {
                        final String[] s= {""};
                        int Size = result.size();
                        int i = 0;
                        for (User u:result){
                            s[i]= u.getId()+
                                    " "+u.getUsername()+
                                    " "+u.getPassword()+"\n";
                            i++;
                        }

                        String S= "";
                        for (String g: s){
                            S+=g+"\n";
                        }
                        TextView see = findViewById(R.id.see);
                        see.setText(S);
                    }
                }).execute();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
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
}