import java.util.Scanner;

public class CalculatorArabRoman {
    public static void main(String[] args) throws Exception {
        //прописываю вводные данные
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        //создаю массив чтобы определить знак операции
        String[] arr2 = str.split("");
        char o = operation(arr2);
        //преобразую строку, чтобы удалить пробелы, если они есть
        str = str.replaceAll("\\s+", "");
        //создаю массив на два элемента - [0] это a, [1] это b, разделитель знак операции.
        String[] arr = str.split("[+-/*]");
        //провер€ю, вход€т ли оба операнда в список enum
        if (isPresent(arr)) {
            //проверка на допустимую область значений
            if (RomanNumber.valueOf(arr[0]).ordinal()>0 & RomanNumber.valueOf(arr[0]).ordinal()<=10){
            romanOperation(arr, o);}
            //Ќа сегодн€ € не разобралс€ с исключени€ми, пока выведу обычным принтом
            else {System.out.println("„исло не входит в область допустимых значений");}
        }
        if (!isPresent(arr)){
            parsingArab(arr, o);
        }


    }
    //≈сли честно то € нашел этот метод в интернете, понимаю что метод возвращает булейн, но объ€снить что и как не смогу. —сылка - https://qna.habr.com/q/847949
    static boolean isPresent(String[] arr) {
        try {
            RomanNumber.valueOf(RomanNumber.class, arr[0]);
            RomanNumber.valueOf(RomanNumber.class, arr[1]);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
    //¬ случае если [0] и [1] €вл€ютс€ римским числом, и не выход€т за пределы области - выводитс€ результат.
    static void romanOperation(String arr[], char o) {
    switch (o){
        case ('+'):
            System.out.println(RomanNumber.values()[RomanNumber.valueOf(arr[0]).ordinal()+RomanNumber.valueOf(arr[1]).ordinal()]);
            break;
        case ('-'):
            System.out.println(RomanNumber.values()[RomanNumber.valueOf(arr[0]).ordinal()-RomanNumber.valueOf(arr[1]).ordinal()]);
            break;
        case ('*'):
            System.out.println(RomanNumber.values()[RomanNumber.valueOf(arr[0]).ordinal()*RomanNumber.valueOf(arr[1]).ordinal()]);
            break;
        case ('/'):
            System.out.println(RomanNumber.values()[RomanNumber.valueOf(arr[0]).ordinal()/RomanNumber.valueOf(arr[1]).ordinal()]);
            break;
    }
    }
    //метод позвол€ющий определить знак операции из строки и перевести его в чар дл€ дальнейшего использовани€
    static char operation(String arr2[]) {
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
        }
        return 0;
    }
   //Ётот метод сегодн€ сделан на коленке. ѕока буду изучать исключени€ - подумаю как причесать его
    static void parsingArab (String arr[], char o){
        try {
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            if ((a>0&a<11)&(b>0&b<11)){
                switch (o){
                    case ('+'):
                        System.out.println(a+b);
                        break;
                    case ('-'):
                        System.out.println(a-b);
                        break;
                    case ('*'):
                        System.out.println(a*b);
                        break;
                    case ('/'):
                        System.out.println(a/b);
                        break;
                }
            }
            else {
                System.out.println("Ќе то число, дурачок");
            }
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
    }

}


