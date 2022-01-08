package org.future.foodflix.Network.Hints;

public class JsonMeasuresResponse {
    private JsonInMeasureResponse inMeasure;

    public JsonInMeasureResponse getInMeasure() {
        return inMeasure;
    }

    public void setInMeasure(JsonInMeasureResponse inMeasure) {
        this.inMeasure = inMeasure;
    }

    @Override
    public String toString() {
        return "JsonMeasuresResponse{" +
                "inMeasure=" + inMeasure +
                '}';
    }
}
