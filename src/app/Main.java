package app;

import core.CaesarCipher;
import io.ReaderWriter;
import java.io.IOException;
import javax.imageio.IIOException;
import java.util.Scanner;

//тестовая сборка
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("...Шифратор Soft by Andrey...");
        System.out.println("Выберите режим");
        System.out.println("1 - Шифровка файла");
        System.out.println("2 - Расшифровка файла");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите путь исходного файла: ");
        String inputPath = scanner.nextLine();
        System.out.println("Введите куда сохранять файл результата с указанием имени файла в его формате");
        String outputPath = scanner.nextLine();
        System.out.println("Введите ключ: ");
        int key = scanner.nextInt();

        try{
        if (choice == 1){
            ReaderWriter.encryptFile(inputPath, outputPath, key);
            System.out.println("Файл успешно зашифрован и сохранён в: " + outputPath);
        } else if (choice ==2) {
            ReaderWriter.decryptFile(inputPath, outputPath, key);
            System.out.println("Файл успешно расшифрован и сохранён в: " + outputPath);
        }else {
            System.out.println("Неизвестная ошибка");
        }
        } catch (IOException err){
            System.out.println("Ошибка при работе с файлов" + err.getMessage());
        }
    }
}



