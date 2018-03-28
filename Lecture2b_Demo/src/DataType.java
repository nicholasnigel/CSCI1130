class DataType {		/* testing of primitive data types */
  public static void main (String [ ] args) {
    byte int8 = -128;
    System.out.println(int8);
    int8 = (byte) 137;	/* type casting with an overflow */
    System.out.println(int8);
    boolean ok = (3 > 7);	/* boolean expression */
    System.out.println(ok);
    System.out.println("Hello \"World\" !!!");
    double GPA = 3;
    System.out.println("GPA = " + GPA);
    System.out.println("(int)(5.23)      = " + (int)(5.23));
    System.out.println("Math.floor(5.23) = " + Math.floor(5.23));
    System.out.println("Math.ceil(5.23)  = " + Math.ceil(5.23));
    System.out.println("Math.round(5.23) = " + Math.round(5.23));
    System.out.println("(int)(-5.23)      = " + (int)(-5.23));
    System.out.println("Math.floor(-5.23) = " + Math.floor(-5.23));
    System.out.println("Math.ceil(-5.23)  = " + Math.ceil(-5.23));
    System.out.println("Math.round(-5.23) = " + Math.round(-5.23));
  }
}

