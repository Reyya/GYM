import java.util.Scanner;
import java.util.ArrayList;

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
                System.out.print("Please select a valid option!");
                menuOption = in.nextInt();
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
                for (int i = newMembersCount; i >= 1; i--) {
                    if (newMembersCount == 1) System.out.println("sMemberID is: " + (memberId + 1 - i));
                    else System.out.println("MemberID of #" + (newMembersCount-i+1) + " member is: " + (memberId + 1 - i));
                }
                System.out.println("--------------------------------------------------------");
                System.out.println("Member arrayList size is " + membersArray.size());
                System.out.println("--------------------------------------------------------");
                System.out.println("*******All Single Members were successfully added*******");
                System.out.println("--------------------------------------------------------\n");
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
                    System.out.println("MemberID of #" + (temp-i+1) + " member is: " + (memberId + 1 - i));
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
                    amenitiesArray.add(amenity);
                }
            }
            if (menuOption == 5) {
                boolean want = true;
                while (want){
                System.out.println("***************Registering A member in a services**************");
                Member.printMembersArray(membersArray);
                System.out.print("Select A member by entering member's id: ");
                int selectedMember = in.nextInt();

                boolean v = true;
                while (v) {
                    for (int i = 0; i < membersArray.size(); i++) {
                        if (selectedMember == membersArray.get(i).memberID)
                            v = false;
                    }
                    if (v) {
                        System.out.print("Select A Valid member by entering member's id: ");
                        selectedMember = in.nextInt();
                    }
                }

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

                    boolean m = true;
                    while (m) {
                        for (int i = 0; i < classesArray.size(); i++) {
                            if (SelectedClass.equalsIgnoreCase(classesArray.get(i).className))
                                m = false;
                        }
                        if (m) {
                            System.out.print("Select A Valid Class ");
                            SelectedClass = in.next();
                        }
                    }


                    for (int i = 0; i < membersArray.size(); i++) {
                        if (selectedMember == membersArray.get(i).memberID) {
                            membersArray.get(i).addedClassesArray.add(SelectedClass);
                            System.out.println("\n ~~ The Class " + SelectedClass + " was successfully added to " + membersArray.get(i).memberID + " member ~~ ");
                        }
                    }
                    Member.registeredClass(membersArray);
                    Member.registeredAmenity(membersArray);

                    System.out.print("Do you want to continue registering members in services ? (y/n) ");
                    String regLoop = in.next().toLowerCase();
                    while (!(regLoop.contains("y") || regLoop.contains("n"))) {
                        System.out.print("Do you want to continue registering members in services ? (y/n)" +
                                " Please select a valid option.. ");
                        regLoop = in.next().toLowerCase();
                    }

                    if (regLoop.equals("n")) {
                        want = false;
                    }

                } else if (SelectedService.equalsIgnoreCase("amenity")) {
                    Amenity.printAmenities(amenitiesArray);
                    System.out.print("Please Select A amenity, by entering Amenity name..");
                    String SelectedAmenity = in.next();
                    boolean a = true;
                    while (a) {
                        for (int i = 0; i < amenitiesArray.size(); i++) {
                            if (SelectedAmenity.equalsIgnoreCase(amenitiesArray.get(i).amenityName))
                                a = false;
                        }
                        if (a) {
                            System.out.print("Select A Valid Amenity ... ");
                            SelectedAmenity = in.next();
                        }
                    }

                    for (int i = 0; i < membersArray.size(); i++) {
                        if (selectedMember == membersArray.get(i).memberID) {
                            membersArray.get(i).addedAmenitiesArray.add(SelectedAmenity);
                            System.out.println("\n ~~ The Amenity " + SelectedAmenity + " was successfully added to " + membersArray.get(i).memberID + " member ~~ ");
                        }
                    }
                    Member.registeredClass(membersArray);
                    Member.registeredAmenity(membersArray);

                    System.out.print("Do you want to continue registering members in services ? (y/n) ");
                    String regLoop = in.next().toLowerCase();
                    while (!(regLoop.contains("y") || regLoop.contains("n"))) {
                        System.out.print("Do you want to continue registering members in services ? (y/n)" +
                                " Please select a valid option.. ");
                        regLoop = in.next().toLowerCase();
                    }

                    if (regLoop.equals("n")) {
                        want = false;
                    }
                }

            }
            }

            if (menuOption == 6) {
                System.out.println("*************** Printing sort classes **************");
                Classes.printClassesArray(classesArray);
            }

            if (menuOption == 7) {
                System.out.println("*************** Printing sort Amenities **************");
                Amenity.printAmenitiesArray(amenitiesArray);
            }


            System.out.print("Do you still want to continue? (y/n) ");
            String shouldContinue = in.next().toLowerCase();
            while (!(shouldContinue.contains("y") || shouldContinue.contains("n"))) {
                System.out.print("Do you still want to continue? (y/n) ");
                shouldContinue = in.next().toLowerCase();
            }

            if (shouldContinue.equals("n")) {
                complete = false;
            }

        }
    }
}
