package com.company.LP;

import com.company.LN.clsGestor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout.Alignment;

public class clsVentanaInicio extends JFrame implements ActionListener, WindowListener {

    private JPanel panelDeContenido;
    private JButton btnInicioS;
    private JButton btnRegistrate;
    private JButton btnSalir;
    private JLabel label;

    private final String INICIAR_SESION = "Iniciar sesion";
    private final String REGISTRARSE = "Registate";
    private final String SALIR = "Salir";

    private static final String AC_BOTON_INICIO = "botonInicio";
    private static final String AC_BOTON_REGISTRO = "botonRegistro";



   /* public clsVentanaInicio(clsGestor objGestor) {
        ventanaInicial();
    }*/

    public clsVentanaInicio(clsGestor objGestor) {

        this.setTitle("Akira Videoclub");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridBagLayout());
        getContentPane().add(new JLabel(new ImageIcon("/COMUN/portada.jpg")));


        panelDeContenido = new JPanel();
        panelDeContenido.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panelDeContenido);
        panelDeContenido.setLayout(null);

        label = new JLabel("");
        label.setBounds(-294, -342, 1694, 1080);
        label.setIcon(new ImageIcon(clsVentanaInicio.class.getResource("/com/company/COMUN/portada.jpg")));
        panelDeContenido.add(label);

        btnInicioS = new JButton(INICIAR_SESION);
        btnInicioS.setForeground(Color.BLUE);
        btnInicioS.setBackground(Color.PINK);
        btnInicioS.setBounds(557, 185, 281, 52);
        panelDeContenido.add(btnInicioS);

        btnRegistrate = new JButton(REGISTRARSE);
        btnRegistrate.setForeground(Color.BLUE);
        btnRegistrate.setBackground(Color.PINK);
        btnRegistrate.setBounds(557, 265, 281, 52);
        panelDeContenido.add(btnRegistrate);

        btnSalir = new JButton(SALIR);
        btnSalir.setForeground(Color.BLUE);
        btnSalir.setBackground(Color.PINK);
        btnSalir.setBounds(600, 200, 281, 52);
        panelDeContenido.add(btnSalir);

        this.setSize(1920, 1080);/*Tama�o en pixel*/
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
                clsVentanaEntrar ve = new clsVentanaEntrar();
              //  ve.setVisible(true);
                this.dispose();
                break;
            case AC_BOTON_REGISTRO:
                clsVentanaRegistrar vr = new clsVentanaRegistrar();
                //vr.setVisible(true);
                this.dispose();
                break;
            case SALIR:
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
