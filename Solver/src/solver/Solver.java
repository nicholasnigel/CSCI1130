package solver;



/**
 * CSCI1130 Assignment 2 Equation Solver, finding minimal cost.
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
 * Date        : October 3rd 2017
 */

public class Solver {
    
    // class field keeping an object reference of class/type EquationInputBox
    private static EquationInputBox userWindow;
    
    /**
     * Starting method of the application.
     * @param args is an array of command line arguments, not used here
     */
    public static void main(String[] args) {
        // create a new EquationInputBox object, named userWindow
        userWindow = new EquationInputBox();
        
        // afterwards, the Java GUI system will take over the control
        
        // the following calculate() method be invoked then
    }
    
    /**
     * The EquationInputBox will handle user interactions.
     * On clicking the Solve! button, Solver.calculate() will be invoked
     */
    public static void calculate() {
        // Students should complete this method to finish the assignment
        
        
        
       
        double a,b,c,d; //all the variables, a,b,c corresponds to the ones in the taskbar
        double root1_x = 0, root2_x = 0, min_x = 0; /* root1 and root2 for the solution using the quadratic eq
                                           min_x to store the root if x does exist
                                           minimum to make sure that the cost will be minimum
                                           if x is minimum
        */
       double p,q,r,y1,y2,cost1, cost2;  //p q and r are the ones requested in the java box
        
        a = userWindow.getA();
        b = userWindow.getB();
        c = userWindow.getC();  //these 3 are to get the values of a,b, and c
        
        if(a==0 && b==0){   //case if both a and b are 0
            userWindow.displayManySolutions();  //if both a and b are 0, the function will have many solutions
            
        }
        
        else if(a!=0){  //case if a is quadratic
            d= (b*b) -(4*a*(-1*c));    //discriminant = b^2 -4ac
            if(d<0){
                userWindow.displayNoSolution(); //if discriminant is negative , there shouldnt be any
                                                //real root, and display no solution then exit 
                
            }
            else{
            root1_x = ( -b + Math.sqrt(d))/(2*a);
            
            root2_x = ( -b + Math.sqrt(d))/(2*a);   //root 1 and 2 is the form of quadratic equation   
            
            
        
        
        
        p = userWindow.getP();
        q = userWindow.getQ();
        r = userWindow.getR();  //all 3 lines are to get the value of the second equation
        
        /*
           Since the second equation is  px+ qy =  r, therefore y= (r-px)/q
        */
        y1 = (r-p*root1_x)/q;
        y2 = (r-p*root2_x)/q;
        
        cost1= y1 * root1_x;
        cost2= y2 * root2_x;
        
        if(cost1 > cost2){
            userWindow.displaySolution(cost2);    
        }
        else 
            userWindow.displaySolution(cost1);
            
            
        }
            
        }
        
        else if(a==0){      //the equation becomes linear if a becomes 0
            
        root1_x = c/b;
            
        p = userWindow.getP();
        q = userWindow.getQ();
        r = userWindow.getR();  //all 3 lines are to get the value of the second equation
        
        /*
           Since the second equation is  px+ qy =  r, therefore y= (r-px)/q
        */
        y1 = (r-p*root1_x)/q;
        
        
        cost1= y1 * root1_x;
        
        
        userWindow.displaySolution(cost1);
            
            
        }
       
        
     }
}
