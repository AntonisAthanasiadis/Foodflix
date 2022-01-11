package org.future.foodflix.Network.JsonResponse;


import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class JsonResponse implements Serializable {

    private List<HitsResponse> hits;


    @Override
    public String toString() {
        return "JsonReponse{" +
                "hits=" + hits +
                '}';
    }


}
