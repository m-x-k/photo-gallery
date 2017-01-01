package org.mxkphotography.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mxkphotography.models.Photo;
import org.mxkphotography.service.PhotoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.http.HttpStatus.OK;

public class PhotoControllerTest {

    @InjectMocks
    private PhotoController photoController;

    @Mock
    private PhotoService photoService;

    @Before
    public void setup() {
        initMocks(this);
    }

    @Test
    public void testGetPhotoList() throws Exception {
        List<Photo> expected = new ArrayList<>();
        expected.add(new Photo("photo1", "http://localhost/photo1", "100", "100", "1", "caption"));
        expected.add(new Photo("photo2", "http://localhost/photo2", "100", "100", "1", "caption"));
        expected.add(new Photo("photo3", "http://localhost/photo3", "100", "100", "1", "caption"));

        when(photoService.getPhotoList()).thenReturn(expected);

        ResponseEntity<List<Photo>> responseEntity = photoController.getPhotoList();

        assertEquals(OK, responseEntity.getStatusCode());
        assertEquals(expected, responseEntity.getBody());
    }
}