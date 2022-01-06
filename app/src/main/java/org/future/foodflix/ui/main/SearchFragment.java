package org.future.foodflix.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.TextInputEditText;

import org.future.foodflix.R;
import org.future.foodflix.ui.slideshow.SlideshowFragment;

public class SearchFragment extends Fragment {
    public String URLfood;
    private MainViewModel mViewModel;

    public SearchFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        URLfood = "https://api.edamam.com/api/food-database/v2/parser?" +
                "app_id=c0bb7b58"+
                "&app_key=ad2b9082c4731f6b6a1e4193b90607e7";

        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        Button foodSearch = view.findViewById(R.id.FoodSearchBtn);
        foodSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText foods = v.findViewById(R.id.foodFragInput);
                String food= foods.getText().toString();
                String[] Foods= food.split(",");
                String ingr= "&ingr=";
                for (String i:Foods){
                    ingr+=i+"%2C";
                }
                URLfood+=ingr;

            }
        });

    }


    @Override
    public void onDestroy() {
    super.onDestroy();
}

//    public SearchFragment() {
//    }
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.main_fragment, container, false);
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//}
//
//
//
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // TODO: Use the ViewModel
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
}