package InterfacesUsuario;

import InterfacesAdministrador.RegistrarVacante;
import Pojo.Postulacione;
import Pojo.Usuario;
import Pojo.Vacante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VacantesPublicadasUsuario extends JFrame  {
    static ArrayList <Postulacione> postulaciones= new ArrayList<>();
    private DefaultListModel<Usuario> elementosModel;
    private DefaultListModel<Vacante> elementosModel1;
    private JPanel panel1;
    private JButton POSTULARSEButton;
    private JButton REGRESARButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JList list1;
    private JList list2;
    private JTextField textField5;
    private JTextField textField6;

    public VacantesPublicadasUsuario(){
        setupFrame();
        llenar();
        initializeComponents();
        add(panel1);

        addActionListeners();
    }

    private void initializeComponents() {
        EventClick eventClick = new EventClick();

    }
    private void setupFrame() {
        setTitle("VACANTES PUBLICADAS");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setSize(500, 500);
    }

    private void addActionListeners() {
        POSTULARSEButton.addActionListener(new EventClick());

        REGRESARButton.addActionListener(e -> {
            PanelUsuario panelUsuario = new PanelUsuario();
            panelUsuario.setVisible(true);
            this.setVisible(false);
        });

        list2.addListSelectionListener(e -> {
            datos();
        });
        list1.addListSelectionListener(e -> {
            datos2();
        });

    }
    public class EventClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombre = textField5.getText();
            String edad = textField6.getText();
            String vacante = textField1.getText();

            postulaciones.add(new Postulacione(nombre,edad,vacante));
        }
    }
    public static ArrayList<Postulacione> getPostulaciones(){
        return postulaciones;
    }

    public void datos(){
        int indice = list2.getSelectedIndex();
        textField1.setText(RegistrarVacante.getVacante().get(indice).getNombreVacante());
        textField2.setText(RegistrarVacante.getVacante().get(indice).getNumVacante());
        textField3.setText(RegistrarVacante.getVacante().get(indice).getSueldo());
        textField4.setText(RegistrarVacante.getVacante().get(indice).getFecha());

    }
    public void datos2(){
        int indice2= list1.getSelectedIndex();
        textField5.setText(RegistrarUsuario.getUsuario().get(indice2).getNombreUsuario());
        textField6.setText(RegistrarUsuario.getUsuario().get(indice2).getEdad());

    }

    public void llenar(){
        elementosModel = new DefaultListModel<>();
        ArrayList<Usuario> lista = RegistrarUsuario.getUsuario();
        for (Usuario elemento: lista) {
            elementosModel.addElement(elemento);
        }
        list1.setModel(elementosModel);

        elementosModel1 = new DefaultListModel<>();
        ArrayList<Vacante> lista2 = RegistrarVacante.getVacante();
        for (Vacante elemento: lista2) {
            elementosModel1.addElement(elemento);
        }
        list2.setModel(elementosModel1);
    }

}
