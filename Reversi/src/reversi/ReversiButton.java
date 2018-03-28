package reversi;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import javax.swing.JButton;

/**
 * ReversiButton with better looking
 * @author pffung
 */
public class ReversiButton extends JButton {
    public ReversiButton(String label)
    {
        super(label);
        setBackground(Color.GREEN);
    }
    
    @Override
    public void paintComponent(Graphics pen)
    {
        super.paintComponent(pen);

        pen.setColor(getBackground());
        pen.fill3DRect(3, 3, getWidth() - 6, getHeight() - 6, true);
        
        Color buttonColor = getForeground();
        if (buttonColor == Color.BLACK || buttonColor == Color.WHITE)
        {
            pen.setColor(buttonColor);
            int diameter = Math.min(getWidth(), getHeight()) * 5 / 8;
            pen.fillOval((getWidth() - diameter) / 2, (getHeight() - diameter) / 2, diameter, diameter);
        }
        
        FontMetrics fontSize = pen.getFontMetrics();
        Rectangle2D strBound = fontSize.getStringBounds(getText(), pen);
        pen.setColor(Color.RED);
        pen.drawString(getText(), (int) ((getWidth() - strBound.getWidth()) / 2 + 0.5), (int) ((getHeight() + strBound.getHeight() / 2) / 2 + 0.5));
    }
}
