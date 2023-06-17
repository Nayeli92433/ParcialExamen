package Interfaces;

import InterfacesAdministrador.PanelAdmin;
import InterfacesUsuario.PanelUsuario;
import InterfacesUsuario.RegistrarUsuario;
import Pojo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminIngreso extends JFrame{
    private JPanel panel1, panelCanvas, panelImagen, panelContainer;
    private JTextField textField1;
    private JTextField textField2;
    private JButton REGRESARButton;
    private JButton INGRESARButton;
    public AdminIngreso(){
        setupFrame();
        initializeComponents();
        setupPanelContainer();
        add(panelContainer);

        addActionListeners();
    }

    private void initializeComponents() {
        panelCanvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imagen = new ImageIcon("C:\\Users\\Nayeli Velasco\\IdeaProjects\\ExamenRegistro\\src\\Imagen\\registro-en-linea.png");
                Image img = imagen.getImage();
                g.drawImage(img, 35, 23, null);
            }
        };

        panelImagen = new JPanel();
        panelContainer = new JPanel();
        panelImagen = new JPanel();
    }

    private void setupFrame() {
        setTitle("INGRESO ADMINISTRADOR");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setSize(500, 400);
    }
    private void setupPanelContainer() {

        panelImagen.setLayout(new BorderLayout());
        panelImagen.setPreferredSize(new Dimension(200, 200));
        panelImagen.add(panelCanvas, BorderLayout.CENTER);

        panelContainer.setLayout(new GridLayout(5, 0));
        panelContainer.add(panelImagen);
        panelContainer.add(panel1);

        add(panelContainer);
    }

    private void addActionListeners() {

        REGRESARButton.addActionListener(e -> {
            this.setVisible(false);
            new PanelUsuario().setVisible(true);
        });
        INGRESARButton.addActionListener(e -> {
            this.setVisible(false);
            PanelAdmin panelAdmin= new PanelAdmin();
            panelAdmin.setVisible(true);
        });


    }

}
