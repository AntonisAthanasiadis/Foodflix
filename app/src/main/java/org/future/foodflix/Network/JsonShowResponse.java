package org.future.foodflix.Network;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JsonShowResponse {

    private int endTime;
    private String title;
    private int startTime;
    private String endTimeCaption;
    private String startTimeCaption;


    @Override
    public String toString() {
        return "JsonShowResponse{" +
                "endTime=" + endTime +
                ", title='" + title + '\'' +
                ", startTime=" + startTime +
                ", endTimeCaption='" + endTimeCaption + '\'' +
                ", startTimeCaption='" + startTimeCaption + '\'' +
                '}';
    }
}