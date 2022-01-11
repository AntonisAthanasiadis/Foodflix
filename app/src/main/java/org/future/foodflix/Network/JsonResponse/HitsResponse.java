package org.future.foodflix.Network.JsonResponse;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class HitsResponse implements Serializable {

    private RecipeResponse recipe;


    @Override
    public String toString() {
        return "HitsResponse{" +
                "recipe=" + recipe +
                '}';
    }
}
