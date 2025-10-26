package app;

import io.ReaderWriter;
import java.io.IOException;
import java.util.Scanner;

//тестовая сборка
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("...Шифратор Soft by Andrey...");
        System.out.println("Выберите режим");
        System.out.println("1 - Шифровка файла");
        System.out.println("2 - Расшифровка файла");
        System.out.println("3 - BruteForce");
        int choice = scanner.nextInt();
        scanner.nextLine(); //очистка буфера

        System.out.println("Введите путь исходного файла: ");
        String inputPath = scanner.nextLine();

        System.out.println("Введите куда сохранять файл результата с указанием имени файла в его формате: ");
        System.out.println("\u001B[31m" + "Внимание! Если вы не введёте директорию, то файл будет сохранён в корень проекта");

        String outputPath = scanner.nextLine();
        int key = 0;
        if (choice == 1 || choice == 2){
            System.out.println("Введите ключ: ");
            key = scanner.nextInt();
        }

        try{
        if (choice == 1){
            ReaderWriter.encryptFile(inputPath, outputPath, key);
            System.out.println("Файл успешно зашифрован и сохранён в: " + outputPath);
        } else if (choice ==2) {
            ReaderWriter.decryptFile(inputPath, outputPath, key);
            System.out.println("Файл успешно расшифрован и сохранён в: " + outputPath);

        }else if(choice ==3) {
            ReaderWriter.decryptFileBruteForce(inputPath,outputPath);
            System.out.println("Взлом завершён, результат сохранён в: " + outputPath);
        } else {
            System.out.println("Неизвестная ошибка");
        }
        } catch (IOException err){
            System.out.println("Ошибка при работе с файлом " + err.getMessage());
            err.printStackTrace();
        }
    }
}
