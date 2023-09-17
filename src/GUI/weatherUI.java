package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class weatherUI {
    String currentWeather="";
    JPanel wPanel;
    JButton backBTN;
    JFrame frame;
    public JPanel weatherJPanel(){
        frame = new JFrame();
        frame.setSize(500, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel wPanel = new JPanel();
        frame.add(wPanel);
        JLabel currentWeatherLabel = new JLabel("Current weather: "+currentWeather);
        wPanel.add(currentWeatherLabel);


        backBTN = new JButton("");
        backBTN.setBounds(175, 250, 150, 30);
        //backBTN.setBackground(Color.WHITE);
        backBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

            }
        });
        wPanel.add(backBTN);


        return wPanel;
    }
}
