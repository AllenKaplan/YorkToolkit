package YorkToolkit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Launcher {
    public static void main (String args[]){
        System.out.println("Please enter your class file name");
        Scanner inputScanner = new Scanner(System.in);
        String userInput = inputScanner.nextLine();
        File classFile = new File(userInput);
        Scanner classFileScanner = null;

        do {
            try {
                classFileScanner = new Scanner(classFile);
            } catch (FileNotFoundException e) {
                System.out.println("File not found... Please enter again");
                userInput = inputScanner.nextLine();
                classFile = new File(userInput);
            }
        }while(classFileScanner == null);
        Courses myCourses = new Courses(classFileScanner);
        System.out.println("You have completed: " + myCourses.getTotalCredits() + " credits");
        System.out.println("Your average is: " + myCourses.getAverageOfAll());
    }
}
