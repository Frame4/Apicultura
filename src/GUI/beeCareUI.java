package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import CONTROL.weather;
import CONTROL.weatherControl;


public class beeCareUI {
    weather weather = new weather();
    CONTROL.weatherControl weatherControl = new weatherControl();

    JFrame mainBeeCareFrame;
    JPanel mainPanel,leftPanel,centerPanel, infoPanel;
    JTextArea beeEventTA;

    JLabel currentWeatherLabel,currentTemperatureLabel,smokeInRoom,beeConformityLevelLabel;
    JLabel beeCountLabel;
    JLabel lightLevelLabel;
    JButton increaseLightButton,decreaseLightButton;
    JLabel aCCapacitylLabel;
    JButton increaseTempButton,decreaseTempButton;
    JButton useSmokerButton;
    JComboBox<String> selectBeehive; //cambiar string a objBeeHive;
    JButton selectBeeHiveButton;


    //colors
    Color skyBlue = new Color(173,216,230);

    public void weatherJPanel(){

        mainBeeCareFrame = new JFrame("bee Care");
        mainBeeCareFrame.setSize(900,600);
        mainBeeCareFrame.setVisible(true);
        mainBeeCareFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainBeeCareFrame.setBackground(skyBlue);

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
        leftPanel.add(new JLabel("Hive Control"),lPGridBag);


        //combobox
        selectBeehive = new JComboBox<String>();
        selectBeehive.addItem("hive 1");
        selectBeehive.setBackground(Color.white);
        lPGridBag.fill = GridBagConstraints.HORIZONTAL;
        lPGridBag.ipady = 5;
        lPGridBag.ipadx = 5;
        lPGridBag.anchor = GridBagConstraints.NORTH; //bottom of space
        lPGridBag.insets = new Insets(10,0,0,0);  //top padding
        lPGridBag.gridx = 0;       //aligned with button 2
        lPGridBag.gridwidth = 1;   //2 columns wide
        lPGridBag.gridy = 1;       //third row
        leftPanel.add(selectBeehive, lPGridBag);

        //select hive button
        selectBeeHiveButton = new JButton("select hive");
        selectBeeHiveButton.setBackground(Color.WHITE);
        selectBeeHiveButton.setFocusPainted(false);

        selectBeeHiveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

            }
        });//getHive; print hiveInfo en el textArea

        lPGridBag.fill = GridBagConstraints.HORIZONTAL;
        lPGridBag.weighty = 1.0;   //request any extra vertical space
        lPGridBag.anchor = GridBagConstraints.NORTH; //bottom of space
        lPGridBag.insets = new Insets(10,0,0,0);  //top padding
        lPGridBag.gridx = 5;       //aligned with button 2
        lPGridBag.gridwidth = 2;   //2 columns wide
        lPGridBag.gridy = 1;       //third row
        leftPanel.add(selectBeeHiveButton, lPGridBag);

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
        leftPanel.add(decreaseLightButton, lPGridBag);

        lPGridBag.weighty = 1.0;   //request any extra vertical space
        lPGridBag.anchor = GridBagConstraints.NORTH; //bottom of space
        lPGridBag.insets = new Insets(10,0,0,0);  //top padding
        lPGridBag.gridx = 5;       //aligned with button 2
        lPGridBag.gridwidth = 2;   //2 columns wide
        lPGridBag.gridy = 3;

        increaseLightButton = new JButton("+ light");
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
        leftPanel.add(decreaseTempButton, lPGridBag);

        lPGridBag.weighty = 1.0;   //request any extra vertical space
        lPGridBag.anchor = GridBagConstraints.NORTH; //bottom of space
        lPGridBag.insets = new Insets(10,0,0,0);  //top padding
        lPGridBag.gridx = 5;       //aligned with button 2
        lPGridBag.gridwidth = 2;   //2 columns wide
        lPGridBag.gridy = 5;

        increaseTempButton = new JButton("+ temperature");
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
        leftPanel.add(useSmokerButton, lPGridBag);

        leftPanel.setBackground(skyBlue);

        //left panel
        //====================================================================================
        //center panel


        centerPanel = new JPanel(new GridLayout(0,2));
        infoPanel = new JPanel();

        infoPanel.add(new Label("---farm info---"));
        currentWeatherLabel = new JLabel("Current Weather: " + weatherControl.getWeather());
        currentTemperatureLabel = new JLabel("Current Temperature: " + weatherControl.getTemperature() + "C°");
        smokeInRoom = new JLabel("Smoke in the room: ");
        lightLevelLabel = new JLabel("Light level: ");
        aCCapacitylLabel = new JLabel("A/C Capacity: ");//off-min-mid-max
        beeConformityLevelLabel = new JLabel("Bee conformity(0/100): ");

        infoPanel.add(currentWeatherLabel);
        infoPanel.add(currentTemperatureLabel);
        infoPanel.add(smokeInRoom);
        infoPanel.add(lightLevelLabel);
        infoPanel.add(aCCapacitylLabel);
        infoPanel.add(beeConformityLevelLabel);

        infoPanel.add(new JLabel("---hive status---"));
        beeCountLabel = new JLabel("Bee count: ");
        infoPanel.add(beeCountLabel);



        centerPanel.add(infoPanel);
        centerPanel.setBackground(skyBlue);


        //center panel
        //======================================================================================
        //right panel

        mainPanel.add(leftPanel);
        mainPanel.add(centerPanel);
        beeEventTA = new JTextArea();

        beeEventTA.setBackground(Color.darkGray);
        beeEventTA.setForeground(Color.green);

        JScrollPane eventLog = new JScrollPane(beeEventTA);
        mainPanel.add(eventLog);


        mainBeeCareFrame.add(mainPanel);

        mainBeeCareFrame.setVisible(true);





    }
}
