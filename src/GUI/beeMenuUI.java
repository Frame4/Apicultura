package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//menú principal


public class beeMenuUI {
    beeCareUI wUI = new beeCareUI();
    JFrame mainMenuFrame;
    JPanel mainMenuPanel;
    JButton continueButton, loadButton, configButton, exitButton;
    beeCareUI bcUI = new beeCareUI();

    public void beeMenu(){
        mainMenuFrame = new JFrame();
        mainMenuPanel = new JPanel();
        mainMenuFrame.setSize(500, 600);
        mainMenuFrame.add(mainMenuPanel);
        mainMenuFrame.setVisible(true);
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //continuar
        continueButton = new JButton("Continue");
        continueButton.setBounds(175, 250, 150, 30);
        continueButton.setBackground(Color.WHITE);
        continueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

            }
        });
        mainMenuPanel.add(continueButton);

        //cargar granja de abejas
        loadButton = new JButton("Load farm");
        loadButton.setBounds(175, 300, 150, 30);
        loadButton.setBackground(Color.WHITE);
        loadButton.setFocusPainted(false);
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {


            }
        });
        mainMenuPanel.add(loadButton);


        //configuración
        configButton = new JButton("Config");
        configButton.setBounds(175, 350, 70, 30);
        configButton.setBackground(Color.WHITE);
        configButton.setFocusPainted(false);
        configButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {

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
