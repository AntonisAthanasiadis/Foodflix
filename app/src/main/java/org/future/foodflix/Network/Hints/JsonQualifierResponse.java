package org.future.foodflix.Network.Hints;

public class JsonQualifierResponse {
    private String uri;
    private String label;

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

    @Override
    public String toString() {
        return "JsonQualifierResponse{" +
                "uri='" + uri + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
