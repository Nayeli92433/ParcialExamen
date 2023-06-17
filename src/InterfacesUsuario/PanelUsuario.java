package InterfacesUsuario;

import Interfaces.Home;
import InterfacesAdministrador.VacantesPublicadas;

import javax.swing.*;
import java.awt.*;

public class PanelUsuario extends JFrame{
        private JPanel panelCanvas;
        private JPanel panelContainer, panelButton, panelImagen, panelCabeza;
        private JButton boton1, boton2, regresar;
        private JLabel titulo;


        public PanelUsuario() {
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
            panelCabeza = new JPanel();

            titulo = new JLabel("PANEL DEL USUARIO");

            boton1 = new JButton("Registrar usuario");
            boton2 = new JButton("Consultar vacantes");
            regresar = new JButton("Regresar");
        }


        private void setupFrame() {
            setTitle("Panel del usuario");
            setLayout(new FlowLayout());
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            setResizable(true);

            setSize(500, 400);
        }

        private void setupPanelContainer() {

            panelImagen.setLayout(new BorderLayout());
            panelImagen.setPreferredSize(new Dimension(200, 100));
            panelImagen.add(panelCanvas, BorderLayout.CENTER);

            panelButton.setLayout(new FlowLayout());
            panelButton.setPreferredSize(new Dimension(200, 200));
            panelButton.add(boton1);
            panelButton.add(boton2);
            panelButton.add(regresar);

            panelCabeza.setLayout(new GridLayout(1,0));
            panelCabeza.setPreferredSize(new Dimension(50, 50));
            panelCabeza.add(titulo);


            panelContainer.setLayout(new GridLayout(4, 0));
            panelContainer.add(panelImagen);
            panelContainer.add(panelButton);

            add(panelContainer);
        }

        private void addActionListeners() {
            boton1.addActionListener(e -> {
                new RegistrarUsuario().setVisible(true);
                this.setVisible(false);
            });
            boton2.addActionListener(e ->{
                new VacantesPublicadasUsuario().setVisible(true);
                this.setVisible(false);
            });
            regresar.addActionListener(e -> {
                Home home = new Home();
                home.setVisible(true);
                this.setVisible(false);
            });
        }

}
