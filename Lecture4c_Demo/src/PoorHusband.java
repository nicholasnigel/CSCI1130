import javax.swing.JOptionPane;

class PoorHusband
{
  public static void action()
  {
    JOptionPane.showMessageDialog(null, "PoorHusband action()...Please forgive me!");
    
    // the following statement fails
    // AngryWife.kiss();
  }
  public static void doWrong()
  {
    JOptionPane.showMessageDialog(null, "PoorHusband doWrong()...");
    AngryWife.action();
  }
  













  public static void evil()
  {
    JOptionPane.showMessageDialog(null, "PoorHusband evil()...");

    // the following statements fail
    
    // AngryWife.accountBalance -= 0.1;
    // AngryWife.withdraw(9999);

    // this one is ok
    AngryWife.withdraw();
  }


















  
  
  public static void main(String[] argv)
  {
    JOptionPane.showMessageDialog(null, "PoorHusband main...");

    doWrong();
    action();
  }
}
