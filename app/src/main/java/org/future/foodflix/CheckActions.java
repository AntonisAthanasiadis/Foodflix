package org.future.foodflix;

import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.room.Room;

import com.google.android.material.slider.RangeSlider;
import com.google.android.material.textfield.TextInputEditText;

import org.future.foodflix.Storage.Database.DatabaseSchema;

import java.util.List;

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
    public static String ingredients(String string){
        String[] strings = string.split(",");
        String s="";
        for (String str:strings){
            s+=str.toLowerCase().trim();
            s+="%2C";
        }
        s=s.substring(0,s.length()-3);
        return s;
    }

    public static String Checked(CheckBox[] checkBoxes){
        String s = "";
        for (CheckBox checkBox:checkBoxes){
            if (checkBox.isChecked()){
                s+="&health=";
                s+=checkBox.getText().toString();
            }
        }
        return s;
    }

    public static String calories(RangeSlider slider, String[] s) {
        List<Float> values = slider.getValues();
        s[0] = "";
        for (float f : values) {
            s[0] += String.valueOf((int) f);
            s[0] += "-";
        }
        s[0] = s[0].substring(0, s[0].length() - 1);
        return s[0];
    }
}
