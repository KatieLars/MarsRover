import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;

public class Rover {

    public static List<Rover> allRovers = new ArrayList<Rover>();
    public static HashMap<String, ArrayList<String>> cardinals = new HashMap<String, ArrayList<String>>();

    List<Object> startPoint = new ArrayList<Object>();
    List<String> directions = new ArrayList<String>();
    List<Object> finishPoint = new ArrayList<Object>();

    public Rover(ArrayList start, ArrayList directionsArray ) {
        startPoint = start;
        directions = directionsArray;
        allRovers.add(this);
        generateCardinals();
        this.roverMoves();
    }

    public HashMap generateCardinals() {
        cardinals.put("N", new ArrayList<String>(Arrays.asList("W", "E")));
        cardinals.put("S", new ArrayList<String>(Arrays.asList("E", "W")));
        cardinals.put("E", new ArrayList<String>(Arrays.asList("N", "S")));
        cardinals.put("W", new ArrayList<String>(Arrays.asList("S", "N")));
        return cardinals;
    }

    public void roverMoves() {
        List<Object> currentLocation = startPoint;
        for(String direction: directions) {
            if (direction.equals("L") || direction.equals("R")) {
                List<String> newCardinals = cardinals.get(currentLocation.get(2));
                switch(direction) {
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
                        currentLocation.set(1, currentYValue + 1);
                        break;
                    case "S":
                        currentLocation.set(1, currentYValue - 1);
                        break;

                }
            }

        }
        finishPoint = currentLocation;
    }




}
//1 2 N
//LMLMLMLMM
//3 3 E
//MMRMMRMRRM