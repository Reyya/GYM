import java.util.ArrayList;

public class SingleMember extends Member {

    public static void printMembersArray(ArrayList<Member> membersArray) {
        for (int i = 0; i < membersArray.size(); i++) {
            System.out.print(" #" + (i + 1) + " member name: " + membersArray.get(i).fullName);
            System.out.println(" ----------- " + " Member id: " + membersArray.get(i).memberID);
            System.out.println("---------------------------------------------");

        }
    }

}
