package com.company.LP;

import com.company.LN.clsGestor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class clsVentanaMenu extends JFrame implements ActionListener, WindowListener {

    private clsGestor objGestor;
    private String id;

    private JPanel panelDeContenido;
    private JButton btnAlquilarA;
    private JButton btnVisualizarArticulos;
    private JButton btnSuscripcion;
    private JButton btnVolverI;
    private JTextArea textAreaAlquilar;
    private JTextArea textAreaSuscripcion;
    private JTextArea txtrVisualiceTodosLos;
    private JLabel lblImagenNegro1;
    private JLabel lblImagenNegor2;
    private JLabel lblImagenAlquiler;
    private JLabel lblImagenSuscripcion;

    private static final String ALQUILAR = "Alquilar articulos";
    private static final String VISUALIZAR_ARTICULOS = "Visualizar articulos alquilados";
    private static final String SUSCRIBIR = "Suscripcion personal";
    private static final String VOLVER_INICIO = "Volver a la pantalla de inicio";

    private static final String AC_BOTON_ALQUILAR = "botonAlquilar";
    private static final String AC_BOTON_VISUALIZAR = "botonVisualizar";
    private static final String AC_BOTON_SUSCRIBIR = "botonSuscribir";
    private static final String AC_BOTON_VOLVER = "botonVolver";


    public clsVentanaMenu(clsGestor _objGestor, String _id) {

        objGestor = _objGestor;
        id = _id;

        this.setSize(1920, 1080);
        getContentPane().setLayout(null);
        addWindowListener(this);

        panelDeContenido = new JPanel();
        panelDeContenido.setBounds(0, 0, 1364, 749);
        getContentPane().add(panelDeContenido);
        panelDeContenido.setLayout(null);

        btnAlquilarA = new JButton(ALQUILAR);
        btnAlquilarA.setBounds(137, 204, 432, 50);
        btnAlquilarA.setForeground(Color.WHITE);
        btnAlquilarA.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        btnAlquilarA.setBackground(new Color(165, 42, 42));
        btnAlquilarA.setActionCommand(AC_BOTON_ALQUILAR);
        btnAlquilarA.addActionListener(this);
        panelDeContenido.add(btnAlquilarA);

        btnVisualizarArticulos = new JButton(VISUALIZAR_ARTICULOS);
        btnVisualizarArticulos.setForeground(Color.WHITE);
        btnVisualizarArticulos.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        btnVisualizarArticulos.setBackground(new Color(50, 205, 50));
        btnVisualizarArticulos.setBounds(463, 463, 465, 69);
        btnVisualizarArticulos.setActionCommand(AC_BOTON_VISUALIZAR);
        btnVisualizarArticulos.addActionListener(this);
        panelDeContenido.add(btnVisualizarArticulos);

        btnSuscripcion = new JButton(SUSCRIBIR);
        btnSuscripcion.setForeground(Color.WHITE);
        btnSuscripcion.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        btnSuscripcion.setBackground(new Color(153, 50, 204));
        btnSuscripcion.setBounds(817, 204, 432, 50);
        btnSuscripcion.setActionCommand(AC_BOTON_SUSCRIBIR);
        btnSuscripcion.addActionListener(this);
        panelDeContenido.add(btnSuscripcion);

        btnVolverI = new JButton(VOLVER_INICIO);
        btnVolverI.setForeground(Color.WHITE);
        btnVolverI.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        btnVolverI.setBackground(Color.BLACK);
        btnVolverI.setBounds(463, 601, 465, 31);
        btnVolverI.setActionCommand(AC_BOTON_VOLVER);
        btnVolverI.addActionListener(this);
        panelDeContenido.add(btnVolverI);

        textAreaAlquilar = new JTextArea();
        textAreaAlquilar.setEditable(false);
        textAreaAlquilar.setText("alquile los articulos exactos que quiera alquilar\r\nel tiempo exacto");
        textAreaAlquilar.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 15));
        textAreaAlquilar.setForeground(Color.WHITE);
        textAreaAlquilar.setBackground(Color.BLACK);
        textAreaAlquilar.setBounds(137, 252, 432, 44);
        panelDeContenido.add(textAreaAlquilar);

        textAreaSuscripcion = new JTextArea();
        textAreaSuscripcion.setEditable(false);
        textAreaSuscripcion.setColumns(3);
        textAreaSuscripcion.setText("suscribase a la aplicacion para poder obtener\r\ntodo el contenido durante un periodo de\r\ntiempo de 30 dias");
        textAreaSuscripcion.setForeground(Color.WHITE);
        textAreaSuscripcion.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 15));
        textAreaSuscripcion.setBackground(Color.BLACK);
        textAreaSuscripcion.setBounds(817, 252, 432, 59);
        panelDeContenido.add(textAreaSuscripcion);

        txtrVisualiceTodosLos = new JTextArea();
        txtrVisualiceTodosLos.setEditable(false);
        txtrVisualiceTodosLos.setText("visualice todos los articulos que tiene acceso para\r\nreproducir");
        txtrVisualiceTodosLos.setForeground(Color.WHITE);
        txtrVisualiceTodosLos.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 15));
        txtrVisualiceTodosLos.setColumns(3);
        txtrVisualiceTodosLos.setBackground(Color.BLACK);
        txtrVisualiceTodosLos.setBounds(463, 531, 465, 44);
        panelDeContenido.add(txtrVisualiceTodosLos);

        lblImagenNegro1 = new JLabel("");
        lblImagenNegro1.setIcon(new ImageIcon(clsVentanaMenu.class.getResource("/com/company/COMUN/AlquilerMusica.jpg")));
        lblImagenNegro1.setBackground(Color.BLACK);
        lblImagenNegro1.setBounds(0, 693, 691, 59);
        panelDeContenido.add(lblImagenNegro1);

        lblImagenNegor2 = new JLabel("");
        lblImagenNegor2.setIcon(new ImageIcon(clsVentanaMenu.class.getResource("/com/company/COMUN/AlquilerMusica.jpg")));
        lblImagenNegor2.setBackground(Color.BLACK);
        lblImagenNegor2.setBounds(0, 0, 691, 59);
        panelDeContenido.add(lblImagenNegor2);

        lblImagenAlquiler = new JLabel("");
        lblImagenAlquiler.setBackground(Color.BLACK);
        lblImagenAlquiler.setIcon(new ImageIcon(clsVentanaMenu.class.getResource("/com/company/COMUN/IA3.jpg")));
        lblImagenAlquiler.setBounds(0, 0, 691, 752);
        panelDeContenido.add(lblImagenAlquiler);

        lblImagenSuscripcion = new JLabel("");
        lblImagenSuscripcion.setIcon(new ImageIcon(clsVentanaMenu.class.getResource("/com/company/COMUN/imagenSuscripcion.jpg")));
        lblImagenSuscripcion.setBounds(690, 0, 674, 752);
        panelDeContenido.add(lblImagenSuscripcion);

    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {


        switch (e.getActionCommand()) {

            case AC_BOTON_ALQUILAR:
                clsVenatanaMenuAlquiler objVenatanMenuAlquiler = new clsVenatanaMenuAlquiler(objGestor, id);
                objVenatanMenuAlquiler.setVisible(true);
                objVenatanMenuAlquiler.setExtendedState(6);
                this.dispose();
                break;
            case AC_BOTON_SUSCRIBIR:
                clsVentanaSuscripcion objVentanaSuscripcion = new clsVentanaSuscripcion(objGestor, id);
                objVentanaSuscripcion.setVisible(true);
                objVentanaSuscripcion.setExtendedState(6);
                this.dispose();
                break;
            case AC_BOTON_VISUALIZAR:

                break;
            case AC_BOTON_VOLVER:
                clsVentanaInicio objVentanaInicio = new clsVentanaInicio(objGestor);
                objVentanaInicio.setVisible(true);
                objVentanaInicio.setExtendedState(6);
                this.dispose();
                break;

        }
    }

    /**
     * Invoked the first time a window is made visible.
     *
     * @param e the event to be processed
     */
    @Override
    public void windowOpened(WindowEvent e) {

    }

    /**
     * Invoked when the user attempts to close the window
     * from the window's system menu.
     *
     * @param e the event to be processed
     */
    @Override
    public void windowClosing(WindowEvent e) {

        int eleccion = JOptionPane.showConfirmDialog(this, "¿Estas seguro?", "Salir",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
        if (eleccion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }

    /**
     * Invoked when a window has been closed as the result
     * of calling dispose on the window.
     *
     * @param e the event to be processed
     */
    @Override
    public void windowClosed(WindowEvent e) {

    }

    /**
     * Invoked when a window is changed from a normal to a
     * minimized state. For many platforms, a minimized window
     * is displayed as the icon specified in the window's
     * iconImage property.
     *
     * @param e the event to be processed
     * @see Frame#setIconImage
     */
    @Override
    public void windowIconified(WindowEvent e) {

    }

    /**
     * Invoked when a window is changed from a minimized
     * to a normal state.
     *
     * @param e the event to be processed
     */
    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    /**
     * Invoked when the Window is set to be the active Window. Only a Frame or
     * a Dialog can be the active Window. The native windowing system may
     * denote the active Window or its children with special decorations, such
     * as a highlighted title bar. The active Window is always either the
     * focused Window, or the first Frame or Dialog that is an owner of the
     * focused Window.
     *
     * @param e the event to be processed
     */
    @Override
    public void windowActivated(WindowEvent e) {

    }

    /**
     * Invoked when a Window is no longer the active Window. Only a Frame or a
     * Dialog can be the active Window. The native windowing system may denote
     * the active Window or its children with special decorations, such as a
     * highlighted title bar. The active Window is always either the focused
     * Window, or the first Frame or Dialog that is an owner of the focused
     * Window.
     *
     * @param e the event to be processed
     */
    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
