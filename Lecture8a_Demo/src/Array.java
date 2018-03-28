class Array
{
  public static void main(String[] args)
  {
    int[] i;
    i = new int[10];
    
    i[0] = 3;
    i[1] = 2;
    i[2] = 6;
    i[3] = -19;
    i[4] = 17;
    i[5] = 22;
    i[6] = -31;
    i[7] = 0;
    i[8] = 23;
    i[9] = 1;

    try {
      i[10] = 21;
      i[-3] = 28;
    }
    catch (ArrayIndexOutOfBoundsException e) {
      System.out.println(e);
    }
    
    int count;
    for (count = 0; count < 10; count++)
    {
      System.out.println("Mailbox " + count + " stores " + i[count]);
    }
    
    System.out.println("Length of the array i = " + i.length);
  }
}