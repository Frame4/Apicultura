package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;



public class beeInterface {
    weatherUI wUI = new weatherUI();
    JFrame frame;
    JPanel panel;
    JButton WCbtn, HCbtn, EXITbtn, CONFIGbtn;
    BufferedImage  image;
    
    public JPanel beeMenu(){
        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(500, 600);
        frame.add(panel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        WCbtn = new JButton("Weather Control");
        WCbtn.setBounds(175, 250, 150, 30);
        WCbtn.setBackground(Color.WHITE);
        WCbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                frame.getContentPane().removeAll();
                frame.repaint();
                //frame.add(wUI.weatherJPanel());
            }
        });
        panel.add(WCbtn);

        HCbtn = new JButton("Hive Control");
        HCbtn.setBounds(175, 300, 150, 30);
        HCbtn.setBackground(Color.WHITE);
        HCbtn.setFocusPainted(false);
        HCbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

            }
        });
        panel.add(HCbtn);

        EXITbtn = new JButton("Exit");
        EXITbtn.setBounds(175, 350, 70, 30);
        EXITbtn.setBackground(Color.WHITE);
        EXITbtn.setFocusPainted(false);
        EXITbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        panel.add(EXITbtn);

        CONFIGbtn = new JButton("Config");
        CONFIGbtn.setBounds(255, 350, 70, 30);
        CONFIGbtn.setBackground(Color.WHITE);
        CONFIGbtn.setFocusPainted(false);
        CONFIGbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

            }
        });
        panel.add(CONFIGbtn);

        return panel;
    }
}
