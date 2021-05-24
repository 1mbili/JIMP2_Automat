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
    private final String path;
    private int niter;

    public SecondWindow() {
        super();
        this.path = "Test/TestData";
    }

    public SecondWindow(int niter) {
        this.path = "Test/TestData";
        this.niter = niter;
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

                    @Override
                    public void getisclosed(boolean closed) {

                    }
                };
                actual.dispose();
            }
        });
    }

    private void createUIComponents () throws IOException, InterruptedException {
        System.out.println(path);
        Structure_list g = Utils.readFile(path);
        sboard = Utils.writeBoard(g,new int[32][32]);
        System.out.println(Arrays.deepToString(sboard).replace("], ", "],\n"));
        board = new CheckerBoard(sboard,niter);
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

