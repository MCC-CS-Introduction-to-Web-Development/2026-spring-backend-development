package class5;

import java.util.Scanner;

public class Class5 {

    static void main() {
        Scanner scanner = new Scanner(System.in);
        Car car1 = getCarDetails(scanner);
        System.out.println(car1.honkHorn());
        System.out.println(car1.turnLeft(90));
        System.out.println(car1.turnRight(90));
        System.out.println(car1);


        Motorcycle motorcycle = getMotorcycleDetails(scanner);
        System.out.println(motorcycle.honkHorn());
        System.out.println(motorcycle.turnLeft(90));
        System.out.println(motorcycle.turnRight(90));
        System.out.println(motorcycle);

    }

    private static Car getCarDetails(Scanner input){
        Car ret = new Car();
        System.out.print("Does your car have a third row (y/n): ");
        String in  = input.nextLine();
        ret.setThridRow(in.equalsIgnoreCase("y"));

        System.out.print("Does your car have a four wheel drive (y/n): ");
        in  = input.nextLine();
        ret.setFourWheelDrive(in.equalsIgnoreCase("y"));

        System.out.print("Does your car have a trunk engine (y/n): ");
        in  = input.nextLine();
        ret.setTrunkEngine(in.equalsIgnoreCase("y"));

        System.out.print("Does your car have four doors (y/n): ");
        in  = input.nextLine();
        ret.setFourDoors(in.equalsIgnoreCase("y"));

        System.out.print("Is your car luxury (y/n): ");
        in  = input.nextLine();
        ret.setLuxury(in.equalsIgnoreCase("y"));


        System.out.print("What color is your car: ");
        in  = input.nextLine();
        ret.setColor(in);

        return ret;
    }


    private static Motorcycle getMotorcycleDetails(Scanner input){
        Motorcycle ret = new Motorcycle();

        System.out.print("Does your motorcycle have a radio (y/n): ");
        String in  = input.nextLine();
        ret.setRadio(in.equalsIgnoreCase("y"));

        System.out.print("Is your motorcycle a Harley (y/n): ");
        in  = input.nextLine();
        ret.setHarley(in.equalsIgnoreCase("y"));

        System.out.print("What color is your Motorcycle: ");
        in  = input.nextLine();
        ret.setColor(in);

        return ret;
    }


}
