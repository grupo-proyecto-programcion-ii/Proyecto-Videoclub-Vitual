package com.company.LP;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;

import com.company.COMUN.itfProperty;
import com.company.LN.clsGestor;

import static com.company.COMUN.clsConstantes.*;
import static com.company.COMUN.clsConstantes.PELICULA_PUNTUACION;

/**
 * Clase que crea las ventanas de articulos sobre la ventana principal de
 * "clsVentanaVisualizarArticulos
 */

public class internalAlquiler  extends JInternalFrame implements WindowListener {


    private clsGestor objGestor;
    private String identificador;
    private int id;

    private int dimensionHorizontal = 307;
    private int dimensionVertical = 143;
    private int puntoInicioX = 10;
    private  int puntoInicioY = 11;

    private JPanel panelInternoP;
    private JPanel panelInternoV;
    private JPanel panelInternoM;
    private JLabel lblFechaSalida;
    private JLabel lblPrecio;
    private JLabel lblDuracion;
    private JLabel lPegi;
    private JLabel lblPuntuacion;
    private JLabel lblReservar;
    private JLabel lblDias;



    public internalAlquiler(itfProperty articulo, clsGestor _objGestor, int codigo, String _identificador, int recuentoHorizontal, int recuentoVertical){

        objGestor = _objGestor;
        identificador = _identificador;

        if (codigo == 1) {

            setTitle((String) articulo.getPropertyA(PELICULA_NOMBRE));
            panelInternoP = new JPanel();
            panelInternoP.setBounds(0, 0, 296, 116);
            getContentPane().add(panelInternoP);
            panelInternoP.setBackground(new Color(255, 51, 0));
            panelInternoP.setLayout(null);

            lblFechaSalida = new JLabel("Fecha de salida: " + articulo.getPropertyA(PELICULA_FECHA_SALIDA));
            lblFechaSalida.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblFechaSalida.setBounds(0, 0, 279, 12);
            panelInternoP.add(lblFechaSalida);

            lblPrecio = new JLabel("Precio por dia alquilado: " + articulo.getPropertyA(PELICULA_PRECIO));
            lblPrecio.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblPrecio.setBounds(0, 11, 279, 12);
            panelInternoP.add(lblPrecio);

            lblDuracion = new JLabel("Duracion de pelicula (horas.min): " + articulo.getPropertyA(PELICULA_DURACION));
            lblDuracion.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblDuracion.setBounds(0, 23, 279, 12);
            panelInternoP.add(lblDuracion);

            lPegi = new JLabel("Pegi de la pelicula: " + articulo.getPropertyA(PELICULA_PEGI));
            lPegi.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lPegi.setBounds(0, 34, 279, 12);
            panelInternoP.add(lPegi);

            lblPuntuacion = new JLabel("Puntuacion de la pelicula: " + articulo.getPropertyA(PELICULA_PUNTUACION));
            lblPuntuacion.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblPuntuacion.setBounds(0, 46, 279, 12);
            panelInternoP.add(lblPuntuacion);


            setBounds(puntoInicioX + (recuentoVertical * dimensionHorizontal), puntoInicioY + (recuentoHorizontal * dimensionVertical),
                    dimensionHorizontal, dimensionVertical);
            getContentPane().setLayout(null);


        } else if (codigo == 2) {

            setTitle((String) articulo.getPropertyA(VIDEOJUEGO_NOMBRE));

            panelInternoV = new JPanel();
            panelInternoV.setBounds(0, 0, 296, 116);
            getContentPane().add(panelInternoV);
            panelInternoV.setBackground(Color.YELLOW);
            panelInternoV.setLayout(null);

            lblFechaSalida = new JLabel("Fecha de salida: " + articulo.getPropertyA(VIDEOJUEGO_FECHA_SALIDA));
            lblFechaSalida.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblFechaSalida.setBounds(0, 0, 279, 12);
            panelInternoV.add(lblFechaSalida);

            lblPrecio = new JLabel("Precio por dia alquilado: " + articulo.getPropertyA(VIDEOJUEGO_PRECIO));
            lblPrecio.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblPrecio.setBounds(0, 11, 279, 12);
            panelInternoV.add(lblPrecio);

            lblDuracion = new JLabel("Duracion del videojuego (horas.min): " + articulo.getPropertyA(VIDEOJUEGO_DURACION));
            lblDuracion.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblDuracion.setBounds(0, 23, 279, 12);
            panelInternoV.add(lblDuracion);

            lPegi = new JLabel("Pegi del videojeugo:  " + articulo.getPropertyA(VIDEOJUEGO_PEGI));
            lPegi.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lPegi.setBounds(0, 34, 279, 12);
            panelInternoV.add(lPegi);

            lblPuntuacion = new JLabel("Puntuacion del videojuego:  " + articulo.getPropertyA(VIDEOJUEGO_PUNTUACION));
            lblPuntuacion.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblPuntuacion.setBounds(0, 46, 279, 12);
            panelInternoV.add(lblPuntuacion);


            setBounds(puntoInicioX + (recuentoVertical * dimensionHorizontal), puntoInicioY + (recuentoHorizontal * dimensionVertical),
                    dimensionHorizontal, dimensionVertical);
            getContentPane().setLayout(null);

        } else if (codigo == 3) {

            setTitle((String) articulo.getPropertyA(MUSICA_NOMBRE));

            panelInternoM = new JPanel();
            panelInternoM.setBounds(0, 0, 296, 116);
            getContentPane().add(panelInternoM);
            panelInternoM.setBackground(Color.GREEN);
            panelInternoM.setLayout(null);

            lblFechaSalida = new JLabel("Fecha de salida: " + articulo.getPropertyA(MUSICA_FECHA_SALIDA));
            lblFechaSalida.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblFechaSalida.setBounds(0, 0, 279, 12);
            panelInternoM.add(lblFechaSalida);

            lblPrecio = new JLabel("Precio por dia alquilado: " + articulo.getPropertyA(MUSICA_PRECIO));
            lblPrecio.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblPrecio.setBounds(0, 11, 279, 12);
            panelInternoM.add(lblPrecio);

            lblDuracion = new JLabel("Duracion de pelicula (horas.min): " + articulo.getPropertyA(MUSICA_DURACION));
            lblDuracion.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblDuracion.setBounds(0, 23, 279, 12);
            panelInternoM.add(lblDuracion);

            lPegi = new JLabel("Estudio de musica: " + articulo.getPropertyA(MUSICA_EXPLICITO));
            lPegi.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lPegi.setBounds(0, 34, 279, 12);
            panelInternoM.add(lPegi);

            lblPuntuacion = new JLabel("Artista de album:  " + articulo.getPropertyA(MUSICA_ARTISTA));
            lblPuntuacion.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblPuntuacion.setBounds(0, 46, 279, 12);
            panelInternoM.add(lblPuntuacion);

            setBounds(puntoInicioX + (recuentoVertical * dimensionHorizontal),
                    puntoInicioY + (recuentoHorizontal * dimensionVertical),
                    dimensionHorizontal, dimensionVertical);
            getContentPane().setLayout(null);

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
