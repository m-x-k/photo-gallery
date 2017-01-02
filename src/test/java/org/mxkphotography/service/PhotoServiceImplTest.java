package org.mxkphotography.service;

import org.junit.Test;
import org.mxkphotography.models.Photo;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PhotoServiceImplTest {

    @Test
    public void testGetPhotoList() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String photosFolder = classLoader.getResource("photos").getFile();

        PhotoServiceImpl photoService = new PhotoServiceImpl();
        ReflectionTestUtils.setField(photoService, "photosFolder", photosFolder);
        ReflectionTestUtils.setField(photoService, "caption", "test");
        List<Photo> photoList = photoService.getPhotoList();

        String name = "stairs.jpg";
        Photo photo = new Photo(name, "/photo/" + name, "100", "100", "1", "test");
        ArrayList expectedPhotoList = new ArrayList();
        expectedPhotoList.add(photo);
        assertEquals(expectedPhotoList, photoList);
    }
}