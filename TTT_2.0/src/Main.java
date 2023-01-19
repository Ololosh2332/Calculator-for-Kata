import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws throwsException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(calc(str));
    }

    public static String calc(String input) throws throwsException {
        String str = input;
        String res = "";
        str = str.replaceAll("\\s+", "");
        str = str.toUpperCase();
        String[] arr = str.split("");
        char o = operator(arr);
        arr = str.split("[+-/*]");
        if (parsingNumberRom(arr).equals("Roman")){
            if (!romanSize(arr))
            {
                throw new throwsException("// �������� ���������� �������� �����");
            }
            if (romanSize(arr)) {
                res = romanOperation(arr,o).toString();
            }
        }
        if (parsingNumberRom(arr).equals("false")){
            if (arabSize(arr)){
                res = Integer.toString(arabOperation(arr, o));
            }
            else {
                throw new throwsException("// �������� ���������� �������� �����");
            }
        }
        else {
            throw new throwsException("// ������ ������� ���������");
        }
        return res;
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
            throw new throwsException("//�.�. ������ �������������� �������� �� ������������� ������� - ��� �������� � ���� �������� (+, -, /, *)");
        } else return o;
    }

    static String parsingNumberRom(String[] arr) throws throwsException {
        try {
            RomanNumber.valueOf(RomanNumber.class, arr[0]);
            RomanNumber.valueOf(RomanNumber.class, arr[1]);
            return "Roman";
        } catch (IllegalArgumentException e) {
            return "false";
        }
    }

    static boolean romanSize (String[] arr){
        if (RomanNumber.valueOf(arr[0]).ordinal()<1|RomanNumber.valueOf(arr[0]).ordinal()>10){
            return false;
        }
        if (RomanNumber.valueOf(arr[1]).ordinal()<1|RomanNumber.valueOf(arr[1]).ordinal()>10){
            return false;
        }
        if (RomanNumber.valueOf(arr[0]).ordinal()>=1&RomanNumber.valueOf(arr[0]).ordinal()<=10&RomanNumber.valueOf(arr[1]).ordinal()>=1&RomanNumber.valueOf(arr[1]).ordinal()<=10) {
            return true;
        }
        return false;
    }
    static boolean arabSize (String[] arr){
        if (Integer.parseInt(arr[0])<1|Integer.parseInt(arr[0])>10){
            return false;
        }
        if (Integer.parseInt(arr[1])<1|Integer.parseInt(arr[1])>10){
            return false;
        }
        return true;
    }

    static String romanOperation(String arr[], char o) throws throwsException {
        switch (o) {
            case ('+'):
                return (RomanNumber.values()[RomanNumber.valueOf(arr[0]).ordinal() + RomanNumber.valueOf(arr[1]).ordinal()]).toString();

            case ('-'):
                if (RomanNumber.valueOf(arr[0]).ordinal()>RomanNumber.valueOf(arr[1]).ordinal()) {
                    return (RomanNumber.values()[RomanNumber.valueOf(arr[0]).ordinal() - RomanNumber.valueOf(arr[1]).ordinal()]).toString();

                }
                if (RomanNumber.valueOf(arr[0]).ordinal()==RomanNumber.valueOf(arr[1]).ordinal()) {
                    return "NULL";

                }
                if (RomanNumber.valueOf(arr[0]).ordinal()<RomanNumber.valueOf(arr[1]).ordinal()){
                    throw new throwsException("// � ������� ������� ��� ������������� �����");
                }
            case ('*'):
                return (RomanNumber.values()[RomanNumber.valueOf(arr[0]).ordinal() * RomanNumber.valueOf(arr[1]).ordinal()]).toString();

            case ('/'):
                return (RomanNumber.values()[RomanNumber.valueOf(arr[0]).ordinal() / RomanNumber.valueOf(arr[1]).ordinal()]).toString();

            default: {
                throw new throwsException("//�.�. ������ �������������� �������� �� ������������� ������� - ��� �������� � ���� �������� (+, -, /, *)");
            }}}

    static int arabOperation (String[] arr, char o){
        switch (o){
            case ('+'):
                return Integer.parseInt(arr[0])+Integer.parseInt(arr[1]);
            case ('-'):
                return Integer.parseInt(arr[0])-Integer.parseInt(arr[1]);
            case ('*'):
                return Integer.parseInt(arr[0])*Integer.parseInt(arr[1]);
            case ('/'):
                return Integer.parseInt(arr[0])/Integer.parseInt(arr[1]);
        }
        return 0;
    }

}

