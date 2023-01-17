import java.util.Scanner;

public class CalculatorArabRoman {
    public static void main(String[] args) throws Exception {
        //���������� ������� ������
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        //������ ������ ����� ���������� ���� ��������
        String[] arr2 = str.split("");
        char o = operation(arr2);
        //���������� ������, ����� ������� �������, ���� ��� ����
        str = str.replaceAll("\\s+", "");
        //������ ������ �� ��� �������� - [0] ��� a, [1] ��� b, ����������� ���� ��������.
        String[] arr = str.split("[+-/*]");
        //��������, ������ �� ��� �������� � ������ enum
        if (isPresent(arr)) {
            //�������� �� ���������� ������� ��������
            if (RomanNumber.valueOf(arr[0]).ordinal()>0 & RomanNumber.valueOf(arr[0]).ordinal()<=10){
            romanOperation(arr, o);}
            //�� ������� � �� ���������� � ������������, ���� ������ ������� �������
            else {System.out.println("����� �� ������ � ������� ���������� ��������");}
        }
        if (!isPresent(arr)){
            parsingArab(arr, o);
        }


    }
    //���� ������ �� � ����� ���� ����� � ���������, ������� ��� ����� ���������� ������, �� ��������� ��� � ��� �� �����. ������ - https://qna.habr.com/q/847949
    static boolean isPresent(String[] arr) {
        try {
            RomanNumber.valueOf(RomanNumber.class, arr[0]);
            RomanNumber.valueOf(RomanNumber.class, arr[1]);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
    //� ������ ���� [0] � [1] �������� ������� ������, � �� ������� �� ������� ������� - ��������� ���������.
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
    //����� ����������� ���������� ���� �������� �� ������ � ��������� ��� � ��� ��� ����������� �������������
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
   //���� ����� ������� ������ �� �������. ���� ���� ������� ���������� - ������� ��� ��������� ���
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
                System.out.println("�� �� �����, �������");
            }
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
    }

}


