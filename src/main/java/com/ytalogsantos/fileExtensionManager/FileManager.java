package com.ytalogsantos.fileExtensionManager;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
    public static boolean sortFilesByExtension(Path directoryPath) {
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(directoryPath)) {
            for (Path contentPath : stream) {
                String contentType = Files.probeContentType(contentPath);
                if ("text/plain".equals(contentType)) {
                    System.out.println("Your directory has a text file.");
                    return true;
                }
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return false;
    }
}
