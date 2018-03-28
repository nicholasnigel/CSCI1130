import java.io.*;
import javax.swing.JOptionPane;

class ExceptionDemo
{
	// a method finding tangent value of an angle in DEGREE
        // this method may cause TWO kinds of exceptions, as declared:
	private static double tan(double angle) throws IOException, ArithmeticException
	{
	  if (angle == 90)			// tan 90 = infinity!
	    throw new ArithmeticException("Ooops, angle = 90");
	    
	  // we mimic some error randomly, with a 0.5 probability
	  boolean read_4_figure_table_error = Math.random() > 0.5;
	  
	  if (read_4_figure_table_error)
	    throw new IOException("Ooops, cannot read 4 figure table");
	    
	  // normal operation
	  return Math.tan(angle * 180 / Math.PI);
	}



	public static void main(String[] args)
	{
	  // get angle in degree from user
          String input = JOptionPane.showInputDialog("Please input an angle in degree:");
	  double angle = Double.parseDouble(input);
	  System.out.println("Input angle in degree = " + angle);

	  // demonstrate the twins: try and catch block
	  double value;  // declare this variable OUTSIDE the try block
          
	  try {
	    value = tan(angle);      // this may throw an exception
	    value = value * 3.14159; // wow wow, may be skipped
	    System.out.println("normal value = " + value);
	  }
          // catch TWO kinds of exceptions for the try block
	  catch (IOException io_exception_object_ref) {
	    System.out.println("Input Output Exception received!");
            System.out.println(io_exception_object_ref);
	    value = 3.14159;
	  }
	  catch (ArithmeticException arithmetic_exception_object_ref) {
	    System.out.println("Arithmetic Exception received!");
            System.out.println(arithmetic_exception_object_ref);
	    value = 0.0;
	  }
	  
          
          
	  // the program continues normally hereafter no matter if any exception was caught
	  double result = value + 19 * 97 - 2006;
	  System.out.println("value  = tangent(angle) = " + value);
	  System.out.println("result = " + result);
	  System.out.println("Program finished gracefully!");
	}
}	
