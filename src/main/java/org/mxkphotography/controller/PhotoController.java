package org.mxkphotography.controller;

import org.mxkphotography.models.Photo;
import org.mxkphotography.service.PhotoService;
import org.mxkphotography.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.List;

@Controller
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @RequestMapping("/photo/list")
    @ResponseBody
    public ResponseEntity<List<Photo>> getPhotoList() {
        List<Photo> photoList = photoService.getPhotoList();
        return new ResponseEntity<>(photoList, HttpStatus.OK);
    }

    @RequestMapping(value = "/photo/{fileName}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> getPhoto(@PathVariable String fileName) throws Exception {
        File file = photoService.getPhoto(fileName);
        byte[] bytes = FileUtils.getBytes(file);
        return ResponseEntity.ok()
                .contentLength(file.length())
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }
}
