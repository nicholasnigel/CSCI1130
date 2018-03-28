package csp;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Constraint Input Box
 * @author Michael P.F. FUNG
 * @since 4 Oct 2017
 */
public class ConstraintInputBox extends JFrame implements ActionListener, ChangeListener {
    // GUI components for user interactions
    protected JTextField c1A, c1B, c1C;
    protected JTextField c2A, c2B, c2C;
    protected JTextField c3A, c3B, c3C;

    protected JSlider minRandomRange, maxRandomRange;
    protected JLabel randomRange;
    protected JButton randomButton;

    protected JSlider xRange, yRange, zRange;
    protected JButton solveButton;

    protected JLabel message;
    
    /**
     * Constructor
     */
    public ConstraintInputBox()
    {
        initComponents();
    }
    
    /**
     * Initial GUI components.
     */
    public final void initComponents()
    {
        setTitle("Constraint Solver - InputBox");
        setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));  // rows of components
        
        // window geometry
        setSize(700, 500);
        setLocation(400, 200);

        // First Constraint
        JPanel ceqn1 = new JPanel();
        ceqn1.add(new JLabel("<html>Constraint 1: &nbsp;&nbsp;&nbsp; A &middot; x + B &middot; y &gt; C &middot; z</html>"));
        add(ceqn1);
        
        JPanel eqn1 = new JPanel();
        eqn1.add(c1A = new JTextField());  eqn1.add(new JLabel("x + "));
        eqn1.add(c1B = new JTextField());  eqn1.add(new JLabel("y > "));
        eqn1.add(c1C = new JTextField());  eqn1.add(new JLabel("z"));
        c1A.setColumns(5);
        c1B.setColumns(5);
        c1C.setColumns(5);
        add(eqn1);
        
        // Second Constraint
        JPanel ceqn2 = new JPanel();
        ceqn2.add(new JLabel("<html>Constraint 2: &nbsp;&nbsp;&nbsp; A &middot; x + B &middot; y &lt; C &middot; z - 3</html>"));
        add(ceqn2);
        
        JPanel eqn2 = new JPanel();
        eqn2.add(c2A = new JTextField());  eqn2.add(new JLabel("x + "));
        eqn2.add(c2B = new JTextField());  eqn2.add(new JLabel("y < "));
        eqn2.add(c2C = new JTextField());  eqn2.add(new JLabel("z - 3"));
        c2A.setColumns(5);
        c2B.setColumns(5);
        c2C.setColumns(5);
        add(eqn2);
        
        // Third Constraint
        JPanel ceqn3 = new JPanel();
        ceqn3.add(new JLabel("<html>Constraint 3: &nbsp;&nbsp;&nbsp; A &middot; x + B &middot; y + C &gt; 4 &middot; z</html>"));
        add(ceqn3);
        
        JPanel eqn3 = new JPanel();
        eqn3.add(c3A = new JTextField());  eqn3.add(new JLabel("x + "));
        eqn3.add(c3B = new JTextField());  eqn3.add(new JLabel("y + "));
        eqn3.add(c3C = new JTextField());  eqn3.add(new JLabel("> 4z"));
        c3A.setColumns(5);
        c3B.setColumns(5);
        c3C.setColumns(5);
        add(eqn3);

        // Randomization Panel
        JPanel randomSliderPanel = new JPanel();
        randomSliderPanel.setLayout(new GridLayout(2, 3));

        JLabel minRangeLabel = new JLabel("min random number");
        minRangeLabel.setHorizontalAlignment(JLabel.RIGHT);
        randomSliderPanel.add(minRangeLabel);
        randomSliderPanel.add(randomButton = new JButton("Randomize!"));
        randomButton.setActionCommand("random");
        randomButton.addActionListener(this);
        randomSliderPanel.add(new JLabel("max random number"));
        randomSliderPanel.add(minRandomRange = new JSlider(-10, 10, -8));
        randomRange = new JLabel("Constraints 1-3 A/B/C's in [-8, +8]");
        randomRange.setHorizontalAlignment(JLabel.CENTER);
        randomSliderPanel.add(randomRange);
        randomSliderPanel.add(maxRandomRange = new JSlider(-10, 10, +8));
        minRandomRange.setPaintTicks(true);  minRandomRange.setPaintLabels(true);
        minRandomRange.setSnapToTicks(true); minRandomRange.setMajorTickSpacing(1);
        minRandomRange.setLabelTable(minRandomRange.createStandardLabels(10));
        minRandomRange.addChangeListener(this);
        maxRandomRange.setPaintTicks(true);  maxRandomRange.setPaintLabels(true);
        maxRandomRange.setSnapToTicks(true); maxRandomRange.setMajorTickSpacing(1);
        maxRandomRange.setLabelTable(maxRandomRange.createStandardLabels(10));
        maxRandomRange.addChangeListener(this);
        add(randomSliderPanel);
        
        
        // Solver Panel
        JPanel rangeSliderPanel = new JPanel();
        rangeSliderPanel.setLayout(new GridLayout(2, 3));
        JLabel xRangeLabel = new JLabel("x range");
        xRangeLabel.setHorizontalAlignment(JLabel.CENTER);
        rangeSliderPanel.add(xRangeLabel);
        JLabel yRangeLabel = new JLabel("y range");
        yRangeLabel.setHorizontalAlignment(JLabel.CENTER);
        rangeSliderPanel.add(yRangeLabel);
        JLabel zRangeLabel = new JLabel("z range");
        zRangeLabel.setHorizontalAlignment(JLabel.CENTER);
        rangeSliderPanel.add(zRangeLabel);
        rangeSliderPanel.add(xRange = new JSlider(1, 10, 5));
        rangeSliderPanel.add(yRange = new JSlider(1, 10, 5));
        rangeSliderPanel.add(zRange = new JSlider(1, 10, 5));
        xRange.setPaintTicks(true);  xRange.setPaintLabels(true);
        xRange.setSnapToTicks(true); xRange.setMajorTickSpacing(1);
        xRange.setLabelTable(xRange.createStandardLabels(9));
        yRange.setPaintTicks(true);  yRange.setPaintLabels(true);
        yRange.setSnapToTicks(true); yRange.setMajorTickSpacing(1);
        yRange.setLabelTable(yRange.createStandardLabels(9));
        zRange.setPaintTicks(true);  zRange.setPaintLabels(true);
        zRange.setSnapToTicks(true); zRange.setMajorTickSpacing(1);
        zRange.setLabelTable(zRange.createStandardLabels(9));
        xRange.addChangeListener(this);
        yRange.addChangeListener(this);
        zRange.addChangeListener(this);
        add(rangeSliderPanel);
        
        JPanel solvePanel = new JPanel();
        solvePanel.add(solveButton = new JButton("Solve!"));
        solveButton.setActionCommand("solve");
        solveButton.addActionListener(this);
        add(solvePanel);
        
        // Output box
        JPanel outputPanel = new JPanel();
        outputPanel.add(message = new JLabel(" "));
        message.setText(String.format("Solve for x [1-%d], y [1-%d], z [1-%d]", xRange.getValue(), yRange.getValue(), zRange.getValue()));
        add(outputPanel);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Callback method for processing user inputs on clicking buttons.
     * This method will be invoked by the Java GUI.
     * @param event refers to an object generated by the Java GUI system
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event == null) return;
        if (event.getActionCommand().equals("random"))
        {
            CSPSolver.randomize();
        }
        if (event.getActionCommand().equals("solve"))
        {
            if (validateInputs())
                CSPSolver.calculate();
            // do nothing if inputs are invalid
        }
    }

    /**
     * Callback method for processing user inputs on moving sliders.
     * This method will be invoked by the Java GUI.
     * @param event refers to an object generated by the Java GUI system
     */
    @Override
    public void stateChanged(ChangeEvent event) {
        if ((JComponent)event.getSource() == minRandomRange) {
            if (minRandomRange.getValue() > maxRandomRange.getValue())
                maxRandomRange.setValue(minRandomRange.getValue());
        }
        if ((JComponent)event.getSource() == maxRandomRange) {
            if (maxRandomRange.getValue() < minRandomRange.getValue())
                minRandomRange.setValue(maxRandomRange.getValue());
        }
        randomRange.setText(String.format("Constraints 1-3 A/B/C's in [%+d, %+d]", minRandomRange.getValue(), maxRandomRange.getValue()));
        if ((JComponent)event.getSource() == xRange || 
            (JComponent)event.getSource() == yRange || 
            (JComponent)event.getSource() == zRange)
        {
            message.setText(String.format("Solve for x [1-%d], y [1-%d], z [1-%d]", xRange.getValue(), yRange.getValue(), zRange.getValue()));
        }
    }

    
    /**
     * Check if all user inputs are proper double values.
     * @return true if all user inputs are valid; false otherwise.
     */
    public boolean validateInputs()
    {
        try {
            int coeff1A = get1A();
            int coeff1B = get1B();
            int coeff1C = get1C();
            int coeff2A = get2A();
            int coeff2B = get2B();
            int coeff2C = get2C();
            int coeff3A = get3A();
            int coeff3B = get3B();
            int coeff3C = get3C();
        }
        catch (Exception e) {
            message.setText("Wrong input!");
            return false;
        }
        return true;  // all inputs are proper double values
    }
    
    /**
     * Display solution message, to be invoked by Solver.
     * @param x, y, z forms the solution
     */
    public void displaySolution(int x, int y, int z) {
        message.setText(String.format("Solution found: x = %d, y = %d, z = %d", x, y, z));
    }
    
    /**
     * Display no solution message, to be invoked by Solver.
     */
    public void displayNoSolution() {
        message.setText("No solution!");
    }
    
    public int getMinRandomRange() {
        return minRandomRange.getValue();
    }
    
    public int getMaxRandomRange() {
        return maxRandomRange.getValue();
    }
    
    public int getxRange() {
        return xRange.getValue();
    }
    
    public int getyRange() {
        return yRange.getValue();
    }
    
    public int getzRange() {
        return zRange.getValue();
    }
    
    public int get1A() {
        return Integer.parseInt(c1A.getText());
    }
    public int get1B() {
        return Integer.parseInt(c1B.getText());
    }
    public int get1C() {
        return Integer.parseInt(c1C.getText());
    }
    public int get2A() {
        return Integer.parseInt(c2A.getText());
    }
    public int get2B() {
        return Integer.parseInt(c2B.getText());
    }
    public int get2C() {
        return Integer.parseInt(c2C.getText());
    }
    public int get3A() {
        return Integer.parseInt(c3A.getText());
    }
    public int get3B() {
        return Integer.parseInt(c3B.getText());
    }
    public int get3C() {
        return Integer.parseInt(c3C.getText());
    }
    
    public void set1A(int value) {
        c1A.setText("" + value);
    }
    public void set1B(int value) {
        c1B.setText("" + value);
    }
    public void set1C(int value) {
        c1C.setText("" + value);
    }
    public void set2A(int value) {
        c2A.setText("" + value);
    }
    public void set2B(int value) {
        c2B.setText("" + value);
    }
    public void set2C(int value) {
        c2C.setText("" + value);
    }
    public void set3A(int value) {
        c3A.setText("" + value);
    }
    public void set3B(int value) {
        c3B.setText("" + value);
    }
    public void set3C(int value) {
        c3C.setText("" + value);
    }
}