package wireworld.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorWindow extends WireworldWindow {
    private JButton okButton;
    private JLabel errorLabel;
    private JFrame frame;
    private JPanel panel;


    public ErrorWindow(JFrame oldframe) {
        this.frame = oldframe;

        panel = new JPanel(null);
        panel.setBounds(0, 0, 350, 300);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panel.setBackground(Color.cyan);
        panel.setVisible(true);
        frame.add(panel);

        JLabel title = new JLabel("Error: input values are not specified correctly");
        title.setBounds(40, 40, 100, 30);
        title.setForeground(Color.GRAY);
        panel.add(title);


        errorLabel = new JLabel("Input data is null or incorrect");
        errorLabel.setBounds(40, 100, 100, 30);
        Font f = new Font("Arial", Font.BOLD, 20);
        errorLabel.setFont(f);
        errorLabel.setForeground(Color.RED);
        panel.add(errorLabel);


        okButton = new JButton("OK");
        okButton.setBounds(40, 200, 100, 30);
        okButton.setForeground(Color.GRAY);
        panel.add(okButton);

        // przy nacisnięciu na OK program powraca do pierwotnego okna
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed ( ActionEvent e){
                JFrame frame1 = new JFrame("Wireworld GUI");
                WireworldWindow window = new WireworldWindow(frame1) {
                    @Override
                    public void onOpen(String path) {
                    }
                };
                frame.dispose();
            }
        });
    }


    public static boolean isInteger(String s) {
        return isInteger(s,10);
    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty())
            return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }


    @Override
    public void onOpen(String path) {
    }
}

