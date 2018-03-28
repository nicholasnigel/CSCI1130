import java.awt.*;
import javax.swing.*;

class FlagMaker
{
  /* Flag drawing program
   * --------------------
   * Illustrates colour and simple graphics output
   */

  // constructor method
  public FlagMaker ()
  {
    // create a window frame object
    JFrame f = new JFrame();
    // create a Germany flag object
    Flag   aGermanyFlag = new Flag();

    // put the Germany flag inside the window frame
    f.getContentPane().add(aGermanyFlag);

    // set the window frame's title and size and 
    // activate the drawing described by the paint method.
    f.setTitle("A Flag");
    f.setSize(400, 300);
    f.setVisible(true);
    f.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
}

  // beginning of the program
  public static void main (String [ ] args)
  {
	  // create a new FlagMaker object
    new FlagMaker();
  }
}

// this is another class to draw a Germany Flag
class Flag extends Canvas
{
  public void paint (Graphics drawingPen)
  {
    // Draw the flag using coloured rectangles
    drawingPen.setColor (Color.black);
    drawingPen.fillRect (40,40,200,40);
    drawingPen.setColor (Color.red);
    drawingPen.fillRect (40,80,200,40);
    drawingPen.setColor (Color.yellow);
    drawingPen.fillRect (40,120,200,40);

    // Label the drawing
    drawingPen.setColor (Color.black);
    drawingPen.drawString("Germany",100,180);
  }
}
