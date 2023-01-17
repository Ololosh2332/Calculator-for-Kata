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
        //проверяю, входят ли оба операнда в список enum
        if (isPresent(arr)) {
            //проверка на допустимую область значений
            if (RomanNumber.valueOf(arr[0]).ordinal()>0 & RomanNumber.valueOf(arr[0]).ordinal()<=10){
            romanOperation(arr, o);}
            //На сегодня я не разобрался с исключениями, пока выведу обычным принтом
            else {System.out.println("Число не входит в область допустимых значений");}
        }
        if (!isPresent(arr)){
            parsingArab(arr, o);
        }


    }
    //Если честно то я нашел этот метод в интернете, понимаю что метод возвращает булейн, но объяснить что и как не смогу. Ссылка - https://qna.habr.com/q/847949
    static boolean isPresent(String[] arr) {
        try {
            RomanNumber.valueOf(RomanNumber.class, arr[0]);
            RomanNumber.valueOf(RomanNumber.class, arr[1]);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
    //В случае если [0] и [1] являются римским числом, и не выходят за пределы области - выводится результат.
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
    //метод позволяющий определить знак операции из строки и перевести его в чар для дальнейшего использования
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
   //Этот метод сегодня сделан на коленке. Пока буду изучать исключения - подумаю как причесать его
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
                System.out.println("Не то число, дурачок");
            }
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
    }

}


