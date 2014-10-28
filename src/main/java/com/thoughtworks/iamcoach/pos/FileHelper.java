package com.thoughtworks.iamcoach.pos;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileHelper {

    public static List<String> get (String filename) throws IOException {

        String filepath = FileHelper.class.getClassLoader().getResource(filename).getPath();
        Path path = FileSystems.getDefault().getPath(filepath);

        return Files.readAllLines(path);
    }
}
