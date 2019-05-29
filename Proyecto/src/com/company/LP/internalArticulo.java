package com.company.LP;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;

import javax.swing.*;

import com.company.COMUN.itfProperty;
import com.company.LN.clsGestor;

import static com.company.COMUN.clsConstantes.*;
import static com.company.COMUN.clsConstantes.PELICULA_PUNTUACION;

public class internalArticulo extends JInternalFrame implements ActionListener, WindowListener {

    private JPanel panelInternoP;
    private JLabel lblFechaSalida;
    private JLabel lblPrecio;
    private JLabel lblDuracion;
    private JLabel lPegi;
    private JLabel lblPuntuacion;
    private JLabel lblReservar;
    private JSpinner spinDias;
    private JLabel lblDias;
    private JButton btnAlquilar;

    private static final String AC_BOTON_ALQUILAR = "botonAlquilar";
    private int dias;

    /**
     * Create the frame.
     */
    public internalArticulo(itfProperty articulo, clsGestor _objGestor, int codigo) {



    	 /**
         panelInternoP = new JPanel();
         panelInternoP.setBounds(0, 0, 296, 116);
         getContentPane().add(panelInternoP);
         panelInternoP.setBackground(Color.RED);
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

         lblReservar = new JLabel("Marca si deseas alquilar: ");
         lblReservar.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
         lblReservar.setBounds(0, 57, 279, 12);
         panelInternoP.add(lblReservar);

         spinDias = new JSpinner();
         spinDias.setModel(new SpinnerListModel(new String[]{"1", "2", "3", "4", "5", "7", "10", "15"}));
         spinDias.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 16));
         spinDias.setBounds(221, 80, 58, 26);
         panelInternoP.add(spinDias);

         lblDias = new JLabel("Indique los dias");
         lblDias.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 10));
         lblDias.setBounds(124, 86, 272, 12);
         panelInternoP.add(lblDias);
         
         JButton btnAlquilar = new JButton("Alquilar");
         btnAlquilar.setBackground(new Color(238, 130, 238));
         btnAlquilar.setForeground(new Color(0, 0, 0));
         btnAlquilar.setFont(new Font("BankGothic Lt BT", Font.BOLD, 11));
         btnAlquilar.setBounds(10, 82, 104, 23);
         panelInternoP.add(btnAlquilar);


         //gln.anadirAlquilerM( articulo.getPropertyA(id), _fechaDev);

         */

        /**
         panelInternoP = new JPanel();
         panelInternoP.setBounds(0, 0, 296, 116);
         getContentPane().add(panelInternoP);
         panelInternoP.setBackground(Color.YELLOW);
         panelInternoP.setLayout(null);

         lblFechaSalida = new JLabel("Fecha de salida: " + articulo.getPropertyA(VIDEOJUEGO_FECHA_SALIDA));
         lblFechaSalida.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
         lblFechaSalida.setBounds(0, 0, 279, 12);
         panelInternoP.add(lblFechaSalida);

         lblPrecio = new JLabel("Precio por dia alquilado: " + articulo.getPropertyA(VIDEOJUEGO_PRECIO));
         lblPrecio.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
         lblPrecio.setBounds(0, 11, 279, 12);
         panelInternoP.add(lblPrecio);

         lblDuracion = new JLabel("Duracion de pelicula (horas.min): " + articulo.getPropertyA(VIDEOJUEGO_DURACION));
         lblDuracion.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
         lblDuracion.setBounds(0, 23, 279, 12);
         panelInternoP.add(lblDuracion);

         lPegi = new JLabel("Pegi del videojeugo:  " + articulo.getPropertyA(VIDEOJUEGO_PEGI));
         lPegi.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
         lPegi.setBounds(0, 34, 279, 12);
         panelInternoP.add(lPegi);

         lblPuntuacion = new JLabel("Puntuacion del videojuego:  " + articulo.getPropertyA(VIDEOJUEGO_PUNTUACION));
         lblPuntuacion.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
         lblPuntuacion.setBounds(0, 46, 279, 12);
         panelInternoP.add(lblPuntuacion);

         lblReservar = new JLabel("Marca si deseas alquilar: ");
         lblReservar.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
         lblReservar.setBounds(0, 57, 279, 12);
         panelInternoP.add(lblReservar);

         JButton btnAlquilar = new JButton("Alquilar");
         btnAlquilar.setBackground(new Color(238, 130, 238));
         btnAlquilar.setForeground(new Color(0, 0, 0));
         btnAlquilar.setFont(new Font("BankGothic Lt BT", Font.BOLD, 11));
         btnAlquilar.setBounds(10, 82, 104, 23);
         panelInternoP.add(btnAlquilar);

         spinDias = new JSpinner();
         spinDias.setModel(new SpinnerListModel(new String[]{"1", "2", "3", "4", "5", "7", "10", "15"}));
         spinDias.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 16));
         spinDias.setBounds(221, 80, 58, 26);
         panelInternoP.add(spinDias);

         lblDias = new JLabel("Indique los dias");
         lblDias.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 10));
         lblDias.setBounds(124, 86, 272, 12);
         panelInternoP.add(lblDias);
         */

        /**
         panelInternoP = new JPanel();
         panelInternoP.setBounds(0, 0, 296, 116);
         getContentPane().add(panelInternoP);
         panelInternoP.setBackground(Color.GREEN);
         panelInternoP.setLayout(null);

         lblFechaSalida = new JLabel("Fecha de salida: " + articulo.getPropertyA(MUSICA_FECHA_SALIDA));
         lblFechaSalida.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
         lblFechaSalida.setBounds(0, 0, 279, 12);
         panelInternoP.add(lblFechaSalida);

         lblPrecio = new JLabel("Precio por dia alquilado: " + articulo.getPropertyA(MUSICA_PRECIO));
         lblPrecio.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
         lblPrecio.setBounds(0, 11, 279, 12);
         panelInternoP.add(lblPrecio);

         lblDuracion = new JLabel("Duracion de pelicula (horas.min): " + articulo.getPropertyA(MUSICA_DURACION));
         lblDuracion.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
         lblDuracion.setBounds(0, 23, 279, 12);
         panelInternoP.add(lblDuracion);

         lPegi = new JLabel("Estudio de musica: " + articulo.getPropertyA(MUSICA_EXPLICITO));
         lPegi.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
         lPegi.setBounds(0, 34, 279, 12);
         panelInternoP.add(lPegi);

         lblPuntuacion = new JLabel("Artista de album:  " + articulo.getPropertyA(MUSICA_ARTISTA));
         lblPuntuacion.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
         lblPuntuacion.setBounds(0, 46, 279, 12);
         panelInternoP.add(lblPuntuacion);

         lblReservar = new JLabel("Indica si alquilar:");
         lblReservar.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
         lblReservar.setBounds(0, 57, 279, 12);
         panelInternoP.add(lblReservar);

        JButton btnAlquilar = new JButton("Alquilar");
         btnAlquilar.setBackground(new Color(238, 130, 238));
         btnAlquilar.setForeground(new Color(0, 0, 0));
         btnAlquilar.setFont(new Font("BankGothic Lt BT", Font.BOLD, 11));
         btnAlquilar.setBounds(10, 82, 104, 23);
         panelInternoP.add(btnAlquilar);

         spinDias = new JSpinner();
         spinDias.setModel(new SpinnerListModel(new String[]{"1", "2", "3", "4", "5", "7", "10", "15"}));
         spinDias.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 16));
         spinDias.setBounds(221, 80, 58, 26);
         panelInternoP.add(spinDias);

         lblDias = new JLabel("Indique los dias");
         lblDias.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 10));
         lblDias.setBounds(124, 86, 272, 12);
         panelInternoP.add(lblDias);

         */
        if (codigo == 1) {

            setTitle((String) articulo.getPropertyA(PELICULA_NOMBRE));
            panelInternoP = new JPanel();
            panelInternoP.setBounds(0, 0, 296, 116);
            getContentPane().add(panelInternoP);
            panelInternoP.setBackground(Color.RED);
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

            lblReservar = new JLabel("Marca si deseas alquilar: ");
            lblReservar.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblReservar.setBounds(0, 57, 279, 12);
            panelInternoP.add(lblReservar);

            btnAlquilar = new JButton("Alquilar");
            btnAlquilar.setBackground(new Color(238, 130, 238));
            btnAlquilar.setForeground(new Color(0, 0, 0));
            btnAlquilar.setFont(new Font("BankGothic Lt BT", Font.BOLD, 11));
            btnAlquilar.setBounds(10, 82, 104, 23);
            btnAlquilar.setActionCommand(AC_BOTON_ALQUILAR);
            btnAlquilar.addActionListener(this);
            panelInternoP.add(btnAlquilar);

            spinDias = new JSpinner();
            spinDias.setModel(new SpinnerListModel(new Integer[]{1, 2, 3, 4, 5, 7, 10, 15}));
            spinDias.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 16));
            spinDias.setBounds(221, 80, 58, 26);
            dias = (int) spinDias.getValue();
            System.out.println(dias);
            panelInternoP.add(spinDias);

