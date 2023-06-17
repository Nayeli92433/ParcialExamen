package InterfacesAdministrador;

import Pojo.Vacante;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegistrarVacante extends JFrame implements ChangeListener {
    static ArrayList<Vacante> vacantes = new ArrayList<>();
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JRadioButton experienciaRadioButton;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton REGRESARButton;
    private JButton PUBLICARButton;


    public RegistrarVacante() {
        setupFrame();
        initializeComponents();
        add(panel1);

        experienciaRadioButton.addChangeListener(this);
        addActionListeners();
    }

    private void initializeComponents() {

        EventClick eventClick = new EventClick();
    }

    private void setupFrame() {
        setTitle("REGISTRO VACANTE");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setSize(550, 350);
        textField3.setEditable(false);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (experienciaRadioButton.isSelected()) {
            textField3.setEditable(true);
        }
    }

    public class EventClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = textField1.getText();
            String numero = textField2.getText();
            String experiencia = textField3.getText();
            String fecha = textField4.getText();
            String sueldo = textField5.getText();
            String descripcion = textField6.getText();


            vacantes.add(new Vacante(nombre, numero, experiencia, fecha, sueldo, descripcion));
        }
    }
    public static ArrayList<Vacante> getVacante(){
        return vacantes;
    }
    private void addActionListeners() {
        PUBLICARButton.addActionListener(new EventClick());
        REGRESARButton.addActionListener(e -> {
            this.setVisible(false);
            new PanelAdmin().setVisible(true);
        });

    }
}
