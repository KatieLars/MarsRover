import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartRovers {

    public static void printRoverFinishPoints () {
        for(Rover bot : Rover.allRovers) {
            System.out.println(bot.finishPoint);
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Mars! How many rovers do you have? ");
        Scanner reader = new Scanner(System.in);
        String roverString = reader.nextLine();
        int roverAmount = Integer.parseInt(roverString);
        int i = 1;
        while( i <= roverAmount) { //creates rovers
            System.out.println("Please enter starting coordinates for rover " + i);
            Scanner startReader = new Scanner(System.in);
            String startString = startReader.nextLine().toUpperCase();
            ArrayList startArray = new ArrayList<String>(Arrays.asList(startString.split(" ")));

            System.out.println("Please enter directions for rover " + i + " : ");
            Scanner directionsReader = new Scanner(System.in);
            String directionsString = directionsReader.nextLine().toUpperCase();
            ArrayList directionsArray = new ArrayList<String>(Arrays.asList(directionsString.split("")));
            Rover newRover = new Rover(startArray, directionsArray);

            i++;
        }

        printRoverFinishPoints();
    }
}
