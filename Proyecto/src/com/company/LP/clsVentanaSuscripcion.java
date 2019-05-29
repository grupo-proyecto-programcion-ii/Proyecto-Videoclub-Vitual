package com.company.LP;


import com.company.COMUN.itfProperty;
import com.company.LN.clsGestor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Date;

import static com.company.COMUN.clsConstantes.*;


public class clsVentanaSuscripcion extends JFrame implements ActionListener, WindowListener {

    private clsGestor objGestor;
    private String id;
    private boolean estado;
    private double costeT;
    private Date fechaS;

    private JPanel panelDeContenido;
    private JTextArea textAreaDescripcion;
    private JRadioButton rBtnSi;
    private JRadioButton rBtnNo;
    private ButtonGroup grupoSuscripcion;
    private JLabel label;
    private JButton btnVolver;
    private JTextArea txtrSuCosteTotal;

    private static final String AC_RBOTON_SUSCRIBIR = "botonSuscribir";
    private static final String AC_RBOTON_NO_SUSCRIBIR = "botonNoSuscribir";
    private static final String AC_BOTON_ATRAS = "botonAtras";


    public clsVentanaSuscripcion(clsGestor _objGestor, String _id) {

        objGestor = _objGestor;
        id = _id;

        leerDatos(_id);

        this.setSize(1920, 1080);
        getContentPane().setLayout(null);

        panelDeContenido = new JPanel();
        panelDeContenido.setBounds(0, 0, 1364, 749);
        getContentPane().add(panelDeContenido);
        panelDeContenido.setLayout(null);

        rBtnSi = new JRadioButton("suscrito");
        rBtnSi.setHorizontalAlignment(SwingConstants.CENTER);
        rBtnSi.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        rBtnSi.setBounds(113, 433, 286, 52);
        rBtnSi.setActionCommand(AC_RBOTON_SUSCRIBIR);
        rBtnSi.addActionListener(this);


        rBtnNo = new JRadioButton("no suscrito");
        rBtnNo.setHorizontalAlignment(SwingConstants.CENTER);
        rBtnNo.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        rBtnNo.setBounds(472, 433, 286, 52);
        rBtnNo.setActionCommand(AC_RBOTON_NO_SUSCRIBIR);
        rBtnNo.addActionListener(this);

        panelDeContenido.add(rBtnSi);
        panelDeContenido.add(rBtnNo);

        grupoSuscripcion = new ButtonGroup();
        grupoSuscripcion.add(rBtnSi);
        grupoSuscripcion.add(rBtnNo);

        textAreaDescripcion = new JTextArea();
        textAreaDescripcion.setText("suscribase a la aplicacion para poder obtener\r\ntodo el contenido durante un periodo de\r\ntiempo de 30 dias. la suscripcion comienza\r\ndesde el mismo dia que da de alta. si tiene\r\nproductos alquilados no cobrados \r\nautomaticamente su coste total sera 60$\r\n(precio de suscricion estandar)\r\nestado de suscripcion:");
        textAreaDescripcion.setForeground(Color.BLACK);
        textAreaDescripcion.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 25));
        textAreaDescripcion.setEditable(false);
        textAreaDescripcion.setColumns(3);
        textAreaDescripcion.setBackground(Color.WHITE);
        textAreaDescripcion.setBounds(113, 155, 645, 330);
        panelDeContenido.add(textAreaDescripcion);

        estadoSeleccionado();

        btnVolver = new JButton("Volver a la pantalla de menu");
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        btnVolver.setBackground(Color.BLACK);
        btnVolver.setActionCommand("botonVolver");
        btnVolver.setBounds(402, 633, 465, 31);
        btnVolver.setActionCommand(AC_BOTON_ATRAS);
        btnVolver.addActionListener(this);
        panelDeContenido.add(btnVolver);

        txtrSuCosteTotal = new JTextArea();
        txtrSuCosteTotal.setText("Su coste total actualemnte es de " + costeT + "$");
        txtrSuCosteTotal.setForeground(Color.BLACK);
        txtrSuCosteTotal.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 25));
        txtrSuCosteTotal.setEditable(false);
        txtrSuCosteTotal.setColumns(3);
        txtrSuCosteTotal.setBackground(Color.WHITE);
        txtrSuCosteTotal.setBounds(764, 454, 590, 31);
        panelDeContenido.add(txtrSuCosteTotal);
        
        JButton btnForzarBajaSuscripcion = new JButton("Forzar baja suscripcion");
        btnForzarBajaSuscripcion.setForeground(Color.WHITE);
        btnForzarBajaSuscripcion.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        btnForzarBajaSuscripcion.setBackground(Color.BLACK);
        btnForzarBajaSuscripcion.setActionCommand("botonVolver");
        btnForzarBajaSuscripcion.setBounds(378, 536, 505, 70);
        panelDeContenido.add(btnForzarBajaSuscripcion);

        label = new JLabel("");
        label.setIcon(new ImageIcon(clsVentanaSuscripcion.class.getResource("/com/company/COMUN/imagenAlquilar.jpg")));
        label.setBounds(-69, -685, 1433, 1434);
        panelDeContenido.add(label);

    }

    private void leerDatos(String id){
        ArrayList<itfProperty> lUsuarios = objGestor.leerUsuarios();
        for (itfProperty usuario : lUsuarios) {
            if (usuario.getPropertyU(USUARIO_IDENTIFICADOR).equals(id)) {
                estado = (boolean) usuario.getPropertyU(USUARIO_SUSCRIPCION);
                fechaS = (Date) usuario.getPropertyU(USUARIO_FECHA_SUSCRIPCION);
                costeT = (Double) usuario.getPropertyU(USUARIO_COSTE_TOTAL);
            }
        }
    }

    private void estadoSeleccionado(){

        if (estado == true) {
            rBtnSi.setSelected(true);
            rBtnNo.setSelected(false);
        } else {
            rBtnNo.setSelected(true);
            rBtnSi.setSelected(false);
        }

    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case AC_RBOTON_SUSCRIBIR:
                objGestor.anadirSuscripcion(id);
                javax.swing.JOptionPane.showMessageDialog(this,
                        "Su suscripcion esta dada de alta hasta el dia " +
                                fechaS+" tendras ahora acceso a todo el contenido por 60$");
                estado = true;
                estadoSeleccionado();
                break;
            case AC_RBOTON_NO_SUSCRIBIR:
                if (estado == true) {
                    javax.swing.JOptionPane.showMessageDialog(this,
                            "Su suscripcion esta dada de alta hasta el dia " +
                                    fechaS);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this,
                            "Actualmente la suscripcion no esta dado de alta");
                }
                estadoSeleccionado();
                break;
            case AC_BOTON_ATRAS:
                clsVentanaMenu objVentanaMenu = new clsVentanaMenu(objGestor, id);
                objVentanaMenu.setVisible(true);
                objVentanaMenu.setExtendedState(6);
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
