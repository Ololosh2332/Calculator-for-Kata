import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws throwsException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        //Строка для выявления оператора
        String[] arr2 = str.split("");
        char o = operation(arr2);
        //Удаляем пробелы
        str = str.replaceAll("\\s+", "");

        String[] arr = str.split("[+-/*]");
        //Выбрасываем исключение по неверному формату строки
        if (arr.length < 2) {
            throw new throwsException("//т.к. строка не является математической операцией");
        }
        if (arr.length > 2) {
            throw new throwsException("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        if (isPresent(arr)) {
            if ((RomanNumber.valueOf(arr[0]).ordinal() > 0 & RomanNumber.valueOf(arr[0]).ordinal() <= 10) & (RomanNumber.valueOf(arr[1]).ordinal() > 0 & RomanNumber.valueOf(arr[1]).ordinal() <= 10)) {
                romanOperation(arr, o);
            }
            //На сегодня я не разобрался с исключениями, пока выведу обычным принтом
            else {
                throw new throwsException("т.к. формат математической операции не удовлетворяет заданию - операнды в диапазоне от 1 до 10");
            }
        }
        if (!isPresent(arr)) {
            parsingArab(arr, o);
        }


    }

    static boolean isPresent(String[] arr) {
        try {
            RomanNumber.valueOf(RomanNumber.class, arr[0]);
            RomanNumber.valueOf(RomanNumber.class, arr[1]);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    static void romanOperation(String arr[], char o) throws throwsException {
        switch (o) {
            case ('+'):
                System.out.println(RomanNumber.values()[RomanNumber.valueOf(arr[0]).ordinal() + RomanNumber.valueOf(arr[1]).ordinal()]);
                break;
            case ('-'):
                System.out.println(RomanNumber.values()[RomanNumber.valueOf(arr[0]).ordinal() - RomanNumber.valueOf(arr[1]).ordinal()]);
                break;
            case ('*'):
                System.out.println(RomanNumber.values()[RomanNumber.valueOf(arr[0]).ordinal() * RomanNumber.valueOf(arr[1]).ordinal()]);
                break;
            case ('/'):
                System.out.println(RomanNumber.values()[RomanNumber.valueOf(arr[0]).ordinal() / RomanNumber.valueOf(arr[1]).ordinal()]);
                break;
            default: {
                throw new throwsException("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }


        }
    }
    static char operation(String arr2[]) throws throwsException {
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i].equals("+")) {
                return '+';
            }
            if (arr2[i].equals("-")) {
                return '-';
            }
            if (arr2[i].equals("*")) {
                return '*';
            }
            if (arr2[i].equals("/")) {
                return '/';
            }
            else {throw new throwsException("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");}
        }
        return 0;
    }

}
