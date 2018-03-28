import java.*;

class Casting {
  public static void main(String[] args)
  {
    // (a-type-name) is the "type casting operation", i.e. to mimic a type

    // in java, numbers with a decimal point is considered to be "double"
    // type casting from double to float, no *apparent* data loss
    System.out.println(       3.0);
    System.out.println((float)3.0);

    // type casting from double to float, with precision loss
    System.out.println(       3.4444444444444);
    System.out.println((float)3.4444444444444);

    // type casting from double to float, with precision loss
    System.out.println(       3.8888888888888);
    System.out.println((float)3.8888888888888);

    // type casting from double to float, with precision loss
    System.out.println(       3.8888889888888);
    System.out.println((float)3.8888889888888);

    // in java, numbers followed by the character f is considered to be "float"
    float number = 3.123f;

    // type casting from float to double, *apparent* data loss?!
    System.out.println(        number);
    System.out.println((double)number);
    System.out.println((double)(float)3.123);

    // in java, numbers without a decimal point is considered to be "int"
    // type casting from int to float, no *apparent* data loss
    System.out.println(       3);
    System.out.println((float)3);

    System.out.println(0.7 * 0.7 == 0.49);

  }
}

