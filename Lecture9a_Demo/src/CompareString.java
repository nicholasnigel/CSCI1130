import java.io.*;
import java.util.Scanner;

class CompareString {
    public static void main(String[] args) throws IOException {
        String myName     = "Michael";
        Scanner reservoir = new Scanner(System.in);
        System.out.println("What's your name? ");
        String yourName   = reservoir.next();
        
        System.out.println("*******************************************");
        
        System.out.println("Comparison using ==");
        if (myName == yourName)
            System.out.println("[EQUAL]   Uk...Oh...You're Michael too!");
        else
            System.out.println("[UNEQUAL] I'm Michael, What's up?!");
        
        System.out.println("*******************************************");
        
        System.out.println("Comparison using the method equals()");
        if (myName.equals(yourName))
            System.out.println("[EQUAL]   Uk...Oh...You're Michael too!");
        else
            System.out.println("[UNEQUAL] I'm Michael, What's up?!");
    }
}
