import java.util.InputMismatchException;
import java.util.Scanner;


public class zz {
    static Scanner scanner = new Scanner(System.in);
    static int n1, n2;
    static char operation;
    static int result;
    static boolean k = true;

    public static void main(String[] args) {
        System.out.println("Введите уравнение в формате 2+2 или I+I");
        String input = scanner.nextLine();
        // считываем строку
        char[] uchar = new char[10];
        // пустой символьный массив длиной 10 символов:
        for (int i = 0; i < input.length(); i++) {
            // символьный массив заполняется символами строки которую ввел пользователь и ищем знак операции
            uchar[i] = input.charAt(i);
            if (uchar[i] == '+') {
                operation = '+';
            }
            if (uchar[i] == '-') {
                operation = '-';
            }
            if (uchar[i] == '*') {
                operation = '*';
            }
            if (uchar[i] == '/') {
                operation = '/';
            }
        }
        String ucharS = String.valueOf(uchar);
        String[] ucharSspl = ucharS.split("[+-/*]");
        String s00 = ucharSspl[0];
        String s01 = ucharSspl[1];
        String string03 = s01.trim();
        n1 = romanToNumber(s00);
        n2 = romanToNumber(string03);
        if (n1 < 0 && n2 < 0) { // что к нам попало: римские или арабские
            n1 = Integer.parseInt(s00);
            n2 = Integer.parseInt(string03);
            result = 0;
        } else {
            // считаем для римских
            k = false;
            result = calculated(n1, n2, operation);
            System.out.println("---Результат для римских цифр---");
            String resultRoman = convertNumToRoman(result);
            System.out.println(s00 + " " + operation + " " + string03 + " = " + resultRoman);
        }
        if (k) { // исключаем подсчет в двух форматах
        // считаем для арабских
        result = calculated(n1, n2, operation);
        System.out.println("--Результат для арабских цифр---");
        System.out.println(n1 + " " + operation + " " + n2 + " = " + result);
        }
    }
    // "библиотека" римских символов
    private static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        return roman[numArabian];
    }
    // конвертация римких в арабские
    private static int romanToNumber (String roman) {
        try {
            switch (roman) {
                case "I":
                    return 1;
                case "II":
                    return 2;
                case "III":
                    return 3;
                case "IV":
                    return 4;
                case "V":
                    return 5;
                case "VI":
                    return 6;
                case "VII":
                    return 7;
                case "VIII":
                    return 8;
                case "IX":
                    return 9;
                case "X":
                    return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Что-то не так с римскими значениями");
        }
        return -1;
    }
    // вычисление результата
    public static int calculated (int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+': result = num1 + num2;
                break;
            case '-': result = num1 - num2;
                break;
            case '*': result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Что-то не так: " + e);
                    System.out.println("Только не нулевые и целые значения");

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Что-то не так со знаком операции");
        }
        if (n1<0) {
            if (n2>0) {
                throw new IllegalArgumentException("Формат значений не совпадает");
            }
        }
        return result;
    }
}