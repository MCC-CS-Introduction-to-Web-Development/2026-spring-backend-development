package edu.mcc.codeschool.class3;

import java.util.Scanner;

public class Calculator {
    static void main(){
        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.print("Enter your first number: ");
            int firstNum = input.nextInt();
            input.nextLine();

            System.out.print("Enter your second number: ");
            int secondNum = input.nextInt();
            input.nextLine();

            System.out.print("Enter an operand (+-*/%): ");
            String operand = input.nextLine();

            System.out.println("\nEquation is: " + firstNum + " " + operand + " " + secondNum);

            double result = switch (operand) {
                case "%" -> firstNum % secondNum;
                case "*" -> firstNum * secondNum;
                case "/" -> (double) firstNum / secondNum;
                case "-" -> firstNum - secondNum;
                default -> firstNum + secondNum;
            };

            System.out.println("\n" + firstNum + " " + operand + " " + secondNum + " = " + result);

            System.out.print("\nWould you like to continue (y/n): ");
            String goAgain = input.nextLine();
            if(!goAgain.equalsIgnoreCase("y")){
                break;
            }
            System.out.println();
        }
    }
}
