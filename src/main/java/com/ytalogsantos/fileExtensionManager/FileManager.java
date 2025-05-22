package com.ytalogsantos.fileExtensionManager;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
    public static void sortFileByExtension(Path directoryPath) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directoryPath)) {
            for (Path filePath : stream) {
                if (Files.isDirectory(filePath)) {
                    continue;
                }
                String contentType = Files.probeContentType(filePath);
                if ("text/plain".equals(contentType)) {
                    manageFileType(directoryPath, filePath, "/txt");
                    return;
                }

                if ("image/jpeg".equals(contentType)) {
                    manageFileType(directoryPath, filePath, "/jpg");
                    return;
                }

                if ("image/png".equals(contentType)) {
                    manageFileType(directoryPath, filePath, "/png");
                    return;
                }

                if ("application/pdf".equals(contentType)) {
                    manageFileType(directoryPath, filePath, "/pdf");
                    return;
                }
                manageFileType(directoryPath, filePath, "/others");
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void manageFileType(Path directoryPath, Path filePath, String folderName) {
        String newDirectoryPath = directoryPath.toString() + folderName;
        try {
            Path newDirectory = Path.of(newDirectoryPath);
            if (!Files.exists(newDirectory)) {
                Files.createDirectory(newDirectory);
            }

            Files.move(filePath, newDirectory.resolve(filePath.getFileName()));
            System.out.println("File moved successfully.");
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
