import java.util.ArrayList;
import java.util.Scanner;

public class Classes extends Services{
    String className;
    String instructor;
    String classStartTime;
    String classEndTime;
    String classTime;

    public void addClass() {
        System.out.print("Add A class: ");
        Scanner in = new Scanner(System.in);
        className = in.next();
        System.out.print("Set Instructor: ");
        instructor = in.next();
        System.out.print("Set Class Start Time: ");
        classStartTime = in.next();
        System.out.print("Set Class End Time: ");
        classEndTime = in.next();
        System.out.print("Set Class Total Time: ");
        classTime = in.next();
        System.out.print("Set Price: ");
        price = in.next();
    }


    public static void printClassesArray(ArrayList<Classes> classesArray) {
        for (int i = 0; i < classesArray.size(); i++) {
            System.out.println("Class # " + (i + 1));
            System.out.println("Class # " + (i + 1) + " Class name: " + classesArray.get(i).className);
            System.out.println("Class # " + (i + 1) + " Class instructor: " + classesArray.get(i).instructor);
            System.out.println("Class # " + (i + 1) + " Class Class Start Time: " + classesArray.get(i).classStartTime);
            System.out.println("Class # " + (i + 1) + " Class Class End Time: " + classesArray.get(i).classEndTime);
            System.out.println("Class # " + (i + 1) + " Class Time: " + classesArray.get(i).classTime);
            System.out.println("Class # " + (i + 1) + " Price: " + classesArray.get(i).price);
            System.out.println("---------------------------------------------");

        }
    }
    public static void printclasses(ArrayList<Classes> classesArray) {
        for (int i = 0; i < classesArray.size(); i++) {
            if(i==0)System.out.println("\n<<<----- All Classes ----------");
            System.out.println("Class #" + (i + 1) + " name is: " + classesArray.get(i).className);
            if(i==(classesArray.size()-1))System.out.println("--------------------------->>>\n");
        }
    }
}
