package com.thoughtworks.iamcoach.pos.utils;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileUtils {

    private static Properties properties = new Properties();

    public static List<String> get (String filename) throws IOException {

        String filepath = FileUtils.class.getClassLoader().getResource(filename).getPath();
        Path path = FileSystems.getDefault().getPath(filepath);

        return Files.readAllLines(path);
    }

    public static String getValue(String user) throws IOException {

        InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream("pos.properties");
        properties.load(inputStream);

        return properties.getProperty(user);
    }
}
