
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //load sql driver
        CarDatabaseUtil.loadDatabaseDriver();

        //Create list of cars from csv file
        List<Car> cars = FileReaderUtil.readCarsFromFile("cars.csv");
        //insert list of cars into SQL database
        CarDatabaseUtil.insertCarsIntoDatabase(cars);

        //create interface to view cars
        ImageDisplayUtil frame = new ImageDisplayUtil();
        frame.setVisible(true);
       
        //Create parking lot aka meetupspot with 20 spots 
        ParkingLot meetUpSpot = new ParkingLot(20);
        //get cars from SQL database
        List<Car> carsFromDB = CarDatabaseUtil.fetchCarsFromDatabase();

        //park all cars from SQL database into parkinglot
        for (Car car : carsFromDB) {
        meetUpSpot.parkCarInSpot(car);
        }
        
        meetUpSpot.displayAllCars(frame);
    }

    
}