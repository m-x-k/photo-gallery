package org.mxkphotography.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mxkphotography.models.Photo;
import org.mxkphotography.service.PhotoService;
import org.mxkphotography.utils.FileUtils;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.springframework.http.HttpStatus.OK;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FileUtils.class)
public class PhotoControllerTest {

    @InjectMocks
    private PhotoController photoController;

    @Mock
    private PhotoService photoService;

    @Before
    public void setup() {
        initMocks(this);
        mockStatic(FileUtils.class);
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

    @Test
    public void testGetPhoto() throws Exception {
        String filename = "test";

        File file = mock(File.class);
        byte[] expectedBytes = "random".getBytes();
        when(FileUtils.getBytes(file)).thenReturn(expectedBytes);
        when(photoService.getPhoto(filename)).thenReturn(file);

        ResponseEntity<byte[]> responseEntity = photoController.getPhoto(filename);
        byte[] bytes = responseEntity.getBody();
        HttpStatus statusCode = responseEntity.getStatusCode();

        assertTrue(statusCode.is2xxSuccessful());
        assertEquals(expectedBytes, bytes);
    }

    @Test
    public void photo() {
        Photo photo = new Photo("name", "url", "height", "length", "aspectRatio", "caption");
        assertEquals(photo.getAspectRatio(), "aspectRatio");
        assertEquals(photo.getCaption(), "caption");
        assertEquals(photo.getHeight(), "height");
        assertEquals(photo.getLength(), "length");
        assertEquals(photo.getName(), "name");
        assertEquals(photo.getUrl(), "url");

        assertEquals(photo, photo);
    }

}