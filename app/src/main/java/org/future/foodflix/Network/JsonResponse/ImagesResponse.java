package org.future.foodflix.Network.JsonResponse;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ImagesResponse implements Serializable {
    private SmallImageResponse SMALL;

    @Override
    public String toString() {
        return "ImagesResponse{" +
                "SMALL=" + SMALL +
                '}';
    }


}
