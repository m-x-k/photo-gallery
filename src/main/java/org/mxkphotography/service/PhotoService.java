package org.mxkphotography.service;

import org.mxkphotography.models.Photo;

import java.io.File;
import java.util.List;

public interface PhotoService {

    List<Photo> getPhotoList();

    File getPhoto(String filename);

}
