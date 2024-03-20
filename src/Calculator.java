import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    static String[] validArab = {"1","2","3","4","5","6","7","8","9","10"};
    static String[] validRoman = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
    static String inputData;
    
    public static void main(String[] args) throws Exception {
        List<String> validArabRange = new ArrayList<>();
        List<String> validRomanRange = new ArrayList<>();
        validArabRange.addAll(Arrays.asList(validArab));
        validRomanRange.addAll(Arrays.asList(validRoman));


        Scanner input = new Scanner(System.in);
        inputData = input.nextLine();
        var parsedData = inputData.replaceAll(" ", "").toUpperCase().
            replace(" ", "").split("[\\+\\-\\*\\/]");
        input.close();
        
        var operand1 = parsedData[0];
        var operand2 = parsedData[1];
        
        if(parsedData.length > 2){
            throw new Exception("Кол-во операндов больше двух");
        }

        if(validArabRange.contains(operand1) & validArabRange.contains(operand2)){
            var num1 = Integer.parseInt(operand1);
            var num2 = Integer.parseInt(operand2);
            var operationResult = calculation(num1,num2); 
            System.out.println(operationResult);
        }
        else if(validRomanRange.contains(operand1) & validRomanRange.contains(operand2)){
            int num1 = RomanOperations.toArabic(operand1);
            int num2 = RomanOperations.toArabic(operand2);
            int operationResult = calculation(num1,num2);
            if(operationResult>0){
                System.out.println(RomanOperations.toRoman(operationResult));
            }
            else throw new Exception("Вычисления с римскими числами должны быть больше нуля");
        } 
        else throw new Exception("Числа должны быть в одной системе счисления");

    }
    

    public static int calculation(int num1, int num2){
        int result = 0;

        if(inputData.contains("+")){
            result = num1 + num2;
        }
        else if(inputData.contains("-")){
            result = num1 - num2;
        }
        else if(inputData.contains("*")){
            result = num1 * num2;
        }
        else if(inputData.contains("/")){
            result = num1/num2;
        }
        return result;
    }
    
}

class RomanOperations{
    final static String[] romanNumerals ={"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
    "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
    "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
    "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
    "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
    "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
    "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
    "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
    "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
    "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
    public static int toArabic(String romanNumeral){
        List <String> romanNumeralsList = new ArrayList<>();
        romanNumeralsList.addAll(Arrays.asList(romanNumerals));
        return romanNumeralsList.indexOf(romanNumeral) + 1;
    }
    public static String toRoman(int arabicNumeral){
        return romanNumerals[arabicNumeral-1];
    }    
}