package com.ytalogsantos.fileExtensionManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a directory path:");
        String directoryPath = scanner.nextLine();
        Boolean isDirectoryPathValid = PathValidator.validateDirectory(PathValidator.validatePath(directoryPath));

        if (!isDirectoryPathValid) {
            System.out.println("This path isn't valid. Check if the directory actually exists or if it isn't empty.");
        } else {
            System.out.println("This path is valid.");
        }
    }
}
