import javax.swing.JOptionPane;

class HKSAR 
{
  public static void main(String[] args)
  {
    Employee instructor;
    instructor = CUHK.employ();
    JOptionPane.showMessageDialog(null, "HKSAR is emplying a new instructor called " + instructor.name);
  }
}
