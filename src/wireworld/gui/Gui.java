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
                JFrame frame = new JFrame("Wireworld GUI");
                WireworldWindow window = new WireworldWindow(frame) {
                    @Override
                    public void onOpen(String path) {
                    }
                };
            }
        });
    }
    public JFrame getFrameInstance () {
        return this.frame;
    }
}

