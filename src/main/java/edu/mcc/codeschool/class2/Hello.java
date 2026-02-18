package edu.mcc.codeschool.class2;

import java.util.Scanner;

public class Hello {
    static void main(){
        System.out.println("Hello world");

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your favorite color: ");
        String color = input.nextLine();

        System.out.print("Enter your favorite number: ");
        String number = input.nextLine();

        String random = color + " " + number;

        System.out.println();
        System.out.println("\nI really like random things: " + random);
        System.out.printf("Your favorite color is %s!", color);
    }
}
