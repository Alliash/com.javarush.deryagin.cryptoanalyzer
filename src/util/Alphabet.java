package util;

import java.util.HashMap;
import java.util.Map;

public final class Alphabet { // запрещаем наследоваться что бы никто не создал новый объект
    private Alphabet(){} // запрещаем создавать новые объекты, никаких новых буковок
    public static final char[] ALPHABET = { 'а','б','в','г','д','е','ё','ж','з',
                                            'и','й','к','л','м','н','о','п','р',
                                            'с','т','у', 'ф','х','ц','ч','ш','щ',
                                            'ъ','ы','ь','э','ю','я','.', ',', '«',
                                            '»', '"', '\'', ':', '-', '!', '?', ' ',
                                            '0','1','2','3','4','5','6','7','8','9'};

    public static final Map<Character, Integer> INDEX;

    static {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ALPHABET.length; i++) {
            map.put(ALPHABET[i], i);
        }
        INDEX = Map.copyOf(map); // делает неизменяемую копию
    }

    public static int indexOf(char ch) {
        return INDEX.getOrDefault(ch, -1);
    }

    public static int size() {
        return ALPHABET.length;
    }
}




