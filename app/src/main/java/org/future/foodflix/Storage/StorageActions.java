package org.future.foodflix.Storage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.google.android.material.textfield.TextInputEditText;

import org.future.foodflix.CheckActions;
import org.future.foodflix.R;
import org.future.foodflix.Storage.AsynchTasks.InsertDb;
import org.future.foodflix.Storage.Database.DatabaseSchema;
import org.future.foodflix.Storage.Database.User;

public class StorageActions extends AppCompatActivity {
    @NonNull
    private DatabaseSchema database;

//    TextInputEditText username = findViewById(R.id.regUser);
//    String Username = String.valueOf(username);
//    TextInputEditText name = findViewById(R.id.regFirst);
//    String Name = String.valueOf(name);
//    TextInputEditText surname = findViewById(R.id.regLast);
//    String Surname = String.valueOf(surname);
//    TextInputEditText password = findViewById(R.id.regPass1);
//    String Password = String.valueOf(password);
//    TextInputEditText valPass = findViewById(R.id.regPass2);
//    String Valpass = String.valueOf(valPass);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        DatabaseSchema database = Room.databaseBuilder(StorageActions.this, DatabaseSchema.class, "Foodflix/'s Users").build();
        Button SignUpBtn = findViewById(R.id.signUp);

        SignUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText User = findViewById(R.id.regUser);
                String newUser = User.getText().toString();

                TextInputEditText name = findViewById(R.id.regFirst);
                String firstName = name.getText().toString();

                TextInputEditText Lname = findViewById(R.id.regLast);
                String lastName = Lname.getText().toString();

                TextInputEditText p1 = findViewById(R.id.regPass1);
                String pass1 = p1.getText().toString();

                TextInputEditText p2 = findViewById(R.id.regPass2);
                String pass2 = p2.getText().toString();

                CheckActions check = new CheckActions();
                String eval = check.eval(pass1, pass2, newUser, firstName, lastName);

                if (eval.equals("Created new account successfully!")) {
                    User user = new User(newUser, firstName, lastName, pass1);
                    new InsertDb(database, new InsertDb.Listener() {
                        @Override
                        public void onResult(boolean result) {
                            Toast.makeText(StorageActions.this, "Hello " + firstName + "! \n Welcome to Foodflix!", Toast.LENGTH_SHORT).show();
                        }
                    }).execute(user);
                }
            }
        });
        Button LoginBtn = findViewById(R.id.loginbtn);

    }
    @Override
    protected void onPostResume() {
        super.onPostResume();
    }
}
