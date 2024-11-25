public class ParkingSpot {
    private int spotNumber;
    private boolean isOccupied;
    private Car parkedCar;

    //constructor
    public ParkingSpot(int spotNumber) {
        this.spotNumber = spotNumber;
        this.isOccupied = false;
        this.parkedCar = null;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
    
    public boolean parkCar(Car car) {
        if(!isOccupied) {
            this.parkedCar = car;
            this.isOccupied = true;
            return true;
        }
        return false;
    }

    public void removeCar() {
        this.parkedCar = null;
        this.isOccupied = false;
    }

    public Car getParkedCar() {
        return parkedCar;
    }

    public int getSpotNumber() {
        return spotNumber;
    }


}
