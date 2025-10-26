package constants;

public interface AppConstants {
    String RED_TEXT = "\u001B[31m";
    String RED_RESET = "\u001B[0m";


    String WELCOME = "...Шифратор Soft by Andrey...";
     String MENU = "\"Выберите режим\"";
     String MENU_ENCRYPT = "1 - Шифровка файла";
     String MENU_DECRYPT = "2 - Расшифровка файла";
     String MENU_BRUTE_FORCE = "3 - BruteForce";
     String INPUT_PATH = "Введите путь исходного файла: ";
     String OUTPUT_PATH = "Введите куда сохранять файл результата с указанием имени файла в его формате: ";
     String KEY = "Введите ключ: ";
     String EXIT = "0 - Выход из программы";
     String EXIT_SUCCESS = "Выход из программы, До свидания!";
     String ERROR_INPUT = "Ошибка: введите число от 0 до 3.";
     String ERROR_KEY = "Ошибка: введите целое число";


     //результаты выполнения
     String ENCRYPT_SUCCESS = "Файл успешно зашифрован и сохранён в: ";
     String DECRYPT_SUCCESS = "Файл успешно расшифрован и сохранён в: ";
     String BRUTE_FORCE_SUCCESS = "Взлом завершён, результат сохранён в: ";
     String UNKNOWN_ERROR = "Неизвестная ошибка";
     String FILE_ERROR = "Ошибка при работе с файлами: ";

     String WARNING = RED_TEXT + "Внимание! Если вы не введёте директорию, то файл будет сохранён в корень проекта" + RED_RESET;
}
