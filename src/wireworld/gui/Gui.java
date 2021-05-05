package wireworld.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {
    private JFrame frame; //= new JFrame("Wireworld GUI");

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                WireworldWindow window = new WireworldWindow() {
                    @Override
                    public void onOpen(String path) {
                    }
                };
                JFrame frame = new JFrame("Wireworld GUI");

                frame.setContentPane(window.getRootPanel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setPreferredSize(new Dimension(800, 600));
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    public JFrame getFrameInstance () {
        return this.frame;
    }
}

