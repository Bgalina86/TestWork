package calculator;

import java.util.Scanner;

public class Calculator {
    // Организация кода ошибки
    static final int Error_PasswordIsTooShort = 1;
    static final int Error_NoDigitDetected = 2;
    static final int Error_NoSpecialCharDetected = 3;

    //Определение строки спецсимволов
    static final String kSpecialChars = "!@#$%^&*\"№";

    //Вывод сообщения на основании кода
    private static String displayErrorText(int code) {
        switch (code) {
            case 0:
                return "Пароль нормальный";
            case Error_PasswordIsTooShort:
                return "Пароль менее 8 символов";
            case Error_NoDigitDetected:
                return "Пароль должен содержать минимум 1 цифру";
            case Error_NoSpecialCharDetected:
                return "Пароль должен содержать минимум 1 спецсимвол";
            default:
                return "Неизвестный код ошибки";
        }
    }

    /**
     * Определяет, является ли символ специальным.
     *
     * @param sym Символ для проверки
     * @return true или false.
     */
    private static boolean isSpecialSymbol(char sym) {
        for (int i = 0; i < kSpecialChars.length(); i++) {
            if (kSpecialChars.charAt(i) == sym) {
                return true;
            }
        }

        return false;
    }

    /**
     * Проверяет пароль на валидность по правилам
     *
     * @param password Пароль
     * @return Код ошибки, если пароль невалидный, или 0 - если правильный.
     */
    private static int checkPassword2(final String password) {
        //
        // Правило: В пароле необходимое число символов
        //
        if (password.length() < 8) {
            return Error_PasswordIsTooShort;
        }

        int amountOfDigits = 0;           // Число встреченных цифр
        int amountOfSpecChars = 0;        // Число встреченных спецсимволов

        //
        // В цикле проходим по строке, считаем цифры и спецсимволы
        //
        for (int i = 0; i < password.length(); i++) {
            char currChar = password.charAt(i);
            if (Character.isDigit(currChar)) {
                amountOfDigits++;
            }

            if (isSpecialSymbol(currChar)) {
                amountOfSpecChars++;
            }
        }

        //
        // Правило: должна быть хотя бы одна цифра
        //
        if (amountOfDigits == 0) {
            return Error_NoDigitDetected;
        }

        //
        // Правило: должен быть хотя бы один спец-символ
        //
        if (amountOfSpecChars == 0) {
            return Error_NoSpecialCharDetected;
        }

        return 0;
    }

    public static void main(String[] args) {
        //
        // Tесты
        //
        System.out.println(displayErrorText(checkPassword2("AAAA"))); // короткий слишком
        System.out.println(displayErrorText(checkPassword2("ABCDEFGH"))); // нет цифр
        System.out.println(displayErrorText(checkPassword2("ABCDEFGH123"))); // нет спец. символов
        System.out.println(displayErrorText(checkPassword2("ABCDEFGH123@"))); // норма
        System.out.println(displayErrorText(checkPassword2("ABH123@"))); //короткий слишком
        System.out.println(displayErrorText(checkPassword2("AGH123"))); //короткий слишком
        System.out.println(displayErrorText(checkPassword2("ABC@"))); //короткий слишком
    }
}
