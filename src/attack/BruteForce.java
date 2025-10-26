package attack;

import core.CaesarCipher;
import util.Alphabet;

public final class BruteForce { // я запрещаю вам наследоваться
    private BruteForce(){} //приватный конструктор, никаких новых объектов

    public static int findKey(String fragment){
        int bestKey = 0; //лучший ключ
        int bestScore = Integer.MIN_VALUE; //что бы первая проверка победила

        for (int key = 0; key < Alphabet.size(); key++) { //перебираем все ключи от 0 до размера алфавита
            String candidate = CaesarCipher.decryptText(fragment, key); //пробуем расшифровать (этот текст и правда читается)
            int score = calculateLanguageScore(candidate); // оценка насколько текст похож на русский
            if (score > bestScore) { //Если текущая оценка лучше, то присваем её
                bestScore = score;
                bestKey = key;
            }
        }
        return bestKey;
    }

    private static int calculateLanguageScore(String text){ //метод насколько текст похож на русский, чем выше тем лучше основанный на эмпирической метрике
        int score = 0; //счётчик
        //умножение зависит от того на сколько часто используется символ в языке //пример часто встречается '.', если встретилось 3 раза, то 3*count = 12 очков
        //самый частые знаки
        score += count(text, " "); //считаем число пробелов
        score += 2 * count(text, ", ");
        score += 3 * count(text, ". ");
        score += 2 * count(text, "! ");
        score += 2 * count(text, "? ");
        //самые частые короткие слова
        score += 4 * count(text, " и ");
        score += 3 * count(text, " в ");
        score += 3 * count(text, " на ");
        score += 3 * count(text, " не ");
        score += 3 * count(text, " по ");
        score += 3 * count(text, " к ");

        for (char ch : text.toCharArray()){ //цикл по всем символам, если символ есть в нашем алфавите даём +1 за каждый символ убираем мусор
            if (Alphabet.indexOf(ch) >= 0){
                score++;
            }
        }
        return score;
    }

    private static int count(String text, String pattern){ //Счётчик сколько раз внутри строки встречается определённая строка
        int c = 0; //счётчик вхождений
        int from = 0; //с какого индекса ищем дальше
        while (true){ //ищем вхождения пока не кончатся
            int i = text.indexOf(pattern, from); //ищем первую позицию pattern в text начиная с from, если не найдено вернёт -1
            if (i == -1){ // если вхождений больше нет выходим из цикла
                break;
            }
            c++; // нашли вхождение, увеличиваем счётчик
            from = i + pattern.length(); //Двигаем указатель после найденного вхождения что бы не зациклиться
        }
        return c; //Возвращаем кол-во найденных вхождений
    }
    }
