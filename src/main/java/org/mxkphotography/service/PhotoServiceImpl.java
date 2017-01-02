package org.mxkphotography.service;

import org.mxkphotography.models.Photo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Value("${photos.folder}")
    private String photosFolder;

    @Value("${photos.caption}")
    private String caption;

    @Override
    public List<Photo> getPhotoList() {
        File folder = getPhotosFolder(photosFolder);
        if (canReadDirectory(folder)) {
            return getPhotoList(folder);
        }

        throw new RuntimeException("Unable to access photos");
    }

    private boolean canReadDirectory(File folder) {
        return folder.isDirectory() && folder.canRead();
    }

    private List<Photo> getPhotoList(File folder) {
        File[] files = folder.listFiles();
        if (files == null)
            return new ArrayList<>();

        return Arrays.stream(files)
                .map(File::getName)
                .filter(file -> file.endsWith("jpg"))
                .map(name -> new Photo(name, "/photo/" + name, "100", "100", "1", caption))
                .collect(Collectors.toList());
    }

    private File getPhotosFolder(String photosFolder) {
        return new File(photosFolder);
    }

    @Override
    public File getPhoto(String filename) {
        return new File(photosFolder + filename + ".jpg");
    }
}
