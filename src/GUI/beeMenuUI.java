package GUI;


import CONTROL.farmControl;
import LOGIC.Main;
import LOGIC.readJSON;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//menú principal


public class beeMenuUI {
    beeCareUI wUI = new beeCareUI();
    Main main = new Main();
    readJSON rj = new readJSON();
    farmControl fc = new farmControl();




    JFrame mainMenuFrame;
    JPanel mainMenuPanel;
    JButton newFarmButton, loadFarmButton, configButton, exitButton;

    beeCareUI bcUI = new beeCareUI();

    public void beeMenu(){
        mainMenuFrame = new JFrame();
        mainMenuPanel = new JPanel();
        mainMenuFrame.setSize(500, 600);
        mainMenuFrame.add(mainMenuPanel);
        mainMenuFrame.setVisible(true);
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //continuar
        newFarmButton = new JButton("New Farm");
        newFarmButton.setBounds(175, 250, 150, 30);
        newFarmButton.setBackground(Color.WHITE);
        newFarmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                mainMenuFrame.setVisible(false);
            }
        });
        mainMenuPanel.add(newFarmButton);

        //cargar granja de abejas
        loadFarmButton = new JButton("Load farm");
        loadFarmButton.setBounds(175, 300, 150, 30);
        loadFarmButton.setBackground(Color.WHITE);
        loadFarmButton.setFocusPainted(false);
        loadFarmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                readJSON rj = new readJSON();

                mainMenuFrame.setVisible(false);
            }
        });
        mainMenuPanel.add(loadFarmButton);

        //configuración
        configButton = new JButton("Config");
        configButton.setBounds(175, 350, 70, 30);
        configButton.setBackground(Color.WHITE);
        configButton.setFocusPainted(false);
        configButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                rj.openFile("src/JSON_files/config.JSON");
            }
        });
        mainMenuPanel.add(configButton);

        //salir
        exitButton = new JButton("Exit");
        exitButton.setBounds(255, 350, 70, 30);
        exitButton.setBackground(Color.WHITE);
        exitButton.setFocusPainted(false);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        mainMenuPanel.add(exitButton);


    }



}
