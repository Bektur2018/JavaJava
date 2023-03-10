package Aravan;

import java.io.IOException;
import java.util.Scanner;



public class Main22 {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number or letters");
        String expression = scanner.nextLine();
        System.out.println(analysis(expression));
    }

    public static String analysis(String expression ) throws Exception {
        int number1;
        int number2;
        String operator;
        boolean roman;
        String[] opera = expression.split("[+\\-*/]");
        if (opera.length != 2) throw new Exception("не больше двух символов ");
        operator = detect(expression);
        if (operator == null) throw new Exception("don't work ");
        if (Main11.roman(opera[0]) && Main11.roman(opera[1])) {
            number1 = Main11.general(opera[0]);
            number2 = Main11.general(opera[1]);
            roman= true;
        }
        else if (!Main11.roman(opera[0]) && !Main11.roman(opera[1])) {
        number1 = Integer.parseInt(opera[0]);
        number2 = Integer.parseInt(opera[1]);
        roman = false;
        }
else {
    throw new IOException("numbers  is need in one format");
        }
if (number1 > 10 || number2 > 10){
    throw  new IOException("");
}
int arabic = calculate(number1, number2, operator);
if (roman){
    if (arabic <= 0){
        throw new IOException(">>>>>>");
    }
   operator = Main11.convertTo(arabic);
}else{
    operator = String.valueOf(arabic);
}
return operator;
    }
    static String detect(String expression){
        if (expression.contains("+")) return "+";
        else if (expression.contains("-")) return "-";
        else if (expression.contains("*")) return "*";
        else if (expression.contains("/")) return "/";
        else return null;
    }
    static int calculate(int a, int b,String operator){
        if (operator.equals("+")) return a+b;
        else if(operator.equals("-")) return a - b;
        else if (operator.equals("*")) return a * b;
        else return a / b ;
    }
}
