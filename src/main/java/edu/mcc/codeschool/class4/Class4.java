package edu.mcc.codeschool.class4;

import java.util.Scanner;

public class Class4 {
    static void main(){
        Scanner input = new Scanner(System.in);

        while(true) {
            int firstNum = getNumberFromUser(input, "Enter your first number: ");
            int secondNum = getNumberFromUser(input, "Enter your second number: ");
            String operand = getOperationFromUser(input);

            System.out.println("\nEquation is: " + firstNum + " " + operand + " " + secondNum);

            doMath(firstNum, secondNum, operand);

            if(!goAgain(input)){
                break;
            }
        }
    }

    private static int getNumberFromUser(Scanner input, String prompt){
        System.out.print(prompt);
        int num = input.nextInt();
        input.nextLine();
        return num;
    }

    private static String getOperationFromUser(Scanner input){
        System.out.print("Enter an operand (+-*/%): ");
        return input.nextLine();
    }

    private static void doMath(int firstNum, int secondNum, String operand){
        double result = switch (operand) {
            case "%" -> firstNum % secondNum;
            case "*" -> firstNum * secondNum;
            case "/" -> (double) firstNum / secondNum;
            case "-" -> firstNum - secondNum;
            default -> firstNum + secondNum;
        };

        System.out.println("\n" + firstNum + " " + operand + " " + secondNum + " = " + result);
    }

    private static boolean goAgain(Scanner scanner){
        System.out.println("\nWould you like to continue (y/n): ");
        String goAgain = scanner.nextLine();
        System.out.println();
        return goAgain.equalsIgnoreCase("y");
    }

}
