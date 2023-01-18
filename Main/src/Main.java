import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws throwsException {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.replaceAll("\\s+", "");
        calc calc1 = new calc(str);
        calc1.setArr();
        calc1.setArr2();
        calc1.operation(calc1.arr2);
        calc1.parsingLength(calc1.arr);
        calc1.setO();

        if(calc1.isPresent(calc1.arr)){
            if (calc1.romanSize(calc1.arr)){
                calc1.romanOperation(calc1.arr, calc1.o);
            }
            if (!calc1.romanSize(calc1.arr)){
                throw new throwsException("// превышен допустимый диапазон числа");
            }
        }

        if (!calc1.isPresent(calc1.arr)){
            if (!calc1.arabParsing(calc1.arr)){
                throw new throwsException("//разные системы счисления");
            }
            if (calc1.arabParsing(calc1.arr)){
                if (calc1.arabSize(calc1.arr)){
                    calc1.arabOperation(calc1.arr, calc1.o);
                }
                if (!calc1.arabSize(calc1.arr)){
                    throw new throwsException("// превышен допустимый диапазон числа");
                }
            }
        }

    }

}
class calc {
    private String str;
    String[] arr;
    String[] arr2;
    char o;

    public void setArr() {
        this.arr = array1Form(str);
    }

    public void setArr2() {
        this.arr2 = array2Form(str);
    }

    public calc(String str) {
        this.str = str;
    }

    public String[] array1Form(String str) {
        String[] arr = str.split("[+-/*]");
        return arr;
    }

    public String[] array2Form(String str) {
        String[] arr2 = str.split("");
        return arr2;
    }

    public void setO() throws throwsException {
        this.o = operation(arr2);
    }

    public char operation(String[] arr2) throws throwsException {
        int count = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i].equals("+") | arr2[i].equals("-") | arr2[i].equals("*") | arr2[i].equals("/")) {
                count++;
            }
        }
        if (count > 1 | count < 1) {
            throw new throwsException("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        if (count == 1) {
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
            {
                throw new throwsException("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
        }
        return 0;
    }

    public void parsingLength(String[] arr) throws throwsException {
        if (arr.length > 2) {
            throw new throwsException("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        if (arr.length < 2) {
            throw new throwsException("//т.к. строка не является математической операцией");
        }
    }
    //I took it from here: https://qna.habr.com/q/847949
    public boolean isPresent(String[] arr) {
        try {
            RomanNumber.valueOf(RomanNumber.class, arr[0]);
            RomanNumber.valueOf(RomanNumber.class, arr[1]);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
    public boolean romanSize (String[] arr){
        if (RomanNumber.valueOf(arr[0]).ordinal()<1|RomanNumber.valueOf(arr[0]).ordinal()>10){
            return false;
        }
        if (RomanNumber.valueOf(arr[1]).ordinal()<1|RomanNumber.valueOf(arr[1]).ordinal()>10){
            return false;
        }
        else return true;
    }

    public void romanOperation(String arr[], char o) throws throwsException {
        switch (o) {
            case ('+'):
                System.out.println(RomanNumber.values()[RomanNumber.valueOf(arr[0]).ordinal() + RomanNumber.valueOf(arr[1]).ordinal()]);
                break;
            case ('-'):
                if (RomanNumber.valueOf(arr[0]).ordinal()>RomanNumber.valueOf(arr[1]).ordinal()) {
                    System.out.println(RomanNumber.values()[RomanNumber.valueOf(arr[0]).ordinal() - RomanNumber.valueOf(arr[1]).ordinal()]);
                    break;
                }
                if (RomanNumber.valueOf(arr[0]).ordinal()<RomanNumber.valueOf(arr[1]).ordinal()){
                    throw new throwsException("// В римской системе нет отрицательных чисел");
                }
            case ('*'):
                System.out.println(RomanNumber.values()[RomanNumber.valueOf(arr[0]).ordinal() * RomanNumber.valueOf(arr[1]).ordinal()]);
                break;
            case ('/'):
                System.out.println(RomanNumber.values()[RomanNumber.valueOf(arr[0]).ordinal() / RomanNumber.valueOf(arr[1]).ordinal()]);
                break;
            default: {
                throw new throwsException("//т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }}}
    public boolean arabParsing (String[] arr) throws throwsException {
        try{
            Integer.parseInt(arr[0]);
            Integer.parseInt(arr[1]);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public boolean arabSize (String[] arr){
        if (Integer.parseInt(arr[0])<1|Integer.parseInt(arr[0])>10){
            return false;
        }
        if (Integer.parseInt(arr[1])<1|Integer.parseInt(arr[1])>10){
            return false;
        }
        return true;
    }
    public void arabOperation (String[] arr, char o){
        switch (o){
            case ('+'):
                System.out.println(Integer.parseInt(arr[0])+Integer.parseInt(arr[1]));
                break;
            case ('-'):
                System.out.println(Integer.parseInt(arr[0])-Integer.parseInt(arr[1]));
                break;
            case ('*'):
                System.out.println(Integer.parseInt(arr[0])*Integer.parseInt(arr[1]));
                break;
            case ('/'):
                System.out.println(Integer.parseInt(arr[0])/Integer.parseInt(arr[1]));
                break;
        }
    }

}








