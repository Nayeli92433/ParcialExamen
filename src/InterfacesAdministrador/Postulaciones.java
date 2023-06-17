package InterfacesAdministrador;

import InterfacesUsuario.VacantesPublicadasUsuario;
import Pojo.Postulacione;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Postulaciones extends JFrame{
    private JList<Postulacione> jList ;
    private DefaultListModel<Postulacione> elementosModel;
    private JPanel panel1;
    private JList list1;
    private JButton ELIMINARButton;
    private JButton REGRESARButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public Postulaciones(){
        setupFrame();
        llenar();
        initializeComponents();
        add(panel1);

        addActionListeners();
    }

    private void setupFrame() {
        setTitle("POSTULACIONES");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setSize(500, 500);
    }

    private void initializeComponents(){
        jList = new JList<Postulacione>();

    }
    private void addActionListeners() {
        REGRESARButton.addActionListener(e -> {
            PanelAdmin panelAdmin= new PanelAdmin();
            panelAdmin.setVisible(true);
            this.setVisible(false);
        });
        list1.addListSelectionListener(e -> {
            datos();
        });
    }

    public void datos(){
        int indice = list1.getSelectedIndex();
        textField1.setText(VacantesPublicadasUsuario.getPostulaciones().get(indice).getNombreUsuario());
        textField1.setText(VacantesPublicadasUsuario.getPostulaciones().get(indice).getEdad());
        textField1.setText(VacantesPublicadasUsuario.getPostulaciones().get(indice).getVacante());
    }

    public void llenar(){
        elementosModel = new DefaultListModel<Postulacione>();
        ArrayList<Postulacione> lista = VacantesPublicadasUsuario.getPostulaciones();
        for (Postulacione elemento: lista) {
            elementosModel.addElement(elemento);
        }
        jList.setModel(elementosModel);
    }
}
