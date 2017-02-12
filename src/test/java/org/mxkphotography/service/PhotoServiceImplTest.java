package org.mxkphotography.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.mxkphotography.models.Photo;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PhotoServiceImplTest {

    private PhotoServiceImpl photoService = new PhotoServiceImpl();

    @Test
    public void getPhotoList() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String photosFolder = classLoader.getResource("photos").getFile();

        ReflectionTestUtils.setField(photoService, "photosFolder", photosFolder);
        ReflectionTestUtils.setField(photoService, "caption", "test");
        List<Photo> photoList = photoService.getPhotoList();

        String name = "stairs.jpg";
        Photo photo = new Photo(name, "/photo/" + name, "100", "100", "1", "test");
        ArrayList expectedPhotoList = new ArrayList();
        expectedPhotoList.add(photo);
        assertEquals(expectedPhotoList, photoList);
    }

    @Test(expected = RuntimeException.class)
    public void getPhotoListUnableToAccessPhotos() throws Exception {
        ReflectionTestUtils.setField(photoService, "photosFolder", "unknownXZY");
        photoService.getPhotoList();
    }

    @Test
    public void getPhotoListEmpty() throws Exception {
        ReflectionTestUtils.setField(photoService, "photosFolder", folder.newFolder().getAbsolutePath());
        List<Photo> photoList = photoService.getPhotoList();
        assertEquals(new ArrayList(), photoList);
    }

    @Test
    public void getPhoto() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String photosFolder = classLoader.getResource("photos").getFile();

        ReflectionTestUtils.setField(photoService, "photosFolder", photosFolder);
        ReflectionTestUtils.setField(photoService, "caption", "test");
        File photo = photoService.getPhoto("stairs");
        assertTrue(photo.exists());
    }

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

}