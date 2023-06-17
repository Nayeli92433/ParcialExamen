package InterfacesAdministrador;

import InterfacesAdministrador.RegistrarVacante;
import InterfacesUsuario.PanelUsuario;
import Pojo.Vacante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class VacantesPublicadas extends JFrame{
    private JList<Vacante> jList ;
    private DefaultListModel<Vacante> elementosModel;
    private JPanel panel1, paneList, panelContainer;
    private JButton ELIMINARButton;
    private JButton ACTUALIZARButton;
    private JButton REGRESARButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;

    public VacantesPublicadas(){
        setupFrame();
        initializeComponents();
        llenar();
        setupPanelContainer();
        add(panelContainer);

        addActionListeners();
    }
    private void initializeComponents(){
        jList = new JList<>();

        paneList = new JPanel();
        panelContainer = new JPanel();
    }
    private void setupFrame() {
        setTitle("VACANTES PUBLICADAS");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(true);
        setSize(500, 500);
    }
    private void setupPanelContainer() {
        paneList.setLayout(new GridLayout(1, 0));
        paneList.add(jList);
        paneList.setPreferredSize(new Dimension(300,100));

        panelContainer.setLayout(new GridLayout(5, 0));
        panelContainer.add(paneList);
        panelContainer.add(panel1);

        add(panelContainer);
    }

    private void addActionListeners() {
        REGRESARButton.addActionListener(e -> {
            PanelAdmin panelAdmin= new PanelAdmin();
            panelAdmin.setVisible(true);
            this.setVisible(false);
        });


        /*guardar.addActionListener(new EventClick1());
        cancelar.addActionListener(e -> {
            this.setVisible(false);
            new Principal().setVisible(true);
        });*/
        jList.addListSelectionListener(e -> {
            datos();
        });
    }

    public void datos(){
        int indice = jList.getSelectedIndex();
        textField2.setText(RegistrarVacante.getVacante().get(indice).getNombreVacante());
        textField2.setText(RegistrarVacante.getVacante().get(indice).getNumVacante());
        textField1.setText(RegistrarVacante.getVacante().get(indice).getExperiencia());
        textField4.setText(RegistrarVacante.getVacante().get(indice).getFecha());
        textField5.setText(RegistrarVacante.getVacante().get(indice).getSueldo());
        textField6.setText(RegistrarVacante.getVacante().get(indice).getDescripcion());

    }
    public void llenar(){
        elementosModel = new DefaultListModel<>();
        ArrayList<Vacante> lista = RegistrarVacante.getVacante();
        for (Vacante elemento: lista) {
            elementosModel.addElement(elemento);
        }
        jList.setModel(elementosModel);
    }

}


