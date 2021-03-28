import java.text.DateFormat;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Main {


    public static void main(String[] args) {

        ArrayList<Member> membersArray = new ArrayList<Member>();

        ArrayList<Classes> classesArray = new ArrayList<Classes>();
        Classes classes1 = new Classes();
        classes1.className ="cardio";
        classes1.instructor = "Ahmed";
        classes1.classStartTime = " 8 am ";
        classes1.classEndTime = " 9 am ";
        classes1.classTime =" 1 hour ";
        classes1.price = " 50 RS / month";
        classesArray.add(classes1);
        Classes classes2 = new Classes();
        classes2.className ="cycling";
        classes2.instructor = "Khalid";
        classes2.classStartTime = " 9 am ";
        classes2.classEndTime = " 11 am ";
        classes2.classTime =" 2 hours ";
        classes2.price = " 30 RS / month";
        classesArray.add(classes2);

        ArrayList<Amenity> amenitiesArray = new ArrayList<Amenity>();
        Amenity amenity1 = new Amenity();
        amenity1.amenityName = "swimming-pool";
        amenity1.availableHours =" 2 hours ";
        amenity1.price = " 100 RS /month";
        amenitiesArray.add(amenity1);
        Amenity amenity2 = new Amenity();
        amenity2.amenityName = "steam-room";
        amenity2.availableHours =" 3 hours ";
        amenity2.price = " 150 RS /month";
        amenitiesArray.add(amenity2);

        int memberId = 1000;

        boolean complete = true;

        while (complete) {
            System.out.print("--------------- Welcome to Gym Management System ---------------\n" +
                    "1- Add a single member\n" +
                    "2- Add a family member\n" +
                    "3- Add a class\n" +
                    "4- Add an amenity\n" +
                    "5- Register a member\n" +
                    "6- Print sort classes\n" +
                    "7- Print sort amenities\n" +
                    "--------------------------------------------\n" +
                    "Please select an option: ");

            //A scanner to get the selected operation from the user
            Scanner in = new Scanner(System.in);
            int menuOption = in.nextInt();

            //Validate the user input and make sure the selected number is among the available options
            while (menuOption < 1 || menuOption > 7) {
                System.out.println("Please select a valid option!");
            }

            if (menuOption == 1) {
                System.out.println("***************Adding Single Members**************");
                System.out.print("How many single members do you want to add? ");
                int newMembersCount = in.nextInt();

                for (int i = 1; i <= newMembersCount; i++) {
                    System.out.println("\n<< Single member #" + i + " >>\n");
                    SingleMember newMember = new SingleMember();
                    newMember.addMember();
                    newMember.memberID = memberId + 1;
                    memberId++;
                    membersArray.add(newMember);

                }
                for (int i = newMembersCount; i >= 1; i--)
                    System.out.println("sMemberID is: " + (memberId + 1 - i));
                System.out.println("--------------------------------------------------------");
                System.out.println("Member arrayList size is " + membersArray.size());
                System.out.println("--------------------------------------------------------");
                System.out.println("*******All Single Members were successfully added*******");
                System.out.println("--------------------------------------------------------\n");

                SingleMember.printMembersArray(membersArray);

            }

            if (menuOption == 2) {
                System.out.println("***************Adding Family Members**************");
                FamilyMember newMember = new FamilyMember();
                newMember.howMembers();
                int temp = newMember.numOfMembers;
                for (int i = 1; i <= temp; i++) {
                    System.out.println("\n<< Adding the  #" + i + " member >>\n");
                    newMember.addMember();
                    newMember.memberID = memberId + 1;
                    memberId++;
                    membersArray.add(newMember);
                }
                for (int i = temp; i >= 1; i--)
                    System.out.println("MemberID of #" + (i - i + 1) + " member is: " + (memberId + 1 - i));
                System.out.println("--------------------------------------------------------");
                System.out.println("Member arrayList size is " + membersArray.size());
                System.out.println("--------------------------------------------------------");
                System.out.println("*******All Family Members were successfully added*******");
                System.out.println("--------------------------------------------------------\n");
            }

            if (menuOption == 3) {
                System.out.println("***************Adding A Class**************");
                System.out.print("How many Classes do you want to add? ");
                int newClassesCount = in.nextInt();
                for (int i = 1; i <= newClassesCount; i++) {
                    System.out.println("\n<< Class #" + i + " >>\n");
                    Classes classes = new Classes();
                    classes.addClass();
//                    classes.classID = classId + 1;
//                    classId ++;
                    classesArray.add(classes);

                }
            }
            if (menuOption == 4) {
                System.out.println("***************Adding An Amenity**************");
                System.out.print("How many Amenity do you want to add? ");
                int newAmenityCount = in.nextInt();
                for (int i = 1; i <= newAmenityCount; i++) {
                    System.out.println("\n<< Amenity #" + i + " >>\n");
                    Amenity amenity = new Amenity();
                    amenity.addAmenity();
//                    amenity.amenityID = amenityId + 1;
//                    amenityId++;
                    amenitiesArray.add(amenity);
                }
            }
            if (menuOption == 5) {
                System.out.println("***************Registering A member in a services**************");
                SingleMember.printMembersArray(membersArray);
                System.out.print("Select A member by entering member's id: ");
                int selectedMember = in.nextInt();
                System.out.print("In which Service do you want to register ? Class or Amenity ? ");
                String SelectedService = in.next();
                while (!(SelectedService.equalsIgnoreCase("class") || SelectedService.equalsIgnoreCase("Amenity"))) {
                    System.out.print("Please Select Class or Amenity ?");
                    SelectedService = in.next();
                }
                if (SelectedService.equalsIgnoreCase("class")) {
                    Classes.printclasses(classesArray);
                    System.out.print("Please Select A Class, by entering class name..");
                    String SelectedClass = in.next();

                    for (int i = 0; i < membersArray.size(); i++) {
                        if (selectedMember == membersArray.get(i).memberID){
                            membersArray.get(i).addedClass = SelectedClass;
                        System.out.println("\n ~~ The Class " + membersArray.get(i).addedClass +" was added to "+ membersArray.get(i).memberID + " member ~~ ");}
                    }
                }



                else if (SelectedService.equalsIgnoreCase("amenity")) {
                    Amenity.printAmenities(amenitiesArray);
                    System.out.print("Please Select A amenity, by entering Amenity name..");
                    String SelectedAmenity = in.next();
                    for (int i = 0; i < membersArray.size(); i++) {
                        if (selectedMember == membersArray.get(i).memberID){
                            membersArray.get(i).addedAmenity = SelectedAmenity;
                            System.out.println("\n ~~ The Amenity " + membersArray.get(i).addedAmenity +" was added to "+ membersArray.get(i).memberID + " member ~~ ");}
                    }
                }

                Member.registeredClass(membersArray);
                Member.registeredAmenity(membersArray);


            }

            if (menuOption == 6) {
                System.out.println("*************** Printing sort classes **************");

                Classes.printArray(classesArray);
            }

            if (menuOption == 7) {
                System.out.println("*************** Printing sort Amenities **************");

                Amenity.printArray(amenitiesArray);
            }


            System.out.println("Do you still want to continue? (y/n)");
            String shouldContinue = in.next().toLowerCase();
            while (!(shouldContinue.contains("y") || shouldContinue.contains("n"))) {
                System.out.println("Do you still want to continue? (y/n)");
                shouldContinue = in.next().toLowerCase();
            }

            if (shouldContinue.equals("n")) {
                complete = false;
            }

        }
    }
}
