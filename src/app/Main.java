package app;

import core.CaesarCipher;
//тестовая сборка
public class Main {
    public static void main(String[] args) {
        String original = "привет, как дела? 123";
        int key = 7;

        String encrypted = CaesarCipher.encryptText(original, key);
        String decrypted = CaesarCipher.decryptText(encrypted, key);

        System.out.println("Оригинал : " + original);
        System.out.println("Ключ     : " + key);
        System.out.println("Шифр     : " + encrypted);
        System.out.println("Дешифр   : " + decrypted);

    }
}
