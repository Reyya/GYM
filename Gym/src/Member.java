import java.lang.reflect.Array;
import java.security.Provider;
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
//    ArrayList<String> addedClass = new ArrayList<String>();
    String addedAmenity;
    String addedClass;

    public static void  registeredClass(ArrayList<Member> membersArray){
        for (int i = 0; i < membersArray.size(); i++){
            if(i==0) System.out.println("\n------- All Registered Classes -------");
            if(membersArray.get(i).addedClass != null)
            System.out.println("The Class " + membersArray.get(i).addedClass +" was added to "+ membersArray.get(i).memberID + " member");
            if(i== (membersArray.size()-1)) System.out.println("--------------------------------------\n");}
    }
    public static void  registeredAmenity(ArrayList<Member> membersArray){
        for (int i = 0; i < membersArray.size(); i++){
            if(i==0) System.out.println("\n------- All Registered Amenity -------");
            if(membersArray.get(i).addedAmenity != null)
                System.out.println("The Amenity " + membersArray.get(i).addedAmenity +" was added to "+ membersArray.get(i).memberID + " member");
            if(i== (membersArray.size()-1)) System.out.println("--------------------------------------\n");}
    }

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

        System.out.print("Date of Regestration (dd/mm/yyyy): ");
        dateOfRegistration = this.parseDate(in.next());

        System.out.print("Address (Alsamer/AlKhaldiah...etc): ");
        address = in.next();

        System.out.print("Phone(+9665xxxxxxxx): ");
        phone = in.next();

        System.out.print("Membership Type (VIP/Regular): ");
        membershipType = in.next();

    }
    public void getMemberDetails() {

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


//        String str = new String();
//        Scanner sc = new Scanner(System.in);
//        str = sc.nextLine();
//        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//        sdf.setLenient(false);
//        try {
//            Date d1 = sdf.parse(str);
////            System.out.println("TRUE");
//        } catch (Exception e) {
//            System.out.println("Enter Date of Birth in this format pleas (DD/MM/YYYY): ");
//            str = sc.nextLine();
//        }

//    public static void val (ArrayList<Member> membersArray){
//
//        Scanner in = new Scanner(System.in);
//        int selectedMember = in.nextInt();
//        boolean n = true;
//        for(int i =0; i< membersArray.size(); i++)
//            if(selectedMember != membersArray.get(i).memberID)
//                n = false;
//
//        if (!n) {
//            System.out.print("Please Select A valid ID");
//            val(membersArray);
//        }
//    }


}