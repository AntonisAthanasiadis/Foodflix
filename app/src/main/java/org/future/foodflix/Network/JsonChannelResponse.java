package org.future.foodflix.Network;

import java.util.List;

import lombok.Data;

@Data
public class JsonChannelResponse {

    private List<JsonShowResponse> shows;
    private String channelName;


    @Override
    public String toString() {
        return "JsonChannelResponse{" +
                "shows=" + shows +
                ", channelName='" + channelName + '\'' +
                '}';
    }
}
