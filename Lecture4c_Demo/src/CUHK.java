import javax.swing.JOptionPane;

class CUHK
{
  private static void fire(Employee victim)
  {
    JOptionPane.showMessageDialog(null, "Salary of victim is adjusting from " + victim.salary + " to 0");
    victim.salary = 0;
  }
  
  public static void main(String[] args)
  {
    Employee michael;
    michael = new Employee();
    
    JOptionPane.showMessageDialog(null, "Michael salary = " + michael.salary);
    
    fire(michael);
    
    JOptionPane.showMessageDialog(null, "Michael salary = " + michael.salary);
  }
  
  
  
  
  public static Employee employ()
  {
    // interview, etc.
    Employee newbie = new Employee("Anson");
    return newbie;
  }
}
