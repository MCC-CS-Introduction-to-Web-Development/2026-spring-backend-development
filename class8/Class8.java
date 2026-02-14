package class8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Class8 {


    static void main(){
//        readFile();
        writeFile();
    }

    static void writeFile(){
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter("C:\\dev\\code\\mcc\\2026-spring-back-end\\class8\\output_file.txt"));
            writer.write("Hello\n");
            writer.write("Class\n");
            writer.write("Hope you have\n");
            writer.write("a great Valentine's day\n");
            writer.write("<3 <3 <3 <3\n");
            String myName = "Evan Stohlmann";
            String[] split = myName.split(" ");
            writer.write("\n\nLove, " + split[0]);
        } catch (IOException e) {
            System.out.println("IOException encountered");
        } finally {
            if(writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Failed to close writer");
                }
            }
        }

    }

    static String readFile() {
        boolean fileFound = Files.exists(Paths.get("C:\\dev\\code\\mcc\\2026-spring-back-end\\class8\\input_file.txt"));
        String filePath = "C:\\dev\\code\\mcc\\2026-spring-back-end\\class8\\input_file.txt";
        Scanner scanner = null;
        StringBuilder builder = new StringBuilder();

        try {
            File inputFile = new File(filePath);
            scanner = new Scanner(inputFile);

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
                builder.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
        } finally {
            if(scanner != null){
                scanner.close();
            }
        }
        return builder.toString();
    }


    static void exceptions(){
        String[] testArray = new String[10];
        System.out.println("Here we go");
        try {
            try {
                System.out.println("We are in the try");
                int myInt = 5/1;
                testArray[10] = "Hi";
                System.out.println("Can you see me");
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("I am in the IndexOutOfBoundsException catch");
        } catch (ArithmeticException e){
            System.out.println("I am in the ArithmeticException catch");
        } finally {
            System.out.println("In the finally block");
        }
        System.out.println("Outside the try/catch");
    }

}
