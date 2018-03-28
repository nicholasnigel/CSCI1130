import javax.swing.JOptionPane;

class RandomInvestigation
{
  public static void PerformRandomInvestigation ()
  {
    double random1, random2;
    random1 = Math.random();
    random2 = Math.random();
    JOptionPane.showMessageDialog(null, "The numbers are: " + random1 + " and " + random2);
    JOptionPane.showMessageDialog(null, "Max is " + Math.max (random1, random2));
  }

  public static void main (String [] args)
  {
    PerformRandomInvestigation ();
  }
}
