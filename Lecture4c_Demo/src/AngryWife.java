import javax.swing.JOptionPane;

class AngryWife
{
  // at this moment, we use class fields and methods to demonstrate the modifiers private and public

  public static String ask()
  {
    String input = JOptionPane.showInputDialog("AngryWife ask()...Did you do anything wrong?");
    return input;
  }
  
  private static void kiss()
  {
    JOptionPane.showMessageDialog(null, "AngryWife kiss()...Oh!  Darling!  Sweet Heart!");
  }
  
  public static void action()
  {
    JOptionPane.showMessageDialog(null, "AngryWife action()...");

    String answer;
    answer = ask();
    
    ask();              // it's up to us to store/use the return value from ask()
    ask();
    ask();
    /* enough */
    
    kiss();
  }
  
  










  private static double accountBalance;  // a private variable
  public static final char sex = 'F';   // a public constant

  public static void withdraw()          // a method
  {
    JOptionPane.showMessageDialog(null, "AngryWife withdraw()...$100");

    // only methods of AngryWife can touch private fields
    // but not methods of PoorHusband
    accountBalance -= 100.00;

  }






  
  public static void main(String[] argv)
  {
    JOptionPane.showMessageDialog(null, "AngryWife main()...");
  
    action();
    withdraw();
  }
}
