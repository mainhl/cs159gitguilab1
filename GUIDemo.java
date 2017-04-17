import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.Random;

import javax.swing.*;

/**
 * Minimal Java Swing application.
 * 
 * @author Nathan Sprague
 * 
 */
public class GUIDemo extends JFrame
{
    private JPanel panel;
    private JButton biggerButton;
    private JButton smallerButton;
    private JButton halfButton;
    private JButton doubleButton;
    private JButton changeButton;

    /**
     * Set up the application.
     */
    public GUIDemo()
    {
        setTitle("Bigger/Smaller");
        setSize(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        biggerButton = new JButton("BIGGER");
        smallerButton = new JButton("SMALLER");
        halfButton = new JButton("HALF SIZE");
        doubleButton = new JButton("DOUBLE SIZE");
        changeButton = new JButton("CHANGE COLOR");
        biggerButton.addActionListener(new ButtonHandler());
        smallerButton.addActionListener(new ButtonHandler());
        halfButton.addActionListener(new ButtonHandler());
        doubleButton.addActionListener(new ButtonHandler());
        changeButton.addActionListener(new ButtonHandler());
        add(panel);
        panel.add(biggerButton);
        panel.add(smallerButton);
        panel.add(halfButton);
        panel.add(doubleButton);
        panel.add(changeButton);
        setVisible(true);
    }

    /**
     * This inner class exists to handle button events. There are other ways
     * this could have been done:
     * 
     * 1. GUIDemo could implement ActionListener itself. 
     * 2. Anonymous inner classes could be used to hand the events.
     */
    private class ButtonHandler implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            Dimension size = getSize();

            if (e.getSource().equals(biggerButton))
            {
                setSize(size.width + 10, size.height + 10);
            }
            else if (e.getSource().equals(smallerButton))
            {
                setSize(size.width - 10, size.height - 10);
            }
            else if (e.getSource().equals(halfButton))
            {
               setSize(size.width / 2, size.height / 2);
            }
            else if (e.getSource().equals(doubleButton))
            {
               setSize(size.width * 2, size.height * 2);
            }        
            else if (e.getSource().equals(changeButton))
            {
               Random rand = new Random();
               float r = rand.nextFloat();
               float g = rand.nextFloat();
               float b = rand.nextFloat();
               float a = rand.nextFloat();
               Color color = new Color(r, g, b, a);
               panel.setBackground(color);
               panel.repaint();
            }   
        }
    }

    /**
     * Start the app by creating a GUIDemo object.
     */
    public static void main(String[] args)
    {
        GUIDemo app = new GUIDemo();
    }
}
