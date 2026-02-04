package class4;

import java.util.Random;
import java.util.Scanner;

public class DiceRoller {

    // print a greeting
    // forever (until user says no)
    //    roll two dice
    //    print their two independent values
    //    print their total
    //    if total == 12 -> Box Cars!
    //    if total == 2 -> Snake Eyes
    // continue?

    static void main(){
        Scanner scanner = new Scanner(System.in);
        printGreeting();

        while (true){
            int die1 = rollDice();
            int die2 = rollDice();

            printDiceValues(die1, die2);
            printTotal(die1, die2);

            if(!goAgain(scanner)){
                break;
            }
        }

    }

    private static void printGreeting(){
        System.out.println("Welcome to Dice Roller");
        System.out.println();
    }

    private static int rollDice(){
        Random randomNumberGenerator = new Random();
        return randomNumberGenerator.nextInt(6) + 1;
    }

    private static void printDiceValues(int die1, int die2){
        System.out.println("Dice 1: " + die1);
        System.out.println("Dice2: " + die2);
    }

    private static void printTotal(int val1, int val2){
        int total  = val1 + val2;
        System.out.println("Total: " + total);
        if(total == 12){
            System.out.println("Box Cars!");
        } else if (total == 2) {
            System.out.println("Snake Eyes!");
        }

    }

    private static boolean goAgain(Scanner scanner){
        System.out.println("\nWould you like to continue (y/n): ");
        String goAgain = scanner.nextLine();
        System.out.println();
        return goAgain.equalsIgnoreCase("y");
    }

}
