import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws throwsException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(calc(str));
    }

    public static String calc(String input) throws throwsException {
        String str = input;
        str = str.replaceAll("\\s+", "");
        str = str.toUpperCase();
        String[] arr = str.split("");
        if (arr.length < 2) {
            throw new throwsException("// Не являетя математической операцией");
        }
        char o = operator(arr);
        arr = str.split("[+-/*]");

        if (parsingNumberRom(arr)) {
            if (!romanSize(arr)) {
                throw new throwsException("// превышен допустимый диапазон числа");
            }
            if (romanSize(arr)) {
                return romanOperation(arr, o);
            }
        }
        if (!parsingNumberRom(arr)) {
            if (parsingArab(arr)) {
                if (arabSize(arr)) {
                    return Integer.toString(arabOperation(arr, o));
                } else {
                    throw new throwsException("// превышен допустимый диапазон числа");
                }
            } else {
                throw new throwsException("// Разные системы счисления");
            }
        }
        return null;
    }
    static char operator(String[] arr) throws throwsException {
        int count = 0;
        char o = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("+") | arr[i].equals("-") | arr[i].equals("*") | arr[i].equals("/")) {
                count++;
                o = arr[i].charAt(0);
            }
        }
        if (count < 1 | count > 1) {
            throw new throwsException("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else return o;
    }
    static boolean parsingNumberRom(String[] arr) throws throwsException {
        try {
            RomanNumber.valueOf(RomanNumber.class, arr[0]);
            RomanNumber.valueOf(RomanNumber.class, arr[1]);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
    static boolean romanSize(String[] arr) {
        if (RomanNumber.valueOf(arr[0]).ordinal() < 1 | RomanNumber.valueOf(arr[0]).ordinal() > 10) {
            return false;
        }
        if (RomanNumber.valueOf(arr[1]).ordinal() < 1 | RomanNumber.valueOf(arr[1]).ordinal() > 10) {
            return false;
        }
        if (RomanNumber.valueOf(arr[0]).ordinal() >= 1 & RomanNumber.valueOf(arr[0]).ordinal() <= 10 & RomanNumber.valueOf(arr[1]).ordinal() >= 1 & RomanNumber.valueOf(arr[1]).ordinal() <= 10) {
            return true;
        }
        return false;
    }
    static boolean arabSize(String[] arr) {
        if (Integer.parseInt(arr[0]) < 1 | Integer.parseInt(arr[0]) > 10) {
            return false;
        }
        if (Integer.parseInt(arr[1]) < 1 | Integer.parseInt(arr[1]) > 10) {
            return false;
        }
        return true;
    }
    static String romanOperation(String arr[], char o) throws throwsException {
        switch (o) {
            case ('+'):
                return (RomanNumber.values()[RomanNumber.valueOf(arr[0]).ordinal() + RomanNumber.valueOf(arr[1]).ordinal()]).toString();

            case ('-'):
                if (RomanNumber.valueOf(arr[0]).ordinal() > RomanNumber.valueOf(arr[1]).ordinal()) {
                    return (RomanNumber.values()[RomanNumber.valueOf(arr[0]).ordinal() - RomanNumber.valueOf(arr[1]).ordinal()]).toString();

                }
                if (RomanNumber.valueOf(arr[0]).ordinal() == RomanNumber.valueOf(arr[1]).ordinal()) {
                    return "NULL";

                }
                if (RomanNumber.valueOf(arr[0]).ordinal() < RomanNumber.valueOf(arr[1]).ordinal()) {
                    throw new throwsException("// В римской системе нет отрицательных чисел");
                }
            case ('*'):
                return (RomanNumber.values()[RomanNumber.valueOf(arr[0]).ordinal() * RomanNumber.valueOf(arr[1]).ordinal()]).toString();

            case ('/'):
                return (RomanNumber.values()[RomanNumber.valueOf(arr[0]).ordinal() / RomanNumber.valueOf(arr[1]).ordinal()]).toString();

            default: {
                throw new throwsException("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
        }
    }
    static int arabOperation(String[] arr, char o) {
        switch (o) {
            case ('+'):
                return Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
            case ('-'):
                return Integer.parseInt(arr[0]) - Integer.parseInt(arr[1]);
            case ('*'):
                return Integer.parseInt(arr[0]) * Integer.parseInt(arr[1]);
            case ('/'):
                return Integer.parseInt(arr[0]) / Integer.parseInt(arr[1]);
        }
        return 0;
    }
    static boolean parsingArab(String[] arr) {
        try {
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

