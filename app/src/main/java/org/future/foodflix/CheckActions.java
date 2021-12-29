package org.future.foodflix;

import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.room.Room;

import com.google.android.material.textfield.TextInputEditText;

import org.future.foodflix.Storage.Database.DatabaseSchema;

public class CheckActions {


    public String eval(String pass1, String pass2,String newUser, String firstName, String lastName){
        if (pass1.length()<6){
            return "Password is too short";
        }
        else if(newUser.length()>20 || pass1.length()>20 || firstName.length()>20 || lastName.length()>20)
            return "A maximum of 20 characters is accepted!";

        else if (!pass1.equals(pass2)){
            return "Passwords dismatch";
        }
        else if (newUser.equals("") || firstName.equals("") || lastName.equals("") || pass1.equals("") ||pass2.equals("")){
            return "Please fill all the required fields!";
        }
        else{
            return "Created new account successfully!";
        }
    }
}
