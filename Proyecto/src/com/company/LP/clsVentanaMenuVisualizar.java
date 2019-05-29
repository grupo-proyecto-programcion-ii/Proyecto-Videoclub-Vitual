package com.company.LP;

import com.company.LN.clsGestor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class clsVentanaMenuVisualizar extends JFrame implements ActionListener, WindowListener {


    private clsGestor objGestor;
    private String id;

    private static final String AC_BOTON_MOSTRAR_ALQUILER_ARTICULOS = "botonMostrarArticulos";
    private static final String AC_BOTON_MOSTRAR_ALQUILER_PELICULAS = "botonMostrarPeliculas";
    private static final String AC_BOTON_MOSTRAR_ALQUILER_VIDEOJUEGOS = "botonMostrarVideojuegos";
    private static final String AC_BOTON_MOSTRAR_ALQUILER_MUSICA = "botonMostrarMusica";
    private static final String AC_BOTON_VOLVER = "botonVolver";


    public clsVentanaMenuVisualizar(clsGestor _objGestor, String _id) {

        objGestor = _objGestor;
        id = _id;

        addWindowListener(this);


    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case AC_BOTON_MOSTRAR_ALQUILER_ARTICULOS:

                break;
            case AC_BOTON_MOSTRAR_ALQUILER_PELICULAS:

                break;
            case AC_BOTON_MOSTRAR_ALQUILER_VIDEOJUEGOS:

                break;
            case AC_BOTON_MOSTRAR_ALQUILER_MUSICA:

                break;
            case AC_BOTON_VOLVER:
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
