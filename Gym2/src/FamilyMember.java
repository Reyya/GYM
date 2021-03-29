import java.util.Scanner;

public class FamilyMember extends Member{
    int numOfMembers;
    public void  howMembers(){
        System.out.print("the number of members in the family:  ");
        Scanner in = new Scanner(System.in);
        numOfMembers = in.nextInt();
    }
}
