package class6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Class6 {

    static void main(){
        Map<String, Double> studentsToGrade = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        studentsToGrade.put(getName(scanner), getGrade(scanner));
        studentsToGrade.put(getName(scanner), getGrade(scanner));
        studentsToGrade.put(getName(scanner), getGrade(scanner));
        studentsToGrade.put(getName(scanner), getGrade(scanner));

        for(String studentName: studentsToGrade.keySet()){
            System.out.println("Student " + studentName + " got the grade of " + studentsToGrade.get(studentName) + " on the test.");
        }

    }

    private static String getName(Scanner input){
        System.out.print("Enter a name: ");
        return input.nextLine();
    }

    private static Double getGrade(Scanner input){
        System.out.print("Enter a grade for test 1: ");
        Double ret = input.nextDouble();
        input.nextLine();
        return ret;
    }

    static void sets(){
        Set<String> fastFoodPlaces = new TreeSet<>();
        fastFoodPlaces.add("McDonalds");
        fastFoodPlaces.add("BK");
        fastFoodPlaces.add("bk");
        fastFoodPlaces.add("Five Guys");
        fastFoodPlaces.add("Five Guys");

        for(String location : fastFoodPlaces){
            System.out.println(location);
        }

    }

    static void lists(){
        List<String> footballTeams = new ArrayList<>();
        footballTeams.add("Eagles");
        footballTeams.add("Packers");
        footballTeams.add("49ers");
        footballTeams.add("Seahawks");
        footballTeams.add("Cowgirls");

        for(int i = 0; i < footballTeams.size(); i++){
            System.out.println(footballTeams.get(i));
        }

        System.out.println();
        System.out.println("---------------------------");
        System.out.println();

        Collections.sort(footballTeams);
        for(String team : footballTeams){
            System.out.println(team);
        }

        System.out.println();
        System.out.println("---------------------------");
        System.out.println();

        Collections.sort(footballTeams, Collections.reverseOrder());
        footballTeams.remove("Cowgirls");
        footballTeams.forEach(team -> System.out.println(team));
    }

    static void arrays(){
        String[] names = new String[5];
        names[0] = "Evan";
        names[1] = "Chris";
        names[2] = "Cesar";
        names[3] = "Terry";
        names[4] = "Iain";

        for(int i = names.length - 1; i >= 0; i--){
            System.out.println("Hello " + names[i] + " and I am at index " + i);
        }

        System.out.println();
        System.out.println("---------------------------");
        System.out.println();

        Arrays.sort(names);
        for(String name : names){
            System.out.println("Hello " + name);
        }
    }
}
