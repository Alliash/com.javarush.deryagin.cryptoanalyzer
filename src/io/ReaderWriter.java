package io;

import attack.BruteForce;
import core.CaesarCipher; //Для вызова encryptText/decryptText

import java.io.*;

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
    public static void decryptFileBruteForce(String inputPath, String outputPath) throws IOException {
        final int SAMPLE_SIZE = 2000; //Ради ограничения расхода памяти, максимальное число символов читаемых для образца статистики брут форса, можно уменьшить если файл маленький и наоборот
        StringBuilder builder = new StringBuilder(); //копим считанные строки в builder

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) { //построчное чтение файла
            String line; //переменная для строк
            while ((line = reader.readLine()) != null && builder.length() < SAMPLE_SIZE) { //читаем строку или возвращаем null если файл кончится,условие читаем до конца файла либо пока builder не станет >= SAMPLE_SIZE
                builder.append(line.toLowerCase()); // Добавляем прочитанную строку в Builder
                builder.append(' '); // пробел между строками что бы слова в конце строки не сливались в одно слово
            }
        }

        String sample = builder.toString(); //переводим то что накопили в String sample
        if (sample.isEmpty()) { //если то что накопили пустое  выбрасываем ошибку
            throw new IOException("Файл пуст или не доступен для чтения: " + inputPath); //
        }

        // вызов  метода в attack
        int foundKey = BruteForce.FindKey(sample); // перебирает ключи и возвращает лучший по метрике
        System.out.println("Ключ найден: " + foundKey);

        decryptFile(inputPath, outputPath, foundKey); //Читает входной файл, записывает новый с переданным ключём
    }
}
