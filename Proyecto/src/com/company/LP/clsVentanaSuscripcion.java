package com.company.LP;


import com.company.LN.clsGestor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class clsVentanaSuscripcion extends JFrame implements ActionListener, WindowListener {

    private clsGestor objGestor;
    private boolean estado;

    private JPanel panelDeContenido;
    JTextArea textAreaDescripcion;
    JRadioButton rBtnSi;
    JRadioButton rBtnNo;
    ButtonGroup grupoSuscripcion;
    JLabel label;

    private static final String AC_RBOTON_SUSCRIBIR = "botonSuscribir";
    private static final String AC_RBOTON_NO_SUSCRIBIR = "botonNoSuscribir";
    private static final String AC_BOTON_ATRAS = "botonAtras";

    public clsVentanaSuscripcion(clsGestor _objGestor, boolean _estado) {

        objGestor = _objGestor;
        estado = _estado;


        this.setSize(1920, 1080);
        getContentPane().setLayout(null);

        panelDeContenido = new JPanel();
        panelDeContenido.setBounds(0, 0, 1364, 749);
        getContentPane().add(panelDeContenido);
        panelDeContenido.setLayout(null);

        textAreaDescripcion = new JTextArea();
        textAreaDescripcion.setText("suscribase a la aplicacion para poder obtener\r\ntodo el contenido durante un periodo de\r\ntiempo de 30 dias. la suscripcion comienza\r\ndesde el mismo dia que da de alta. si tiene\r\nproductos alquilados no cobrados \r\nautomaticamente su coste total sera 60$\r\n(precio de suscricion estandar)\r\nestado de suscripcion:");
        textAreaDescripcion.setForeground(Color.WHITE);
        textAreaDescripcion.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 25));
        textAreaDescripcion.setEditable(false);
        textAreaDescripcion.setColumns(3);
        textAreaDescripcion.setBackground(Color.BLACK);
        textAreaDescripcion.setBounds(113, 155, 645, 220);
        panelDeContenido.add(textAreaDescripcion);

        rBtnSi = new JRadioButton("suscrito");
        rBtnSi.setHorizontalAlignment(SwingConstants.CENTER);
        rBtnSi.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        rBtnSi.setBounds(113, 486, 286, 52);

        rBtnNo = new JRadioButton("no suscrito");
        rBtnNo.setHorizontalAlignment(SwingConstants.CENTER);
        rBtnNo.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        rBtnNo.setBounds(472, 486, 286, 52);

        if (_estado == true) {
            rBtnSi.setSelected(true);
            rBtnNo.setSelected(false);
        } else {
            rBtnNo.setSelected(true);
            rBtnSi.setSelected(false);
        }

        rBtnSi.setActionCommand(AC_RBOTON_SUSCRIBIR);
        rBtnSi.addActionListener(this);
        estado = true;
        rBtnNo.setActionCommand(AC_RBOTON_NO_SUSCRIBIR);
        estado = false;
        rBtnNo.addActionListener(this);

        panelDeContenido.add(rBtnSi);
        panelDeContenido.add(rBtnNo);

        grupoSuscripcion = new ButtonGroup();
        grupoSuscripcion.add(rBtnSi);
        grupoSuscripcion.add(rBtnNo);

        label = new JLabel("");
        label.setIcon(new ImageIcon(clsVentanaSuscripcion.class.getResource("/com/company/COMUN/imagenAlquilar.jpg")));
        label.setBounds(-69, -685, 1433, 1434);
        panelDeContenido.add(label);

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

                break;
            case AC_RBOTON_NO_SUSCRIBIR:

                break;
            case AC_BOTON_ATRAS:
                clsVentanaMenu objVentanaMenu = new clsVentanaMenu(objGestor, estado);
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
