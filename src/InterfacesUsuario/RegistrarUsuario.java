package InterfacesUsuario;

import InterfacesAdministrador.PanelAdmin;
import InterfacesAdministrador.RegistrarVacante;
import Pojo.Usuario;
import Pojo.Vacante;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegistrarUsuario extends JFrame {
    static ArrayList<Usuario> usuarios= new ArrayList<>();
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton REGRESARButton;
    private JButton REGISTRARButton;
    public RegistrarUsuario(){
        setupFrame();
        initializeComponents();
        add(panel1);

        addActionListeners();
    }

    private void initializeComponents() {
        EventClick eventClick = new EventClick();
    }

    private void setupFrame() {
        setTitle("REGISTRO USUARIO");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setSize(500, 250);
    }

    public class EventClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = textField1.getText();
            String nivelEstudio = textField2.getText();
            String edad = textField3.getText();
            String correo = textField4.getText();
            String telefono = textField5.getText();

            usuarios.add(new Usuario(nombre,nivelEstudio,edad,correo,telefono));
        }
    }
    public static ArrayList<Usuario> getUsuario(){
        return usuarios;
    }

    private void addActionListeners() {
        REGISTRARButton.addActionListener(new EventClick());
        REGRESARButton.addActionListener(e -> {
            this.setVisible(false);
            new PanelUsuario().setVisible(true);
        });

    }
}
