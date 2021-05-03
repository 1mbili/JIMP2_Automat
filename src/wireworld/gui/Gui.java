package wireworld.gui;

import javax.swing.*;
import java.awt.*;

public class Gui {
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
                frame.setPreferredSize(new Dimension(960, 600));
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}

