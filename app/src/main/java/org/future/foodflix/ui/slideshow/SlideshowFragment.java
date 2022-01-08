package org.future.foodflix.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputEditText;

import org.future.foodflix.R;
import org.future.foodflix.ui.main.MainViewModel;

public class SlideshowFragment extends Fragment {
    public String URLrecipe;
    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                         ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_slideshow, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        URLrecipe = "https://api.edamam.com/api/recipes/v2?" +
                "type=public" +
                "&q=";
        //app_id=c0bb7b58&app_key=ad2b9082c4731f6b6a1e4193b90607e7&diet=high-protein&health=low-fat-abs+
        String app_id_key = "app_id=c0bb7b58&app_key=ad2b9082c4731f6b6a1e4193b90607e7";

        slideshowViewModel = new ViewModelProvider(this).get(SlideshowViewModel.class);
        Button foodSearch = view.findViewById(R.id.recipeSearchBtn);
        foodSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText foods = v.findViewById(R.id.recipeFragInput);
                String food = foods.getText().toString();
                String[] Foods = food.split(",");
                String q = "&q=";
                for (String i : Foods) {
                    q += i + "%2C";
                }
                URLrecipe += q + app_id_key;

                CheckBox vegetarian = v.findViewById(R.id.checkVegetarian);
                CheckBox vegan = v.findViewById(R.id.checkVegan);
                CheckBox low_fat = v.findViewById(R.id.checkLowFat);
                CheckBox high_protein = v.findViewById(R.id.checkHighProtein);
                CheckBox gluten = v.findViewById(R.id.checkGluten);
                CheckBox immune = v.findViewById(R.id.checkImmunoSupportive);
                CheckBox wheat = v.findViewById(R.id.checkWheat);
                CheckBox shellfish = v.findViewById(R.id.checkShellfish);

                CheckBox[] Diet = {low_fat, high_protein};
                CheckBox[] Health = {vegetarian, vegan, gluten, wheat, immune, shellfish};

                for (CheckBox c : Diet) {
                    URLrecipe = slideshowViewModel.Checked(URLrecipe, "&diet=", c);
                }

                for (CheckBox c : Health) {
                    URLrecipe = slideshowViewModel.Checked(URLrecipe, "&health=", c);
                }
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }



    @Override
    public void onStart() {
        super.onStart();
    }


    @Override
    public void onResume() {
        super.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}