            lblDias = new JLabel("Indique los dias");
            lblDias.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 10));
            lblDias.setBounds(124, 86, 272, 12);
            panelInternoP.add(lblDias);

        } else if (codigo == 2) {

            setTitle((String) articulo.getPropertyA(VIDEOJUEGO_NOMBRE));

            panelInternoP = new JPanel();
            panelInternoP.setBounds(0, 0, 296, 116);
            getContentPane().add(panelInternoP);
            panelInternoP.setBackground(Color.YELLOW);
            panelInternoP.setLayout(null);

            lblFechaSalida = new JLabel("Fecha de salida: " + articulo.getPropertyA(VIDEOJUEGO_FECHA_SALIDA));
            lblFechaSalida.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblFechaSalida.setBounds(0, 0, 279, 12);
            panelInternoP.add(lblFechaSalida);

            lblPrecio = new JLabel("Precio por dia alquilado: " + articulo.getPropertyA(VIDEOJUEGO_PRECIO));
            lblPrecio.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblPrecio.setBounds(0, 11, 279, 12);
            panelInternoP.add(lblPrecio);

            lblDuracion = new JLabel("Duracion de pelicula (horas.min): " + articulo.getPropertyA(VIDEOJUEGO_DURACION));
            lblDuracion.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblDuracion.setBounds(0, 23, 279, 12);
            panelInternoP.add(lblDuracion);

            lPegi = new JLabel("Pegi del videojeugo:  " + articulo.getPropertyA(VIDEOJUEGO_PEGI));
            lPegi.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lPegi.setBounds(0, 34, 279, 12);
            panelInternoP.add(lPegi);

            lblPuntuacion = new JLabel("Puntuacion del videojuego:  " + articulo.getPropertyA(VIDEOJUEGO_PUNTUACION));
            lblPuntuacion.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblPuntuacion.setBounds(0, 46, 279, 12);
            panelInternoP.add(lblPuntuacion);

            lblReservar = new JLabel("Marca si deseas alquilar: ");
            lblReservar.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblReservar.setBounds(0, 57, 279, 12);
            panelInternoP.add(lblReservar);

            btnAlquilar = new JButton("Alquilar");
            btnAlquilar.setBackground(new Color(238, 130, 238));
            btnAlquilar.setForeground(new Color(0, 0, 0));
            btnAlquilar.setFont(new Font("BankGothic Lt BT", Font.BOLD, 11));
            btnAlquilar.setBounds(10, 82, 104, 23);
            btnAlquilar.setActionCommand(AC_BOTON_ALQUILAR);
            btnAlquilar.addActionListener(this);
            panelInternoP.add(btnAlquilar);

            spinDias = new JSpinner();
            spinDias.setModel(new SpinnerListModel(new String[]{"1", "2", "3", "4", "5", "7", "10", "15"}));
            spinDias.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 16));
            spinDias.setBounds(221, 80, 58, 26);
            panelInternoP.add(spinDias);

            lblDias = new JLabel("Indique los dias");
            lblDias.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 10));
            lblDias.setBounds(124, 86, 272, 12);
            panelInternoP.add(lblDias);

        } else if (codigo == 3) {

            setTitle((String) articulo.getPropertyA(MUSICA_NOMBRE));

            panelInternoP = new JPanel();
            panelInternoP.setBounds(0, 0, 296, 116);
            getContentPane().add(panelInternoP);
            panelInternoP.setBackground(Color.GREEN);
            panelInternoP.setLayout(null);

            lblFechaSalida = new JLabel("Fecha de salida: " + articulo.getPropertyA(MUSICA_FECHA_SALIDA));
            lblFechaSalida.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblFechaSalida.setBounds(0, 0, 279, 12);
            panelInternoP.add(lblFechaSalida);

            lblPrecio = new JLabel("Precio por dia alquilado: " + articulo.getPropertyA(MUSICA_PRECIO));
            lblPrecio.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblPrecio.setBounds(0, 11, 279, 12);
            panelInternoP.add(lblPrecio);

            lblDuracion = new JLabel("Duracion de pelicula (horas.min): " + articulo.getPropertyA(MUSICA_DURACION));
            lblDuracion.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblDuracion.setBounds(0, 23, 279, 12);
            panelInternoP.add(lblDuracion);

            lPegi = new JLabel("Estudio de musica: " + articulo.getPropertyA(MUSICA_EXPLICITO));
            lPegi.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lPegi.setBounds(0, 34, 279, 12);
            panelInternoP.add(lPegi);

            lblPuntuacion = new JLabel("Artista de album:  " + articulo.getPropertyA(MUSICA_ARTISTA));
            lblPuntuacion.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblPuntuacion.setBounds(0, 46, 279, 12);
            panelInternoP.add(lblPuntuacion);

            lblReservar = new JLabel("Indica si alquilar:");
            lblReservar.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblReservar.setBounds(0, 57, 279, 12);
            panelInternoP.add(lblReservar);

            btnAlquilar = new JButton("Alquilar");
            btnAlquilar.setBackground(new Color(238, 130, 238));
            btnAlquilar.setForeground(new Color(0, 0, 0));
            btnAlquilar.setFont(new Font("BankGothic Lt BT", Font.BOLD, 11));
            btnAlquilar.setBounds(10, 82, 104, 23);
            btnAlquilar.setActionCommand(AC_BOTON_ALQUILAR);
            btnAlquilar.addActionListener(this);
            panelInternoP.add(btnAlquilar);

            spinDias = new JSpinner();
            spinDias.setModel(new SpinnerListModel(new String[]{"1", "2", "3", "4", "5", "7", "10", "15"}));
            spinDias.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 16));
            spinDias.setBounds(221, 80, 58, 26);
            panelInternoP.add(spinDias);

            lblDias = new JLabel("Indique los dias");
            lblDias.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 10));
            lblDias.setBounds(124, 86, 272, 12);
            panelInternoP.add(lblDias);

        }
        setBounds(100, 100, 308, 143);
        getContentPane().setLayout(null);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()){
            case AC_BOTON_ALQUILAR:

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
