package io;

import core.CaesarCipher; //Для вызова encryptText/decryptText

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public final class ReaderWriter { //запрещаем наследоваться
    private ReaderWriter() {} //запрещаем создавать всякие новые new Reader Writer


    public static void encryptFile(String inputPath, String outputPath, int key) throws IOException { //Шифровка файла
        convertFile(inputPath, outputPath, key, true);
    }

    public static void decryptFile(String inputPath, String outputPath, int key) throws IOException { //дешифровка файла
        convertFile(inputPath, outputPath, key, false);
    }

    private static void convertFile(String inputPath, String outputPath, int key, boolean encrypt) throws IOException { // читаем строку - конвертируем - записываем //Boolean отвечает за выбор режима

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

            String line; // Сюда по очереди читаем строки исходного файла
            while ((line = reader.readLine()) != null) { //читаем построчно пока не закончится

                String lower = line.toLowerCase(); //Приводим алфавит к нижнему регистру

                String transformed; // конвертация строки
                if (encrypt) {
                    transformed = CaesarCipher.encryptText(lower, key);
                } else {
                    transformed = CaesarCipher.decryptText(lower, key);
                }

                writer.write(transformed); //пишем строку в аутпут файл
                writer.newLine(); //перекидываемся на новую строку
            }
        }
    }
}
