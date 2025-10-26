package app;

import constants.AppConstants;
import io.ReaderWriter;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println(AppConstants.WELCOME);
        System.out.println(AppConstants.MENU);
        System.out.println(AppConstants.MENU_ENCRYPT);
        System.out.println(AppConstants.MENU_DECRYPT);
        System.out.println(AppConstants.MENU_BRUTE_FORCE);
        System.out.println(AppConstants.EXIT);

        Scanner scanner = new Scanner(System.in);

        int choice = -1;

        while (choice <0 || choice > 3) {
            if (!scanner.hasNextInt()){
                System.out.println(AppConstants.ERROR_INPUT);
                scanner.nextLine();
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice < 0 || choice > 3){
                System.out.println(AppConstants.ERROR_INPUT);
            }
        }

        if (choice == 0){
            System.out.println(AppConstants.EXIT_SUCCESS);
            scanner.close();
            System.exit(0);
        }

        System.out.println(AppConstants.INPUT_PATH);
        String inputPath = scanner.nextLine();
        System.out.println(AppConstants.OUTPUT_PATH);
        System.out.println(AppConstants.WARNING);
        String outputPath = scanner.nextLine();

        int key = 0;
        if (choice == 1 || choice == 2) {
            System.out.print(AppConstants.KEY);
            while (!scanner.hasNextInt()) {
                System.out.println(AppConstants.ERROR_KEY);
                scanner.nextLine();
                System.out.print(AppConstants.KEY);
            }
            key = scanner.nextInt();
            scanner.nextLine();
        }

        try {
            if (choice == 1) {
                ReaderWriter.cryptFile(inputPath, outputPath, key, true);
                System.out.println(AppConstants.ENCRYPT_SUCCESS + outputPath);
            } else if (choice == 2) {
                ReaderWriter.cryptFile(inputPath, outputPath, key, false);
                System.out.println(AppConstants.DECRYPT_SUCCESS + outputPath);

            } else if (choice == 3) {
                ReaderWriter.decryptFileBruteForce(inputPath, outputPath);
                System.out.println(AppConstants.BRUTE_FORCE_SUCCESS + outputPath);
            } else {
                System.out.println(AppConstants.UNKNOWN_ERROR);
            }
        } catch (IOException err) {
            System.out.println(AppConstants.FILE_ERROR + err.getMessage());
            err.printStackTrace();
        }
    }
}
