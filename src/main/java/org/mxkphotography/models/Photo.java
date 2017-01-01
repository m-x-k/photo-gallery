package org.mxkphotography.models;

public class Photo {

    private String name;
    private String url;
    private String height;
    private String length;
    private String aspectRatio;
    private String caption;

    public Photo(String name, String url, String height, String length, String aspectRatio, String caption) {
        this.name = name;
        this.url = url;
        this.height = height;
        this.length = length;
        this.aspectRatio = aspectRatio;
        this.caption = caption;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getHeight() {
        return height;
    }

    public String getLength() {
        return length;
    }

    public String getAspectRatio() {
        return aspectRatio;
    }

    public String getCaption() {
        return caption;
    }


}
