package Interfaces;

import InterfacesUsuario.PanelUsuario;
import InterfacesUsuario.RegistrarUsuario;

import javax.swing.*;
import java.awt.*;

public class Home extends JFrame {
    private JPanel panelCanvas;
    private JPanel panelContainer, panelButton, panelImagen;
    private JButton boton1, boton2;

    public Home() {
        initializeComponents();
        setupFrame();
        setupPanelContainer();

        add(panelContainer);
        addActionListeners();
    }

    private void initializeComponents() {

        panelCanvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imagen = new ImageIcon("C:\\Users\\Nayeli Velasco\\IdeaProjects\\ExamenRegistro\\src\\Imagen\\derechos-de-autor.png");
                Image img = imagen.getImage();
                g.drawImage(img, 35, 23, null);
            }
        };

        panelContainer = new JPanel();
        panelButton = new JPanel();
        panelImagen = new JPanel();

        boton1 = new JButton("USUARIO");
        boton2 = new JButton("ADMINISTRADOR");
    }


    private void setupFrame() {
        setTitle("HOME");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setSize(300, 400);
    }

    private void setupPanelContainer() {

        panelImagen.setLayout(new BorderLayout());
        panelImagen.setPreferredSize(new Dimension(200, 200));
        panelImagen.add(panelCanvas, BorderLayout.CENTER);

        panelButton.setLayout(new FlowLayout());
        panelButton.setPreferredSize(new Dimension(200, 200));
        panelButton.add(boton1);
        panelButton.add(boton2);

        panelContainer.setLayout(new GridLayout(2, 0));
        panelContainer.add(panelImagen);
        panelContainer.add(panelButton);

        add(panelContainer);
    }

    private void addActionListeners() {
        boton1.addActionListener(e -> {
            PanelUsuario panelUsuario= new PanelUsuario();
            panelUsuario.setVisible(true);
            this.setVisible(false);
        });
        boton2.addActionListener(e ->{
            new AdminIngreso().setVisible(true);
            this.setVisible(false);
        });
    }
}
