import java.util.ArrayList;
import java.util.Scanner;

public class Amenity extends Services{
    String amenityName;
    String availableHours;

    public void addAmenity() {
        System.out.print("Add An Amenity: ");
        Scanner in = new Scanner(System.in);
        amenityName = in.next();
        System.out.print("Set Available Hours: ");
        availableHours = in.next();
        System.out.print("Set Price: ");
        price = in.next();

    }
    public static void printAmenitiesArray(ArrayList<Amenity> amenitiesArray) {
        for (int i = 0; i < amenitiesArray.size(); i++) {
            System.out.println("Amenity # " + (i + 1));
            System.out.println("Amenity # " + (i + 1) + " Amenity name: " + amenitiesArray.get(i).amenityName);
            System.out.println("Amenity # " + (i + 1) + " Available Hours: " + amenitiesArray.get(i).availableHours);
            System.out.println("Amenity # " + (i + 1) + " Price " + amenitiesArray.get(i).price);
            System.out.println("---------------------------------------------");

        }
    }

    public static void printAmenities(ArrayList<Amenity> amenitiesArray) {
        for (int i = 0; i < amenitiesArray.size(); i++) {

            System.out.println("Amenity #" + (i + 1) + " name is: " + amenitiesArray.get(i).amenityName);
        }
    }


}
