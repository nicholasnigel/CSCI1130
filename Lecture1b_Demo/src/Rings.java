import java.awt.*;    // import Java packages

class Rings extends Frame
{
  // constructor metbod
  public Rings ( )
  {
    setTitle ("Olympic Rings");   // the window title bar
  }
  
  // main method, beginning of the program
  public static void main (String [ ] args)
  {
    Frame f = new Rings ();
    f.setSize (300, 200);   // window dimensions
    f.setVisible (true);    // show the window
  }
  
  // a method for painting the rings
  public void paint (Graphics pen)
  {
    pen.setColor(Color.red);    pen.drawOval( 80,80,30,30);
    pen.setColor(Color.blue);   pen.drawOval(105,80,30,30);
    pen.setColor(Color.green);  pen.drawOval(130,80,30,30);
    pen.setColor(Color.yellow); pen.drawOval(155,80,30,30);
    pen.setColor(Color.black);  pen.drawOval(180,80,30,30);
    pen.drawString("Olympic Rings", 110,140);  // the text
  }
}
