package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import CONTROL.*;
import LOGIC.*;


public class beeCareUI {
    weather weather = LOGIC.weather.getInstance();
    aCControl ac = aCControl.getInstance();
    lightsControl lc = lightsControl.getInstance();
    smokeControl sc = smokeControl.getInstance();
    weatherControl wc = new weatherControl();
    farmControl fc = new farmControl();
    Main main = new Main();
    Farm currentFarm = main.testFarm;

    JFrame mainBeeCareFrame;
    JPanel mainPanel,leftPanel,centerPanel, infoPanel;
    JTextArea beeEventTA;
    JLabel currentWeatherLabel,currentTemperatureLabel,smokeInRoom,beeConformityLevelLabel,beeCountLabel,lightLevelLabel,aCCapacitylLabel;
    JButton increaseLightButton,decreaseLightButton,increaseTempButton,decreaseTempButton,useSmokerButton, GatesButton, harvestButton;




    public void weatherJPanel(){

        mainBeeCareFrame = new JFrame("bee Care");
        mainBeeCareFrame.setSize(900,600);
        mainBeeCareFrame.setVisible(true);
        mainBeeCareFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Image icon = Toolkit.getDefaultToolkit().getImage("resources/fullBeeHive.png");
        mainBeeCareFrame.setIconImage(icon);


        mainPanel = new JPanel(new GridLayout(1,3));

        //=====================================================================================
        //left panel

        leftPanel = new JPanel(new GridBagLayout());
        GridBagConstraints lPGridBag = new GridBagConstraints();

        lPGridBag.anchor=GridBagConstraints.NORTH;
        lPGridBag.ipady = 5;
        lPGridBag.ipadx = 5;
        lPGridBag.insets = new Insets(10,0,0,0);  //top padding
        lPGridBag.gridx = 0;       //aligned with button 2
        lPGridBag.gridwidth = 1;   //2 columns wide
        lPGridBag.gridy = 0;
        leftPanel.add(new JLabel("Farm Control"),lPGridBag);


        //combobox
        GatesButton = new JButton("open gates");
        GatesButton.setBackground(Color.white);
        GatesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if(GatesButton.getText().equals("open gates")) {//if gates are now open
                    GatesButton.setText("close gates");
                    fc.pollinate(main.testFarm);

                }
                else {//if gates are now closed
                    GatesButton.setText("open gates");
                }
            }
        });


        lPGridBag.fill = GridBagConstraints.HORIZONTAL;
        lPGridBag.ipady = 5;
        lPGridBag.ipadx = 5;
        lPGridBag.anchor = GridBagConstraints.NORTH; //bottom of space
        lPGridBag.insets = new Insets(10,0,0,0);  //top padding
        lPGridBag.gridx = 0;       //aligned with button 2
        lPGridBag.gridwidth = 1;   //2 columns wide
        lPGridBag.gridy = 1;       //third row
        leftPanel.add(GatesButton, lPGridBag);

        //select hive button
        harvestButton = new JButton("harvest hives");
        harvestButton.setBackground(Color.WHITE);
        harvestButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                fc.harvest(main.testFarm);
            }
        });


        //getHive; print hiveInfo en el textArea

        lPGridBag.fill = GridBagConstraints.HORIZONTAL;
        lPGridBag.weighty = 1.0;   //request any extra vertical space
        lPGridBag.anchor = GridBagConstraints.NORTH; //bottom of space
        lPGridBag.insets = new Insets(10,0,0,0);  //top padding
        lPGridBag.gridx = 5;       //aligned with button 2
        lPGridBag.gridwidth = 2;   //2 columns wide
        lPGridBag.gridy = 1;       //third row
        leftPanel.add(harvestButton, lPGridBag);

        //lPGridBag.fill = GridBagConstraints.HORIZONTAL;
        lPGridBag.weighty = 1.0;   //request any extra vertical space
        lPGridBag.anchor = GridBagConstraints.NORTH; //bottom of space
        lPGridBag.insets = new Insets(10,0,0,0);  //top padding
        lPGridBag.gridx = 0;       //aligned with button 2
        lPGridBag.gridwidth = 2;   //2 columns wide
        lPGridBag.gridy = 2;
        leftPanel.add(new JLabel("Lights Control"),lPGridBag);




        lPGridBag.weighty = 1.0;   //request any extra vertical space
        lPGridBag.anchor = GridBagConstraints.NORTH; //bottom of space
        lPGridBag.insets = new Insets(10,0,0,0);  //top padding
        lPGridBag.gridx = 0;       //aligned with button 2
        lPGridBag.gridwidth = 2;   //2 columns wide
        lPGridBag.gridy = 3;

        decreaseLightButton = new JButton("- light");
        decreaseLightButton.setBackground(Color.WHITE);
        decreaseLightButton.setFocusPainted(false);

        decreaseLightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                lc.decreaseLight();
                main.displayInfo();
            }
        });
        leftPanel.add(decreaseLightButton, lPGridBag);

        lPGridBag.weighty = 1.0;   //request any extra vertical space
        lPGridBag.anchor = GridBagConstraints.NORTH; //bottom of space
        lPGridBag.insets = new Insets(10,0,0,0);  //top padding
        lPGridBag.gridx = 5;       //aligned with button 2
        lPGridBag.gridwidth = 2;   //2 columns wide
        lPGridBag.gridy = 3;

        increaseLightButton = new JButton("+ light");
        increaseLightButton.setBackground(Color.WHITE);
        increaseLightButton.setFocusPainted(false);

        increaseLightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                lc.increaseLight();
                main.displayInfo();
            }
        });
        leftPanel.add(increaseLightButton,lPGridBag);



        //lPGridBag.fill = GridBagConstraints.HORIZONTAL;
        lPGridBag.weighty = 1.0;   //request any extra vertical space
        lPGridBag.anchor = GridBagConstraints.NORTH; //bottom of space
        lPGridBag.insets = new Insets(10,0,0,0);  //top padding
        lPGridBag.gridx = 0;       //aligned with button 2
        lPGridBag.gridwidth = 2;   //2 columns wide
        lPGridBag.gridy = 4;
        leftPanel.add(new JLabel("A/C Control"),lPGridBag);

        lPGridBag.weighty = 1.0;   //request any extra vertical space
        lPGridBag.anchor = GridBagConstraints.NORTH; //bottom of space
        lPGridBag.insets = new Insets(10,0,0,0);  //top padding
        lPGridBag.gridx = 0;       //aligned with button 2
        lPGridBag.gridwidth = 2;   //2 columns wide
        lPGridBag.gridy = 5;

        decreaseTempButton = new JButton("- temperature");
        decreaseTempButton.setBackground(Color.WHITE);
        decreaseTempButton.setFocusPainted(false);

        decreaseTempButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ac.decreaseTemperature();
                main.displayInfo();
            }
        });
        leftPanel.add(decreaseTempButton, lPGridBag);

        lPGridBag.weighty = 1.0;   //request any extra vertical space
        lPGridBag.anchor = GridBagConstraints.NORTH; //bottom of space
        lPGridBag.insets = new Insets(10,0,0,0);  //top padding
        lPGridBag.gridx = 5;       //aligned with button 2
        lPGridBag.gridwidth = 2;   //2 columns wide
        lPGridBag.gridy = 5;

        increaseTempButton = new JButton("+ temperature");
        increaseTempButton.setBackground(Color.WHITE);
        increaseTempButton.setFocusPainted(false);

        increaseTempButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ac.increaseTemperature();
                main.displayInfo();
            }
        });
        leftPanel.add(increaseTempButton,lPGridBag);

        lPGridBag.weighty = 1.0;   //request any extra vertical space
        lPGridBag.anchor = GridBagConstraints.NORTH; //bottom of space
        lPGridBag.insets = new Insets(10,0,0,0);  //top padding
        lPGridBag.gridx = 0;       //aligned with button 2
        lPGridBag.gridwidth = 2;   //2 columns wide
        lPGridBag.gridy = 6;

        leftPanel.add(new JLabel("smoker"), lPGridBag);

        lPGridBag.weighty = 1.0;   //request any extra vertical space
        lPGridBag.anchor = GridBagConstraints.NORTH; //bottom of space
        lPGridBag.insets = new Insets(10,0,0,0);  //top padding
        lPGridBag.gridx = 0;       //aligned with button 2
        lPGridBag.gridwidth = 2;   //2 columns wide
        lPGridBag.gridy = 7;

        useSmokerButton = new JButton("use smoker");
        useSmokerButton.setBackground(Color.WHITE);
        useSmokerButton.setFocusPainted(false);

        useSmokerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                sc.smokeBees();
                main.displayInfo();
            }
        });
        leftPanel.add(useSmokerButton, lPGridBag);



        //left panel
        //====================================================================================
        //center panel


        centerPanel = new JPanel(new GridLayout(0,2));
        infoPanel = new JPanel();

        infoPanel.add(new Label("---farm info---"));
        currentWeatherLabel = new JLabel("Current Weather: " + wc.getWeather());
        currentTemperatureLabel = new JLabel("Current Temperature: " + wc.getTemperature() + "C°");
        smokeInRoom = new JLabel("Smoke in room: " + sc.isSmokeInRoom());
        lightLevelLabel = new JLabel("Light level: " + lc.getPower());
        aCCapacitylLabel = new JLabel("A/C Capacity: " + ac.getCapacity());
        beeConformityLevelLabel = new JLabel("Bee conformity(0/100): ");

        infoPanel.add(currentWeatherLabel);
        infoPanel.add(currentTemperatureLabel);
        infoPanel.add(smokeInRoom);
        infoPanel.add(lightLevelLabel);
        infoPanel.add(aCCapacitylLabel);
        //infoPanel.add(beeConformityLevelLabel);
/*
        beeCountLabel = new JLabel("Bee count: ");
        infoPanel.add(beeCountLabel);

 */



        centerPanel.add(infoPanel);



        //center panel
        //======================================================================================
        //right panel

        mainPanel.add(leftPanel);
        mainPanel.add(centerPanel);
        beeEventTA = new JTextArea();
        String farmInfo = "each bee hive info here";
        beeEventTA.setText(farmInfo);

        beeEventTA.setBackground(Color.darkGray);
        beeEventTA.setForeground(Color.green);
        beeEventTA.setEditable(false);

        JScrollPane eventLog = new JScrollPane(beeEventTA);
        mainPanel.add(eventLog);


        mainBeeCareFrame.add(mainPanel);
        mainBeeCareFrame.setVisible(true);





    }
}
