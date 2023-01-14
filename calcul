import java.util.Scanner;

public class Calcul {
    public static void main(String[] args) {
        //первую версию калькулятора решил сделать с двумя текстовыми массивами, основная задача - разобраться с тем как работают методы
        String [] roman = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII"};
        String [] arab = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17"};
        String one = "";
        String two = "";
        int a = 0;
        int b = 0;
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.replaceAll("\\s+","");
        String [] arr2 = str.split("");
        String [] arr = str.split("[+-/*]");
        for (int i = 0; i< roman.length; i++) {
            if (arr[0].equals(roman[i])) {
                one = "roman";
                a = i;
            }
            if (arr[1].equals(roman[i])) {
                two = "roman";
                b = i;
            }
        }
            for (int i = 0; i< arab.length; i++){
                if (arr[0].equals(arab[i])){
                    one = "arab";
                    a = i;
                }
                if (arr[1].equals(arab[i])){
                    two = "arab";
                    b = i;
                }
        }
            if (!one.equals(two)){
                System.out.println("Не вышло");
            }
            if (one.equals(two)){
                operation(arr2, a, b);
            }
        }

        static void operation (String [] arr2, int a, int b){
    for (int i = 0; i< arr2.length; i++){
        if (arr2[i].equals("+")){
            System.out.println(a+b);
        }
        if (arr2[i].equals("-")){
            System.out.println(a-b);
        }
        if (arr2[i].equals("*")){
            System.out.println(a*b);
        }
        if (arr2[i].equals("/")){
            System.out.println(a/b);
        }
    }
    }

}








