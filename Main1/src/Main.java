import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws throwsException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        //������ ��� ��������� ���������
        String[] arr2 = str.split("");
        char o = operation(arr2);
        //������� �������
        str = str.replaceAll("\\s+", "");

        String[] arr = str.split("[+-/*]");
        //����������� ���������� �� ��������� ������� ������
        if (arr.length < 2) {
            throw new throwsException("//�.�. ������ �� �������� �������������� ���������");
        }
        if (arr.length > 2) {
            throw new throwsException("//�.�. ������ �������������� �������� �� ������������� ������� - ��� �������� � ���� �������� (+, -, /, *)");
        }
        if (isPresent(arr)) {
            if ((RomanNumber.valueOf(arr[0]).ordinal() > 0 & RomanNumber.valueOf(arr[0]).ordinal() <= 10) & (RomanNumber.valueOf(arr[1]).ordinal() > 0 & RomanNumber.valueOf(arr[1]).ordinal() <= 10)) {
                romanOperation(arr, o);
            }
            //�� ������� � �� ���������� � ������������, ���� ������ ������� �������
            else {
                throw new throwsException("�.�. ������ �������������� �������� �� ������������� ������� - �������� � ��������� �� 1 �� 10");
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
                throw new throwsException("//�.�. ������ �������������� �������� �� ������������� ������� - ��� �������� � ���� �������� (+, -, /, *)");
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
            else {throw new throwsException("//�.�. ������ �������������� �������� �� ������������� ������� - ��� �������� � ���� �������� (+, -, /, *)");}
        }
        return 0;
    }

}
