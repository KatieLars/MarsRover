import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class Rover {

    public static ArrayList allRovers = new ArrayList<>();
    public static HashMap<String, ArrayList<String>> cardinals = new HashMap<String, ArrayList<String>>();

    ArrayList startPoint = new ArrayList<>();
    ArrayList directions = new ArrayList<>();

    public Rover(ArrayList start, ArrayList directionsArray ) {
        startPoint = start;
        directions = directionsArray;
        allRovers.add(this);
        generateCardinals();
        this.roverMoves();
    }

    public HashMap generateCardinals() {
        cardinals.put("N", new ArrayList<String>(Arrays.asList("W", "E")));
        cardinals.put("S", new ArrayList<String>(Arrays.asList("W", "E")));
        cardinals.put("E", new ArrayList<String>(Arrays.asList("N", "S")));
        cardinals.put("W", new ArrayList<String>(Arrays.asList("S", "N")));
        return cardinals;
    }

    public void roverMoves() {
        ArrayList currentLocation = startPoint;

        for(Object direction: directions) {
            String directionString = String.valueOf(direction); //converts direction el to string
            if (directionString == "L" || directionString == "R") {
                //change  the value of cardinal direction in currentLocation
                ArrayList newCardinals = cardinals.get(currentLocation.get(2));
                switch(directionString) {
                    case "L":
                        currentLocation.set(2, newCardinals.get(0) );
                        break;
                    case "R":
                        currentLocation.set(2, newCardinals.get(1) );
                        break;
                };

            } else {
                String currentCardinalString = String.valueOf(currentLocation.get(2));
                int currentXValue = Integer.parseInt(String.valueOf(currentLocation.get(0)));
                int currentYValue = Integer.parseInt(String.valueOf(currentLocation.get(1)));

                switch(currentCardinalString) {
                    case "E":
                        currentLocation.set(0, currentXValue + 1);
                        break;
                    case "W":
                        currentLocation.set(0, currentXValue - 1);
                        break;
                    case "N":
                        currentLocation.set(0, currentYValue + 1);
                        break;
                    case "S":
                        currentLocation.set(0, currentYValue - 1);
                        break;

                }
            }

        }
        System.out.println(currentLocation);
    }




}

