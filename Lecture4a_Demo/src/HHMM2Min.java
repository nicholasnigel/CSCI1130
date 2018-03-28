import javax.swing.JOptionPane;

class HHMM2Min
{  
  static int timeInMinutes(int hhmm)
  {
    int hh = hhmm / 100;  // extract the hour part
    int mm = hhmm % 100;  // extract the minute part
    return hh * 60 + mm;  // the result must be an int
  }
  
  public static void main(String[] args)
  {
    int numberOfMinutes;

    numberOfMinutes = timeInMinutes(2304);
    
    JOptionPane.showMessageDialog(null, "00:00 - 23:04 is equivalent to " +
                                        numberOfMinutes + " minutes");
  }
}
