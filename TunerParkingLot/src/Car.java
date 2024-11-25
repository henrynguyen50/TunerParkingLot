import java.util.*;


public class Car {
    public static int getMake;
    public static int getModel;
    private String make;
    private String model;
    private String color;
    private String year;
    private List<String> modifications;
    private String photos;

    //constructor
    public Car(String make, String model, String color, String year, List<String> modifications, String photos) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.modifications = modifications;
        this.photos = photos;
    }

    //getters
    public String getMake() { return make; };
    public String getModel(){ return model;};
    public String getColor(){ return color;};
    public String getYear(){ return year;};
    public List<String> getMods(){ return modifications; };
    public String getPhotos(){ return photos;};
    //setters
    public void setMake(String make) { this.make = make; };
    public void setModel(String model){ this.model = model;};
    public void setColor(String color){ this.color = color;};
    public void setYear(String year){ this.year = year;};
    public void setMods(List<String> modifications){ this.modifications = modifications; };
    public void setPhotos(String photos){ this.photos = photos;};
    


}
