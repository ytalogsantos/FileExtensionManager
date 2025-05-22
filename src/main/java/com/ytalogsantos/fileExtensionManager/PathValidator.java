package com.ytalogsantos.fileExtensionManager;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public final class PathValidator {

    public static Path validatePath(String inputPath) {
        try {
            return Path.of(inputPath);
        } catch (InvalidPathException exception) {
            System.out.println("Invalid Input path.");
            return null; // I don't know if it's right to do this, but for now that's it.
        }
    }

    public static Boolean validateDirectoryPath(Path directoryPath) {

        if (!Files.exists(directoryPath)) return false;
        if (!Files.isDirectory(directoryPath)) return false;

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directoryPath)) {
            if (!stream.iterator().hasNext()) return false;
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        return true;
    }

}
