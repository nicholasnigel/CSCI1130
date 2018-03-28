package csp;

/**
 * Constraint encapsulates a constraint equation object.
 * @author pffung
 */
public class Constraint {

    /**
     * Instance field label is a String description of the Constraint object.
     * It must be "First", "Second" or "Third" in this assignment.
     */
    private String label;

    // Coefficients of a Constraint equation object
    private int A, B, C;

    /**
     * Constructor of a new Constraint object
     * @param label is a String description of the Constraint object. It must be "First", "Second" or "Third" in this assignment.
     * @param A, B, C are coefficients of the Constraint equation.
     */
    public Constraint(String label, int A, int B, int C)
    {
        if (!label.equals("First") &&
            !label.equals("Second") &&
            !label.equals("Third"))
        {
            // we may throw a new ClassCastException here!
            System.err.println("Michael's advice: you shall create a new Constraint object with a proper label, either, \"First\", \"Second\" or \"Thrid\"");
            this.label = "Unknown";
            this.A = A;
            this.B = B;
            this.C = C;
        }
        else
        {
            this.label = label;
            this.A = A;
            this.B = B;
            this.C = C;
        }
    }
    
    /**
     * Get label of this Constraint equation object.
     * @return label as a String.
     */
    public String getLabel()
    {
        return label;
    }
    
    /**
     * Evaluate this Constraint equation object with given variables.
     * @param x, y, z are the given variables
     * @return true or false
     */
    public boolean evaluate(int x, int y, int z)
    {
        boolean result;

        if (label.equals("First"))
            result = constraint1(x, y, z);

        else if (label.equals("Second"))
            result = constraint2(x, y, z);

        else if (label.equals("Third"))
            result = constraint3(x, y, z);

        else
            result = true;
        
        return result;
    }
    
    /**
     * Evaluate "First" Constraint equation: A * x + B * y greater than C * z
     * @param x, y, z are the given variables
     * @return true or false
     */
    private boolean constraint1(int x, int y, int z)
    {
        return A * x + B * y > C * z;
    }

    /**
     * Evaluate "Second" Constraint equation: A * x + B * y less than C * z - 3
     * @param x, y, z are the given variables
     * @return true or false
     */
    private boolean constraint2(int x, int y, int z)
    {
        return A * x + B * y < C * z - 3;
    }

    /**
     * Evaluate "Third" Constraint equation: A * x + B * y + C greater than 4 * z
     * @param x, y, z are the given variables
     * @return true or false
     */
    private boolean constraint3(int x, int y, int z)
    {
        return A * x + B * y + C > 4 * z;
    }

    /**
     * Override toString method to return a String representation of this object.
     * @return String representation of this Constraint equation object.
     */    
    @Override
    public String toString()
    {
        if (label.equals("First"))
            return String.format("%d * x + %d * y > %d * z", A, B, C);

        else if (label.equals("Second"))
            return String.format("%d * x + %d * y < %d * z - 3", A, B, C);

        else if (label.equals("Third"))
            return String.format("%d * x + %d * y + %d > 4 * z", A, B, C);

        return "Unknown Constraint!";
    }
}
