package core;


import util.Alphabet;

public class CaesarCipher {
    private CaesarCipher() {} //  запрещаем создавать новые объекты


    static int normalizeKey(int key) { //Приводим введённое значение к диапазону от 0 до длины алфавита
        int n = Alphabet.size(); // получаем длину алфавита
        int k = key % n;  // находим остаток от деления что бы сделать круг
        return (k < 0) ? k + n : k; //Для умных людей кто захочет ввести минус //Если k < 0 верни n, иначе просто верни k
    }

    static char moveSymbol(char ch, int key) { //реализация сдвига
        int symbolPosition = Alphabet.indexOf(ch); // ищем индекс символа в алфавите
        if (symbolPosition == -1) return ch; // Если символ не найден возвращаем его не ломая текст
        int alphabetSize  = Alphabet.size(); // получаем размер алфавита что бы не выйти за пределы массива
        int newPosition = (symbolPosition + key) % alphabetSize ; //ищем новый символ с учётом сдвига по кругу
        return Alphabet.ALPHABET[newPosition]; // возвращаем символ из нового индекса
    }
    // шифруем строку текста
    public static String encryptText(String text, int key) { //Шифровочка подъехала
        key = normalizeKey(key); //делаем ключ нормальным от 0 до длины алфавита
        StringBuilder result = new StringBuilder(); //Строки не изменяемые, нужен стринг билдер

        for (char ch : text.toCharArray()) { //превращаем строку в массив символов и пребираем по 1 символу за итерацию
            result.append(moveSymbol(ch, key)); //сдвигаем символ
        }
        return result.toString(); //возвращаем готовую шифровочку
    }

    public static String decryptText(String text, int key) { //дешифровочка
        key = normalizeKey(key); //делаем ключ нормальным от 0 до длины алфавита
        StringBuilder result = new StringBuilder(); //Строки опять не изменяемые, нужен стринг билдер, что бы не создавать лишние объекты

        for (char ch : text.toCharArray()) {
            // для расшифровки просто используем обратный сдвиг
            result.append(moveSymbol(ch, -key)); //Просто повторяем шифровку в обратном порядке
        }
        return result.toString(); //Выкидываем расшифрованный текст
    }
}
