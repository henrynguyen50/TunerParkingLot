import java.util.*;

public class ParkingLot {
    private List<ParkingSpot> spots;

    //initialize new parking lot and add spaces
    public ParkingLot(int totalSpots) {
        spots = new ArrayList<>();
        for(int i = 1; i <= totalSpots; i++) {
            spots.add(new ParkingSpot(i));
        }
    }


    //attempt to park car if spot open return false or true

    public boolean parkCarInSpot(Car car) {
        for(ParkingSpot spot : spots) {
            if(!spot.isOccupied()) {
                spot.parkCar(car);
                return true;
            }
        }
        return false;
    }

     // Display details of all parked cars
     public void displayAllCars(ImageDisplayUtil frame) {
        boolean anyCarDisplayed = false;

        // for all spots print car in it and its identifiers
        for (ParkingSpot spot : spots) {
            if (spot.isOccupied()) {
                Car car = spot.getParkedCar();
                String carDetails = new StringBuilder().append(car.getColor()).append(" ")
                .append(car.getYear()).append(" ")
                .append(car.getMake()).append(" ")
                .append(car.getModel()).append(" ")
                .append("\nMods: ").append(car.getMods()).append(" ")
                .toString();
                frame.addImageWithCaption(car.getPhotos(), carDetails);
                anyCarDisplayed = true;
            }
        }

        if (!anyCarDisplayed) {
            System.out.println("No cars are currently parked.");
        }
    }

}
