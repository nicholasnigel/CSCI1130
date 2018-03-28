package csp;

/**
 * CSCI1130 Assignment 3 CSP Solver.
 *
 * I declare that the assignment here submitted is original
 * except for source material explicitly acknowledged,
 * and that the same or closely related material has not been
 * previously submitted for another course.
 * I also acknowledge that I am aware of University policy and
 * regulations on honesty in academic work, and of the disciplinary
 * guidelines and procedures applicable to breaches of such
 * policy and regulations, as contained in the website.
 *
 * University Guideline on Academic Honesty:
 *   http://www.cuhk.edu.hk/policy/academichonesty
 * Faculty of Engineering Guidelines to Academic Honesty:
 *   https://www.erg.cuhk.edu.hk/erg/AcademicHonesty
 *
 * Student Name: Nigel Nicholas
 * Student ID  : 1155088791
 * Date        : 20 October 2017
 */

/**
 * Constraint Satisfaction Problem Solver
 * @author pffung
 */
public class CSPSolver {

    // class field userWindow for keeping an object reference
    private static ConstraintInputBox userWindow;
    
    /**
     * Starting method of the application.
     * @param args is an array of command line arguments, not used here
     */
    public static void main(String[] args) {
        // create a new InputBox object, named userWindow
        userWindow = new ConstraintInputBox();
        
        // afterwards, the Java GUI system will take over the control
        
        // the following methods be invoked then
    }
    
    /**
     * The InputBox will handle user interactions.
     * On clicking the Randomize! button, CSPSolver.randomize() will be invoked.
     */
    public static void randomize() {
        // Students should complete this method to finish the assignment

        // Generate and set RANDOMLY Constraints 1 - 3 coefficients A, B, C.
        // The random number range is specified by the user.
        
        // sample statements for your reference:
        int minRandomRange = userWindow.getMinRandomRange();
        int maxRandomRange = userWindow.getMaxRandomRange();
        
        // dummy examples:
        userWindow.set1A((int)(Math.random()*(maxRandomRange-minRandomRange+1))+minRandomRange);
        userWindow.set1B((int)(Math.random()*(maxRandomRange-minRandomRange+1))+minRandomRange);
        userWindow.set1C((int)(Math.random()*(maxRandomRange-minRandomRange+1))+minRandomRange);
        
        userWindow.set2A((int)(Math.random()*(maxRandomRange-minRandomRange+1))+minRandomRange);
        userWindow.set2B((int)(Math.random()*(maxRandomRange-minRandomRange+1))+minRandomRange);
        userWindow.set2C((int)(Math.random()*(maxRandomRange-minRandomRange+1))+minRandomRange);
        
        userWindow.set3A((int)(Math.random()*(maxRandomRange-minRandomRange+1))+minRandomRange);
        userWindow.set3B(((int)(Math.random()*(maxRandomRange-minRandomRange+1))+minRandomRange));
        userWindow.set3C((int)(Math.random()*(maxRandomRange-minRandomRange+1))+minRandomRange);
        
    }

    /**
     * The InputBox will handle user interactions.
     * On clicking the Solve! button, CSPSolver.calculate() will be invoked.
     */
    public static void calculate() {
        // Students should complete this method to finish the assignment
        
        // sample statements for your reference:
        // To get coefficients of the contraint equations on userWindow.
        int c1A = userWindow.get1A();
        int c1B = userWindow.get1B();
        int c1C = userWindow.get1C();
        int c2A = userWindow.get2A();
        int c2B = userWindow.get2B();
        int c2C = userWindow.get2C();
        int c3A = userWindow.get3A();
        int c3B = userWindow.get3B();
        int c3C = userWindow.get3C();
       
        
        
        
        // declare object variables, and
        // create three Constraint equation objects
        // labelled as "First", "Second" and "Third"
        Constraint c1;
        Constraint c2;
        Constraint c3;
        c1 = new Constraint("First", c1A, c1B, c1C);
        c2 = new Constraint("Second",c2A, c2B, c2C);
        c3 = new Constraint("Third", c3A, c3B, c3C);
        // ...
        
        //adopt the range x, range y, and range z for the looping later on
        
        int xRange,yRange,zRange;
        
        xRange = userWindow.getxRange();
        yRange = userWindow.getyRange();
        zRange = userWindow.getzRange();
        
        int x_max, y_max, z_max; //to get replaced by x y and z once a certain constraint is met
        int x, y, z ;       //x and y and z are used to loop from 1 to xRange, yRange, zRange
        
        x_max = -1;
        y_max = -1;
        z_max = -1;
        
        
        for(x=1; x<=xRange; x++){
            for(y=1; y<=yRange; y++){
                for(z=1; z<=zRange; z++){
                    //if it satisfies all the constraints then you should store the corresponding x,y,and z to the x_max,y_max, and z_max
                    
                    if( c1.evaluate(x, y, z) && c2.evaluate(x, y, z)&& c3.evaluate(x, y, z)){
                        
                        x_max = x;
                        y_max = y;
                        z_max = z;
                    }
                }
            }
        }
        if( (x_max == -1) && (y_max == -1) && (z_max == -1)){
            userWindow.displayNoSolution();
        }

        else{
            
            userWindow.displaySolution(x_max , y_max , z_max);
            
        }

// Statement in the window output

    if( x_max==-1 && y_max==-1 && z_max==-1){
        System.out.printf("Combination (x = %d, y = %d, z = %d): ", x_max, y_max, z_max);
        System.out.println("Failed " + c1.getLabel() + " Constraint " + c1);
        System.out.printf("Combination (x = %d, y = %d, z = %d): ", x_max, y_max, z_max);
        System.out.println("Failed " + c2.getLabel() + " Constraint " + c2);
        System.out.printf("Combination (x = %d, y = %d, z = %d): ", x_max, y_max, z_max);
        System.out.println("Failed " + c3.getLabel() + " Constraint " + c3);
    }

    else{
        System.out.printf("Combination (x = %d, y = %d, z = %d): ", x_max, y_max, z_max);
        System.out.println("Satisfies " + c1.getLabel() + " Constraint " + c1.toString());
        System.out.printf("Combination (x = %d, y = %d, z = %d): ", x_max, y_max, z_max);
        System.out.println("Satisfies " + c2.getLabel() + " Constraint " + c2.toString());
        System.out.printf("Combination (x = %d, y = %d, z = %d): ", x_max, y_max, z_max);
        System.out.println("Satisfies " + c3.getLabel() + " Constraint " + c3.toString());
    }







// Generate-and-Test
        // evaluate the Constraint equations with proposed solutions
        /*int x, y, z;

        // SAMPLE code with an EXAMPLE x, y, z combination for your reference
        x = 7;
        y = 9;
        z = 9;
        System.out.printf("Combination (x = %d, y = %d, z = %d): ", x, y, z);
        if (c1.evaluate(x, y, z))
        {
            System.out.println("Satisfies " + c1.getLabel() + " Constraint " + c1.toString());
            userWindow.displaySolution(x, y, z);
        }
        else
        {
            // c1.toString() will be invoked implicitly when we "print" an object
            System.out.println("Failed " + c1.getLabel() + " Constraint " + c1);
            userWindow.displayNoSolution();
        }*/
        /*int xRange;       finding xRange
        xRange= userWindow.getxRange();
        System.out.printf("%d",xRange);*/
        
        // try different combinations of x, y, z
        // test c1 AND c2 AND c3
        
        // println/ printf statements are optional
        // display your result on userWindow
        
    }
}
