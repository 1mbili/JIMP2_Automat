package wireworld.gui;


import wireworld.*;
import wireworld.Utils.Utils;
import wireworld.structures.Structure_list;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;


public class SecondWindow {
    private JPanel secondPanel;
    private JButton stopButton;
    private JButton nextStepButton;
    private JButton downloadButton;
    private JButton goBackButton;
    private JPanel board;
    private JFrame actual;
    private JFrame frame;
    private int [][] sboard;

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

                    @Override
                    public void getit(int itnr) {

                    }
                };
                actual.dispose();
            }
        });
    }

    private void createUIComponents () throws IOException {
        Structure_list g = Utils.readFile("Test/TestData");
        sboard = Utils.writeBoard(g,new int[32][32]);
        System.out.println(Arrays.deepToString(sboard).replace("], ", "],\n"));
        board = new CheckerBoard(sboard);
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

