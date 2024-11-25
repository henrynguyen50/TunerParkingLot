import java.sql.*;
import java.util.*;
public class CarDatabaseUtil {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/tunerparkinglot";
    private static final String USER = "root"; // Replace with your MySQL username
    private static final String PASSWORD = "password"; // Replace with your MySQL password

    public static void insertCarsIntoDatabase(List<Car> cars) {
        String query = "INSERT INTO Cars (make, model, makeyear, color, modifications, photo_url) VALUES (?, ?, ?, ?, ?, ?)";

        //add cars into SQL database and add the cars descriptors
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(query)) {

            for (Car car : cars) {
                ps.setString(1, car.getMake());
                ps.setString(2, car.getModel());
                ps.setString(3, car.getYear());
                ps.setString(4, car.getColor());
                ps.setString(5, String.join(" ", car.getMods()));
                ps.setString(6, car.getPhotos());
                ps.addBatch(); // Add to batch for bulk insert
            }
            ps.executeBatch(); // Execute all inserts at once
            System.out.println("Cars inserted into database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Car> fetchCarsFromDatabase() {
        List<Car> cars = new ArrayList<>();
        String query = "SELECT make, model, makeyear, color, modifications, photo_url FROM Cars";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            //while having a next table row
            while (rs.next()) {
                String make = rs.getString("make");
                String model = rs.getString("model");
                String year = rs.getString("makeyear");
                String color = rs.getString("color");
                List<String> mods = Arrays.asList(rs.getString("modifications").split(" "));
                String photoUrl = rs.getString("photo_url");
                cars.add(new Car(make, model, year, color, mods, photoUrl));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }
    public static void loadDatabaseDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully.");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC driver not found.");
            e.printStackTrace();
        }
    }
}
