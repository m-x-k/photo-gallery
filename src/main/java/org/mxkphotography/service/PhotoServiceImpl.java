package org.mxkphotography.service;

import org.mxkphotography.models.Photo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Value("${photos.folder}")
    private String photosFolder = "/opt/mxkphotography/photos/";

    @Override
    public List<Photo> getPhotoList() {
        List<Photo> photoList = new ArrayList<>();
        File folder = new File(photosFolder);
        if (folder.isDirectory() && folder.canRead()) {
            for (File file : folder.listFiles()) {
                String name = file.getName();
                photoList.add(new Photo(name, "http://localhost:8081/photo/" + name, "100", "100", "1", "MXK Photos"));
            }
        }

        return photoList;
    }

    @Override
    public File getPhoto(String filename) {
        return new File(photosFolder + filename + ".jpg");
    }
}
