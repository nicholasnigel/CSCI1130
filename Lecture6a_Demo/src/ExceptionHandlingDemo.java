
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pffung
 */
public class ExceptionHandlingDemo {
    
    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);
               
        int i = 0;
        boolean done = false;

        while ( !done )
        {
            try {
                System.out.print("Input i:");
                i = keyboard.nextInt();
                
                // if any exception happens, the following line will be skipped
                done = true;
                
                troubleMakingMethod();
            }
            catch (InputMismatchException   exp_obj)
            {
                // remedial action
                System.out.println("Invalid input!");

                System.out.println(exp_obj);
                exp_obj.printStackTrace();  // default to System.err
                exp_obj.printStackTrace(System.out);

                // get rid of rubbish in the keyboard input stream
                String stuck = keyboard.nextLine();
            }
            catch (Exception   exp_obj)
            {
                // remedial action
                System.out.println("This catches all kinds of Exceptions!");
                
                System.out.println(exp_obj);
            }
        }
        
        System.out.println("i square = " + i * i);
    }

    public static void troubleMakingMethod() throws ArithmeticException
    {
        ArithmeticException   obj;
        obj = new ArithmeticException("Michael Wok!");
        throw obj;
    }
}
