package org.future.foodflix.Network.Hints;

public class JsonQualifiedResponse {
    private JsonInQualifiedResponse inQualified;

    public JsonInQualifiedResponse getInQualified() {
        return inQualified;
    }

    public void setInQualified(JsonInQualifiedResponse inQualified) {
        this.inQualified = inQualified;
    }

    @Override
    public String toString() {
        return "JsonQualifiedResponse{" +
                "inQualified=" + inQualified +
                '}';
    }
}
