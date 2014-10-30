package com.thoughtworks.iamcoach.pos.utils;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileUtils {

    public static List<String> get (String filename) throws IOException {

        String filepath = FileUtils.class.getClassLoader().getResource(filename).getPath();
        Path path = FileSystems.getDefault().getPath(filepath);

        return Files.readAllLines(path);
    }

    public static String getValue(String user) {
        return null;
    }
}
