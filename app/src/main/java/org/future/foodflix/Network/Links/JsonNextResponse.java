package org.future.foodflix.Network.Links;

public class JsonNextResponse {
    private String title;
    private String href;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return "JsonNextResponse{" +
                "title='" + title + '\'' +
                ", href='" + href + '\'' +
                '}';
    }
}
