package org.future.foodflix.Network.Parsed;


import org.future.foodflix.Network.JsonFoodResponse;

import java.util.List;

public class JsonParseResponse {
    private List<JsonFoodResponse> food;

    public List<JsonFoodResponse> getFood() {
        return food;
    }

    public void setFood(List<JsonFoodResponse> food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "JsonParseResponse{" +
                "food=" + food +
                '}';
    }
}