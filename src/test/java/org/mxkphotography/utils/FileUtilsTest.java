package org.mxkphotography.utils;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class FileUtilsTest {
    @Test
    public void getBytes() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        String file = classLoader.getResource("photos/stairs.jpg").getFile();
        byte[] bytes = FileUtils.getBytes(new File(file));
        assertNotNull(bytes);
    }

}