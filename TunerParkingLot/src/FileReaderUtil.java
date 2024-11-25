import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileReaderUtil {
    public static List<Car> readCarsFromFile(String filePath) {
        List<Car> cars = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            // Skip the header line
                scanner.nextLine();
            
            // Process each line
            while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",", 6); 

           
            String make = parts[0];
            String model = parts[1];
            String color = parts[2];
            String year = parts[3];
            List<String> mods = Arrays.asList(parts[4].replace("\"", "").split(","));  // Remove the quotes and split by commas
            String photoUrl = parts[5].trim(); // Ensure there are no extra spaces around the URL

            cars.add(new Car(make, model, year, color, mods, photoUrl));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return cars;
    }
}
