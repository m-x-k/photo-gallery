package org.mxkphotography.utils;

import com.google.common.io.ByteStreams;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileUtils {

    public static byte[] getBytes(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        return ByteStreams.toByteArray(fileInputStream);
    }

}
