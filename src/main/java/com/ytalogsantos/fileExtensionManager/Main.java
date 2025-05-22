package com.ytalogsantos.fileExtensionManager;

import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a directory path:");
        String inputPath = scanner.nextLine();
        Path directoryPath = PathValidator.validatePath(inputPath);
        Boolean isDirectoryPathValid = PathValidator.validateDirectoryPath(directoryPath);

        if (!isDirectoryPathValid) {
            System.out.println("This path isn't valid. Check if the directory actually exists or if it isn't empty.");
        } else {
            FileManager.sortFileByExtension(directoryPath);
        }


    }
}
