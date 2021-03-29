import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Member {

    public int memberID;
    String fullName;
    String gender;
    Date dateOfBirth;
    Date dateOfRegistration;
    String address;
    String phone;
    String membershipType;
    static ArrayList<String> addedClassesArray = new ArrayList<String>();
    static ArrayList<String> addedAmenitiesArray = new ArrayList<String>();

    public void addMember() {

        Scanner in = new Scanner(System.in);

        System.out.println("Please enter the following data:");
        System.out.print("Full Name (Separated by an underscore): ");
        fullName = in.next();
        while((!(fullName.contains("_"))) ||
                (fullName.substring(fullName.length()-1, fullName.length()).contains("_")) ||
                (fullName.substring(0,1).contains("_")))
        {System.out.print("Please enter your Full Name (Separated by an underscore): ");
            fullName = in.next();}

        System.out.print("Gender: ");
        gender = in.next();

        System.out.print("Date of Birth (dd/mm/yyyy): ");
        dateOfBirth = this.parseDate(in.next());

        System.out.print("Date of Registration (dd/mm/yyyy): ");
        dateOfRegistration = this.parseDate(in.next());

        System.out.print("Address (Alsamer/AlKhaldiah...etc): ");
        address = in.next();

        System.out.print("Phone(+9665xxxxxxxx): ");
        phone = in.next();

        System.out.print("Membership Type (VIP/Regular): ");
        membershipType = in.next();

    }



        public static void printMembersArray(ArrayList<Member> membersArray) {
            for (int i = 0; i < membersArray.size(); i++) {
                System.out.print(" #" + (i + 1) + " member name: " + membersArray.get(i).fullName);
                System.out.println(" ----------- " + " Member id: " + membersArray.get(i).memberID);
                System.out.println("---------------------------------------------");

            }
        }


    //To Print registered Classes
    public static void  registeredClass(ArrayList<Member> membersArray){
        for (int i = 0; i < membersArray.size(); i++){
            if(i==0) System.out.println("\n-------- All Registered Classes --------");
            if(membersArray.get(i).addedClassesArray != null)
                for (int x = 0; x < addedClassesArray.size(); x++)
                    System.out.println("The Class " + membersArray.get(i).addedClassesArray.get(x) +" was added to "+ membersArray.get(i).memberID + " member");
            if(i== (membersArray.size()-1)) System.out.println("----------------------------------------\n");}
    }
    //To Print registered Amenities
    public static void  registeredAmenity(ArrayList<Member> membersArray){
        for (int i = 0; i < membersArray.size(); i++){
            if(i==0) System.out.println("\n------- All Registered Amenities -------");
            if(membersArray.get(i).addedAmenitiesArray != null)
                for (int x = 0; x < addedAmenitiesArray.size(); x++)
                    System.out.println("The Amenity " + membersArray.get(i).addedAmenitiesArray.get(x) +" was added to "+ membersArray.get(i).memberID + " member");
            if(i== (membersArray.size()-1)) System.out.println("--------------------------------------\n");}
    }

    private Date parseDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        sdf.setLenient(false);
        Date parsedDate = new Date();
        try {
            parsedDate = sdf.parse(date);
        } catch (Exception e) {
            System.out.println("Invalid date format!");
        }

        return parsedDate;
    }
}