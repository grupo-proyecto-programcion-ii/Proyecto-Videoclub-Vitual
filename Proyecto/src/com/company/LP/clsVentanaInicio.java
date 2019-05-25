package com.company.LP;

import com.company.LN.clsGestor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class clsVentanaInicio extends JFrame implements ActionListener, WindowListener {

    private clsGestor objGestor;

    private JPanel panelDeContenido;
    private JButton btnInicioS;
    private JButton btnRegistrate;
    private JButton btnSalir;
    private JLabel label;

    private static final String INICIAR_SESION = "Iniciar sesion";
    private static final String REGISTRARSE = "Registate";
    private static final String SALIR = "Salir";

    private static final String AC_BOTON_INICIO = "botonInicio";
    private static final String AC_BOTON_REGISTRO = "botonRegistro";
    private static final String AC_BOTON_SALIR = "botonSalir";


    public clsVentanaInicio(clsGestor _objGestor) {

        objGestor = _objGestor;

        this.setTitle("Akira Videoclub");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridBagLayout());
        getContentPane().add(new JLabel(new ImageIcon("/COMUN/portada.jpg")));


        panelDeContenido = new JPanel();
        panelDeContenido.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panelDeContenido);
        panelDeContenido.setLayout(null);

        btnInicioS = new JButton(INICIAR_SESION);
        btnInicioS.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        btnInicioS.setForeground(Color.BLUE);
        btnInicioS.setBackground(Color.PINK);
        btnInicioS.setBounds(514, 184, 281, 52);
        btnInicioS.setActionCommand(AC_BOTON_INICIO);
        btnInicioS.addActionListener(this);
        panelDeContenido.add(btnInicioS);

        btnRegistrate = new JButton(REGISTRARSE);
        btnRegistrate.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        btnRegistrate.setForeground(Color.BLUE);
        btnRegistrate.setBackground(Color.PINK);
        btnRegistrate.setBounds(514, 258, 281, 52);
        btnRegistrate.setActionCommand(AC_BOTON_REGISTRO);
        btnRegistrate.addActionListener(this);
        panelDeContenido.add(btnRegistrate);

        btnSalir = new JButton(SALIR);
        btnSalir.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        btnSalir.setForeground(Color.BLUE);
        btnSalir.setBackground(Color.PINK);
        btnSalir.setBounds(514, 337, 281, 52);
        btnSalir.setActionCommand(AC_BOTON_SALIR);
        btnSalir.addActionListener(this);
        panelDeContenido.add(btnSalir);
        
        label = new JLabel("");
        label.setBounds(-294, -342, 1694, 1080);
        label.setIcon(new ImageIcon(clsVentanaInicio.class.getResource("/com/company/COMUN/portada.jpg")));
        panelDeContenido.add(label);

            this.setSize(1920, 1080);/*Tamanio en pixel*/

    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case AC_BOTON_INICIO:
                clsVentanaValidar objVentanaValidar = new clsVentanaValidar(objGestor);
                objVentanaValidar.setVisible(true);
                objVentanaValidar.setExtendedState(6);
                this.dispose();
                break;
            case AC_BOTON_REGISTRO:
                clsVentanaRegistrar objVenatanaRegistrar = new clsVentanaRegistrar(objGestor);
                objVenatanaRegistrar.setVisible(true);
                objVenatanaRegistrar.setExtendedState(6);
                this.dispose();
                break;
            case AC_BOTON_SALIR:
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
