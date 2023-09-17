package GUI;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class weatherUI {
    String currentWeather="";
    JPanel wPanel;
    JButton addBHiveBTN;
    JComboBox<String> selectHive ;
    JFrame frame;
    JTextArea beeEventTA;
    JLabel roomStatusLabel;
    JLabel currentWeatherLabel;
    JLabel currentTemperatureLabel;
    public JPanel weatherJPanel(){
        frame = new JFrame();
        frame.setSize(900, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        wPanel = new JPanel();
        frame.add(wPanel);
        
        roomStatusLabel = new JLabel("Room Status:");
        roomStatusLabel.setBounds(20, 20, 200, 200);
        wPanel.add(roomStatusLabel);
        
        currentWeatherLabel = new JLabel("Current weather: ");
        currentWeatherLabel.setBounds(20, 30, 200, 200);
        wPanel.add(currentWeatherLabel);

        currentTemperatureLabel = new JLabel("Current temperature: ");
        currentTemperatureLabel.setBounds(20, 40, 200, 200);
        wPanel.add(currentTemperatureLabel);
        
        beeEventTA = new JTextArea();
        beeEventTA.setBounds(10, 10, 300, 540);
        
        wPanel.add(beeEventTA);

        //selectHive = new JComboBox<String>();
        //selectHive.setBounds(500, 450, 0, 0);
        //selectHive.addItem("hive 1");

        wPanel.add(selectHive);
        addBHiveBTN = new JButton("Add bee Hive");
        addBHiveBTN.setBounds(500, 500, 150, 30);
        addBHiveBTN.setBackground(Color.WHITE);
        addBHiveBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

            }
        });
        wPanel.add(addBHiveBTN);


        return wPanel;
    }
}
