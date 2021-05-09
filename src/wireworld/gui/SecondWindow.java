package wireworld.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SecondWindow extends JButton {
    private JPanel secondPanel;
    private JButton stopButton;
    private JButton nextStepButton;
    private JButton downloadButton;
    private JButton goBackButton;
    private JFrame actual;

    public SecondWindow() {

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Wireworld GUI");
                WireworldWindow window = new WireworldWindow(frame) {
                    @Override
                    public void onOpen(String path) {
                    }
                };
                actual.dispose();

            }
        });
    };
    public JPanel getSecondPanel() {
        return this.secondPanel;
    }
    public void setFrame(JFrame fr) {
        this.actual = fr;
    }
}

