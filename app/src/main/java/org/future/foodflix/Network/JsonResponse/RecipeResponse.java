package org.future.foodflix.Network.JsonResponse;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RecipeResponse implements Serializable {

    private String label;
    private ImagesResponse images;
    private float calories;
    private ArrayList<String> ingredientLines;


    @Override
    public String toString() {
        return "RecipeResponse{" +
                "label='" + label + '\'' +
                ", images=" + images +
                ", calories=" + calories +
                '}';
    }


}
