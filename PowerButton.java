/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Logger;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
/**
 *
 * @author Fatema
 */
public class PowerButton extends JApplet {
      private String[] powerOption = {"", "Sleep", "Shutdown", "Restart"};

    private JComboBox c = new JComboBox();
    private int count = 0;

    public void init() {
        for (int i = 0; i < 4; i++) {
            c.addItem(powerOption[count++]);
        }

        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (c.getSelectedItem() == "Sleep") {
                    try {
                        Runtime.getRuntime().exec("Rundll32.exe powrprof.dll,SetSuspendState Sleep");
                    } catch (IOException ex) {
                        
                    }

                } else if (c.getSelectedItem() == "Shutdown") {
                    Runtime runtime = Runtime.getRuntime();
//                    try {

//                        Process proc = runtime.exec("shutdown -s -t 0");
//                    } catch (IOException ex) {
//
//                    }
//                    System.exit(0);

                } else if (c.getSelectedItem() == "Restart") {
                    Runtime runtime = Runtime.getRuntime();
                    try {

                        Process proc = runtime.exec("shutdown -r -t 0");
                    } catch (IOException ex) {

                    }
                    System.exit(0);

                }
            }
        });
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());

        cp.add(c);

    }

    public static void main(String[] args) {
        run(new PowerButton(), 200, 125);
    }

    public static void run(JApplet applet, int width, int height) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(applet);
        frame.setSize(width, height);
        applet.init();
        applet.start();
        frame.setVisible(true);
    }
}

    

