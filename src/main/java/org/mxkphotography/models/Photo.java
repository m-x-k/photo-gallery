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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Photo photo = (Photo) o;

        if (name != null ? !name.equals(photo.name) : photo.name != null) return false;
        if (url != null ? !url.equals(photo.url) : photo.url != null) return false;
        if (height != null ? !height.equals(photo.height) : photo.height != null) return false;
        if (length != null ? !length.equals(photo.length) : photo.length != null) return false;
        if (aspectRatio != null ? !aspectRatio.equals(photo.aspectRatio) : photo.aspectRatio != null) return false;
        return caption != null ? caption.equals(photo.caption) : photo.caption == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (aspectRatio != null ? aspectRatio.hashCode() : 0);
        result = 31 * result + (caption != null ? caption.hashCode() : 0);
        return result;
    }
}
