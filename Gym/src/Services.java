import java.util.Scanner;

public class  Services {
    String price;

     void selectingAservic(){
        Scanner in = new Scanner(System.in);
        String SelectedService = in.next();
        while (!(SelectedService.equalsIgnoreCase("class") || SelectedService.equalsIgnoreCase("Amenity"))){
            System.out.print("Please Select Class or Amenity ?");
            SelectedService = in.next();}

    }
}
