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
import java.util.Map;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.AbstractTableModel;

import static com.company.COMUN.clsConstantes.*;

/**
 * Clase para visualizar los articulos alquilados anteriormente o todos los articulos
 * dependiendo de si esta dado de alta de la suscripcion
 */
public class clsVentanaMenuVisualizar extends JFrame implements ActionListener, WindowListener {


    private clsGestor objGestor;
    private String id;
    private JPanel panelDeContenido;
    private JLabel lblImagenFondo;
    private JButton btnVolver;

    private static final String AC_BOTON_MOSTRAR_ALQUILER_ARTICULOS = "botonMostrarArticulos";
    private static final String AC_BOTON_MOSTRAR_ALQUILER_PELICULAS = "botonMostrarPeliculas";
    private static final String AC_BOTON_MOSTRAR_ALQUILER_VIDEOJUEGOS = "botonMostrarVideojuegos";
    private static final String AC_BOTON_MOSTRAR_ALQUILER_MUSICA = "botonMostrarMusica";
    private static final String AC_BOTON_VOLVER = "botonVolver";
    private JScrollBar scrollBar;
    private JLabel lblAlquilerPeliculas;
    private JLabel label;
    private JLabel lblAlquilerPelicula;

    /**
     * Constructor de la clase
     * @param _objGestor objeto que apunta al gestor
     * @param _id identificador del usuario
     */
    public clsVentanaMenuVisualizar(clsGestor _objGestor, String _id) {

        objGestor = _objGestor;
        id = _id;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 1080);
        getContentPane().setLayout(null);
        addWindowListener(this);

        panelDeContenido = new JPanel();
        panelDeContenido.setBackground(new Color(255, 255, 255));
        panelDeContenido.setForeground(Color.BLACK);
        panelDeContenido.setBounds(0, 0, 1364, 749);
        getContentPane().add(panelDeContenido);
        panelDeContenido.setLayout(null);


        
        JPanel panelPeliculas = new JPanel();
        panelPeliculas.setBackground(Color.WHITE);
        panelPeliculas.setForeground(Color.BLACK);
        panelPeliculas.setBounds(499, 276, -440, -255);
        panelDeContenido.add(panelPeliculas);
        panelPeliculas.setLayout(null);
        
        scrollBar = new JScrollBar();
        scrollBar.setUnitIncrement(10);
        scrollBar.setMaximum(500);
        scrollBar.setBounds(664, 0, 17, 192);
        panelPeliculas.add(scrollBar);
        
        lblAlquilerPeliculas = new JLabel("Alquiler Peliculas");
        lblAlquilerPeliculas.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 23));
        lblAlquilerPeliculas.setBounds(10, 11, 352, 25);
        panelPeliculas.add(lblAlquilerPeliculas);
        
        label = new JLabel("");
        label.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 13));
        label.setBounds(10, 47, 46, 14);
        panelPeliculas.add(label);
        

        lblAlquilerPelicula = new JLabel("Codigo alquiler: " );
        lblAlquilerPelicula.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 15));
        lblAlquilerPelicula.setBounds(10, 47 , 299, 14);
        panelPeliculas.add(lblAlquilerPelicula);
       


        ArrayList<itfProperty> alquilerPeliculas = objGestor.leerAlquilerP();
        int distancia = 0;
        for (itfProperty alquilerPelicula:alquilerPeliculas){

            lblAlquilerPelicula = new JLabel("Codigo alquiler: " + alquilerPelicula.getPropertyA(ALQUILER_PELICULA_ID) +
                    "pelicula id: " + alquilerPelicula.getPropertyA(ALQUILER_PELICULA_ID_PROPIA + "fecha devolucion :" +
                    alquilerPelicula.getPropertyA(ALQUILER_PELICULA_FECHADEV)));
            lblAlquilerPelicula.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 15));
            lblAlquilerPelicula.setBounds(10, 47 + distancia, 299, 14);
            panelPeliculas.add(lblAlquilerPelicula);
            distancia = distancia + 14;

        }


        btnVolver = new JButton("Volver a la pantalla de menu");
        btnVolver.setBounds(931, 44, 359, 31);
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        btnVolver.setBackground(Color.CYAN);
        btnVolver.setActionCommand("botonVolver");
        panelDeContenido.add(btnVolver);
        
                lblImagenFondo = new JLabel("");
                lblImagenFondo.setBounds(-163, -101, 1920, 1080);
                lblImagenFondo.setIcon(new ImageIcon(clsVentanaMenuVisualizar.class.getResource("/com/company/COMUN/AlquilerMusica.jpg")));
                panelDeContenido.add(lblImagenFondo);

    }

    public void leerDatos(String id){

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


