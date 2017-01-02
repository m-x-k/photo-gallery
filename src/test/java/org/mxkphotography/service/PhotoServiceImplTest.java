package org.mxkphotography.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class PhotoServiceImplTest {

    @Test
    public void testGetPhotoList() throws Exception {

        PhotoService photoService = new PhotoServiceImpl();
        photoService.getPhotoList();

    }
}