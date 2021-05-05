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

    public SecondWindow() {

//        goBackButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                WireworldWindow window = new WireworldWindow();
//                JFrame.getFrames();
//                newFrame.setVisible(false);
//                window.getFrameInstance().setVisible(true);
//            }
//       });
    };
    public JPanel getSecondPanel() {
        return this.secondPanel;
    }
}

