package wireworld.gui;


import wireworld.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class SecondWindow {
    private JPanel secondPanel;
    private JButton stopButton;
    private JButton nextStepButton;
    private JButton downloadButton;
    private JButton goBackButton;
    private JPanel board;
    private JFrame actual;
    private JFrame frame;

    public SecondWindow() {

        board.setBackground(Color.black);
        board.setPreferredSize(new Dimension(350, 350));
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame = new JFrame("Wireworld GUI");
                WireworldWindow window = new WireworldWindow(frame) {
                    @Override
                    public void onOpen(String path) {
                    }
                };
                actual.dispose();
            }
        });
    };
    private void createUIComponents () {
        this.board = new CheckerBoard();
    }
    public JPanel getSecondPanel() {
        return this.secondPanel;
    }
    public void setFrame(JFrame fr) {
        this.actual = fr;
    }
    public JFrame getFrameInstance () {
        return this.frame;
    }
}

