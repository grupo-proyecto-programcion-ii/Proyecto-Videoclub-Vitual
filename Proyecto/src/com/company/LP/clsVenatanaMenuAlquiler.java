package com.company.LP;

import com.company.LN.clsGestor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class clsVenatanaMenuAlquiler extends JFrame implements ActionListener, WindowListener {

    private clsGestor objGestor;
    private String id;

    private JPanel panel;
    private JButton btnMostrarArticulos;
    private JButton btnMostrarPeliculas;
    private JButton btnPeliculasPtos;
    private JButton btnMostrarVideojuegos;
    private JButton btnVideojuegosPtos;
    private JButton btnMostrarMusica;
    private JButton btnMusicaAnio;
    private JButton btnSalir;
    private JLabel label;

    private static final String AC_BOTON_MOSTRAR_ARTICULOS = "botonMostrarArticulos";
    private static final String AC_BOTON_MOSTRAR_PELICULAS = "botonMostrarPeliculas";
    private static final String AC_BOTON_MOSTRAR_PELICULAS_POR_PUNTOS = "botonMostrarPeliculasPtos";
    private static final String AC_BOTON_MOSTRAR_VIDEOJUEGOS = "botonMostrarVideojuegos";
    private static final String AC_BOTON_MOSTRAR_VIDEOJUEGOS_POR_PUNTOS = "botonMostrarVideojuegosPtos";
    private static final String AC_BOTON_MOSTRAR_MUSICA = "botonMostrarMusica";
    private static final String AC_BOTON_MOSTRAR_MUSICA_POR_ANIO = "botonMostrarMusicaAnio";
    private static final String AC_BOTON_VOLVER = "botonVolver";


    public clsVenatanaMenuAlquiler(clsGestor _objGestor, String _id) {

        objGestor = _objGestor;
        id = _id;
        
        this.setSize(1920, 1080);
        getContentPane().setLayout(null);
        addWindowListener(this);
        
        panel = new JPanel();
        panel.setBounds(0, 0, 1364, 749);
        getContentPane().add(panel);
        panel.setLayout(null);
        
        btnMostrarArticulos = new JButton("Mostrar  todos los articulos disponibles");
        btnMostrarArticulos.setForeground(Color.WHITE);
        btnMostrarArticulos.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        btnMostrarArticulos.setBackground(new Color(165, 42, 42));
        btnMostrarArticulos.setActionCommand(AC_BOTON_MOSTRAR_ARTICULOS);
        btnMostrarArticulos.addActionListener(this);
        btnMostrarArticulos.setBounds(410, 191, 550, 50);
        panel.add(btnMostrarArticulos);
        
        btnMostrarPeliculas = new JButton("Mostrar peliculas disponibles");
        btnMostrarPeliculas.setForeground(Color.WHITE);
        btnMostrarPeliculas.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        btnMostrarPeliculas.setBackground(new Color(165, 42, 42));
        btnMostrarPeliculas.setActionCommand(AC_BOTON_MOSTRAR_PELICULAS);
        btnMostrarPeliculas.addActionListener(this);
        btnMostrarPeliculas.setBounds(749, 346, 550, 50);
        panel.add(btnMostrarPeliculas);

        btnPeliculasPtos = new JButton("Mostrar peliculas por puntos");
        btnPeliculasPtos.setForeground(Color.WHITE);
        btnPeliculasPtos.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        btnPeliculasPtos.setBackground(new Color(165, 42, 42));
        btnPeliculasPtos.setActionCommand(AC_BOTON_MOSTRAR_PELICULAS_POR_PUNTOS);
        btnPeliculasPtos.addActionListener(this);
        btnPeliculasPtos.setBounds(70, 346, 550, 50);
        panel.add(btnPeliculasPtos);
        
        btnMostrarVideojuegos = new JButton("Mostrar videojuegos disponibles");
        btnMostrarVideojuegos.setForeground(Color.WHITE);
        btnMostrarVideojuegos.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        btnMostrarVideojuegos.setBackground(new Color(165, 42, 42));
        btnMostrarVideojuegos.setActionCommand(AC_BOTON_MOSTRAR_VIDEOJUEGOS);
        btnMostrarVideojuegos.addActionListener(this);
        btnMostrarVideojuegos.setBounds(749, 424, 550, 50);
        panel.add(btnMostrarVideojuegos);

        btnVideojuegosPtos = new JButton("Mostrar videojuegos por puntos");
        btnVideojuegosPtos.setForeground(Color.WHITE);
        btnVideojuegosPtos.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        btnVideojuegosPtos.setBackground(new Color(165, 42, 42));
        btnVideojuegosPtos.setActionCommand(AC_BOTON_MOSTRAR_VIDEOJUEGOS_POR_PUNTOS);
        btnVideojuegosPtos.addActionListener(this);
        btnVideojuegosPtos.setBounds(70, 424, 550, 50);
        panel.add(btnVideojuegosPtos);


        btnMostrarMusica = new JButton("Mostrar musica disponible");
        btnMostrarMusica.setForeground(Color.WHITE);
        btnMostrarMusica.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        btnMostrarMusica.setBackground(new Color(165, 42, 42));
        btnMostrarMusica.setActionCommand(AC_BOTON_MOSTRAR_MUSICA);
        btnMostrarMusica.addActionListener(this);
        btnMostrarMusica.setBounds(749, 497, 550, 50);
        panel.add(btnMostrarMusica);

        btnMusicaAnio = new JButton("Mostrar toda la musica disponible por anio");
        btnMusicaAnio.setForeground(Color.WHITE);
        btnMusicaAnio.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        btnMusicaAnio.setBackground(new Color(165, 42, 42));
        btnMusicaAnio.setActionCommand(AC_BOTON_MOSTRAR_MUSICA_POR_ANIO);
        btnMusicaAnio.addActionListener(this);
        btnMusicaAnio.setBounds(70, 497, 550, 50);
        panel.add(btnMusicaAnio);

        btnSalir = new JButton("volver");
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        btnSalir.setBackground(new Color(165, 42, 42));
        btnSalir.setActionCommand(AC_BOTON_VOLVER);
        btnSalir.addActionListener(this);
        btnSalir.setBounds(558, 599, 282, 50);
        panel.add(btnSalir);

        label = new JLabel("");
        label.setBounds(0, 0, 1375, 780);
        panel.add(label);
        label.setIcon(new ImageIcon(clsVenatanaMenuAlquiler.class.getResource("/com/company/COMUN/imagenMenuAlquiler.jpg")));

    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {

            case AC_BOTON_MOSTRAR_ARTICULOS:
                clsVenatanaVisualizarArticulos objVisualizarArticulos = new clsVenatanaVisualizarArticulos(objGestor, id, 1);
                objVisualizarArticulos.setVisible(true);
                objVisualizarArticulos.setExtendedState(6);
                this.dispose();
                break;
            case AC_BOTON_MOSTRAR_PELICULAS:
                clsVenatanaVisualizarArticulos objVisualizarArticulos1 = new clsVenatanaVisualizarArticulos(objGestor, id, 2);
                objVisualizarArticulos1.setVisible(true);
                objVisualizarArticulos1.setExtendedState(6);
                this.dispose();
                break;
            case AC_BOTON_MOSTRAR_PELICULAS_POR_PUNTOS:
                clsVenatanaVisualizarArticulos objVisualizarArticulos2 = new clsVenatanaVisualizarArticulos(objGestor, id, 3);
                objVisualizarArticulos2.setVisible(true);
                objVisualizarArticulos2.setExtendedState(6);
                this.dispose();
                break;
            case AC_BOTON_MOSTRAR_VIDEOJUEGOS:
                clsVenatanaVisualizarArticulos objVisualizarArticulos3 = new clsVenatanaVisualizarArticulos(objGestor, id, 4);
                objVisualizarArticulos3.setVisible(true);
                objVisualizarArticulos3.setExtendedState(6);
                this.dispose();
                break;
            case AC_BOTON_MOSTRAR_VIDEOJUEGOS_POR_PUNTOS:
                clsVenatanaVisualizarArticulos objVisualizarArticulos4 = new clsVenatanaVisualizarArticulos(objGestor, id, 5);
                objVisualizarArticulos4.setVisible(true);
                objVisualizarArticulos4.setExtendedState(6);
                this.dispose();
                break;
            case AC_BOTON_MOSTRAR_MUSICA:
                clsVenatanaVisualizarArticulos objVisualizarArticulos5 = new clsVenatanaVisualizarArticulos(objGestor, id, 6);
                objVisualizarArticulos5.setVisible(true);
                objVisualizarArticulos5.setExtendedState(6);
                this.dispose();
                break;
            case AC_BOTON_MOSTRAR_MUSICA_POR_ANIO:
                clsVenatanaVisualizarArticulos objVisualizarArticulos6 = new clsVenatanaVisualizarArticulos(objGestor, id, 7);
                objVisualizarArticulos6.setVisible(true);
                objVisualizarArticulos6.setExtendedState(6);
                this.dispose();
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
