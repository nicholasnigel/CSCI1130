class LotsaLabels
{

  /* Adopted and Modified by Michael */
    
  /* Label Displaying Program       by J M Bishop  Aug 1996
   * ----------------------------   Java 1.1 October 1997
   *                                updated and Java 2, April 2000
   * Prints many labels
   * Illustrates a simple for-loop
   */

  public static void PrintLotsaLabels ()
  {
    for (int i = 0; i < 8; i++) {
      System.out.println("-----------------------------");
      System.out.println("|                           |");
      System.out.println("|   Michael FUNG            |");
      System.out.println("|   Hong Kong               |");
      System.out.println("|                           |");
      System.out.println("-----------------------------");
    }
  }

  public static void main(String[] args) 
  {
    PrintLotsaLabels ();
  }
}
