package org.future.foodflix.Network.JsonResponse;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SmallImageResponse implements Serializable {
    private String url;


    @Override
    public String toString() {
        return "SmallImageResponse{" +
                "url='" + url + '\'' +
                '}';
    }


}
