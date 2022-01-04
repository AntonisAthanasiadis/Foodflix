package org.future.foodflix.Network.Hints;

import java.util.List;

public class JsonInMeasureResponse {
    private String uri;
    private String label;
    private double weight;
    private List<JsonQualifiedResponse> qualified;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public List<JsonQualifiedResponse> getQualified() {
        return qualified;
    }

    public void setQualified(List<JsonQualifiedResponse> qualified) {
        this.qualified = qualified;
    }

    @Override
    public String toString() {
        return "JsonInMeasureResponse{" +
                "uri='" + uri + '\'' +
                ", label='" + label + '\'' +
                ", weight=" + weight +
                ", qualified=" + qualified +
                '}';
    }
}
