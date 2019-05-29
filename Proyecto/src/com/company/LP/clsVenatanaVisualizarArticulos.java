package com.company.LP;

import com.company.COMUN.itfProperty;
import com.company.LN.clsGestor;

import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import static com.company.COMUN.clsConstantes.*;


public class clsVenatanaVisualizarArticulos extends JFrame implements ItemListener, MouseListener, InternalFrameListener, ActionListener, WindowListener {

    private clsGestor objGestor;
    private String id;
    private JPanel panel;


    private ArrayList<JInternalFrame> listaInternalFrames = new ArrayList<>();
    private JInternalFrame internalFrame;
    private JPanel panelInternoP;
    private JLabel lblFechaSalida;
    private JLabel lblPrecio;
    private JLabel lblDuracion;
    private JLabel lPegi;
    private JLabel lblPuntuacion;
    private JLabel lblReservar;
    private JCheckBox chckbxAlquilar;
    private JSpinner spinDias;
    private JLabel lblDias;


    public clsVenatanaVisualizarArticulos(clsGestor _objGestor, String _id, int codigo) {

        objGestor = _objGestor;
        id = _id;

        this.setSize(1920, 1080);
        getContentPane().setLayout(null);

        panel = new JPanel();
        panel.setBounds(0, 0, 1364, 749);
        getContentPane().add(panel);
        panel.setLayout(null);


        switch (codigo) {
            case 1:
                ventanaPeliculas();
                ventanaVideojuegos();
                ventanaMusica();
                break;
            case 2:
                ventanaPeliculas();
                break;
            case 3:
                ventanaVideojuegos();
                break;
            case 4:
                ventanaMusica();
                break;
        }
    }

    private void ventanaPeliculas() {

        ArrayList<itfProperty> peliculas = objGestor.leerPeliculas();
        for (itfProperty pelicula : peliculas) {

            /**
            internalFrame = new JInternalFrame((String) pelicula.getPropertyA(PELICULA_NOMBRE));
            listaInternalFrames.add(internalFrame);
            internalFrame.setClosable(true);
            internalFrame.setBounds(66, 189, 305, 143);
            panel.add(internalFrame);
            internalFrame.getContentPane().setLayout(null);

            panelInternoP = new JPanel();
            panelInternoP.setBackground(Color.YELLOW);
            panelInternoP.setBounds(0, 0, 289, 113);
            internalFrame.getContentPane().add(panelInternoP);
            panelInternoP.setLayout(null);

            lblFechaSalida = new JLabel("Fecha de salida: " + pelicula.getPropertyA(PELICULA_FECHA_SALIDA));
            lblFechaSalida.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblFechaSalida.setBounds(0, 0, 279, 12);
            panelInternoP.add(lblFechaSalida);

            lblPrecio = new JLabel("Precio por dia alquilado: " + pelicula.getPropertyA(PELICULA_PRECIO));
            lblPrecio.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblPrecio.setBounds(0, 11, 279, 12);
            panelInternoP.add(lblPrecio);

            lblDuracion = new JLabel("Duracion de pelicula (horas.min): " + pelicula.getPropertyA(PELICULA_DURACION));
            lblDuracion.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblDuracion.setBounds(0, 23, 279, 12);
            panelInternoP.add(lblDuracion);

            lPegi = new JLabel("Pegi de la pelicula: " + pelicula.getPropertyA(PELICULA_PEGI));
            lPegi.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lPegi.setBounds(0, 34, 279, 12);
            panelInternoP.add(lPegi);

            lblPuntuacion = new JLabel("Puntuacion de la pelicula: " + pelicula.getPropertyA(PELICULA_PUNTUACION));
            lblPuntuacion.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblPuntuacion.setBounds(0, 46, 279, 12);
            panelInternoP.add(lblPuntuacion);

            lblReservar = new JLabel("Marca si deseas alquilar: ");
            lblReservar.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblReservar.setBounds(0, 57, 279, 12);
            panelInternoP.add(lblReservar);

            chckbxAlquilar = new JCheckBox("Alquilar");
            chckbxAlquilar.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 11));
            chckbxAlquilar.setBackground(Color.LIGHT_GRAY);
            chckbxAlquilar.setBounds(21, 83, 97, 23);
            chckbxAlquilar.addItemListener(this);
            panelInternoP.add(chckbxAlquilar);

            if (chckbxAlquilar.isSelected() == true) {
                System.out.println("hola");
            }

            spinDias = new JSpinner();
            spinDias.setModel(new SpinnerListModel(new String[]{"1", "2", "3", "4", "5", "7", "10", "15"}));
            spinDias.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 16));
            spinDias.setBounds(221, 80, 58, 26);
            panelInternoP.add(spinDias);

            lblDias = new JLabel("Indique los dias");
            lblDias.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 10));
            lblDias.setBounds(124, 86, 272, 12);
            panelInternoP.add(lblDias);
            internalFrame.setVisible(true);
             */

            internalArticulo internalP = new internalArticulo(pelicula, objGestor, 1);
            listaInternalFrames.add(internalP);
            panel.add(internalP);
            internalP.setVisible(true);

        }
    }

    private void ventanaVideojuegos() {

        ArrayList<itfProperty> videojuegos = objGestor.leerVideojuegos();
        for (itfProperty videojuego : videojuegos) {
            /**
            internalFrame = new JInternalFrame((String) videojuego.getPropertyA(VIDEOJUEGO_NOMBRE));
            listaInternalFrames.add(internalFrame);
            internalFrame.setClosable(true);
            internalFrame.setBounds(437, 89, 305, 143);
            panel.add(internalFrame);
            internalFrame.getContentPane().setLayout(null);

            panelInternoP = new JPanel();
            panelInternoP.setBackground(Color.RED);
            panelInternoP.setBounds(0, 0, 289, 113);
            internalFrame.getContentPane().add(panelInternoP);
            panelInternoP.setLayout(null);

            lblFechaSalida = new JLabel("Fecha de salida: " + videojuego.getPropertyA(VIDEOJUEGO_FECHA_SALIDA));
            lblFechaSalida.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblFechaSalida.setBounds(0, 0, 279, 12);
            panelInternoP.add(lblFechaSalida);

            lblPrecio = new JLabel("Precio por dia alquilado: " + videojuego.getPropertyA(VIDEOJUEGO_PRECIO));
            lblPrecio.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblPrecio.setBounds(0, 11, 279, 12);
            panelInternoP.add(lblPrecio);

            lblDuracion = new JLabel("Duracion de pelicula (horas.min): " + videojuego.getPropertyA(VIDEOJUEGO_DURACION));
            lblDuracion.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblDuracion.setBounds(0, 23, 279, 12);
            panelInternoP.add(lblDuracion);

            lPegi = new JLabel("Pegi del videojeugo:  " + videojuego.getPropertyA(VIDEOJUEGO_PEGI));
            lPegi.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lPegi.setBounds(0, 34, 279, 12);
            panelInternoP.add(lPegi);

            lblPuntuacion = new JLabel("Puntuacion del videojuego:  " + videojuego.getPropertyA(VIDEOJUEGO_PUNTUACION));
            lblPuntuacion.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblPuntuacion.setBounds(0, 46, 279, 12);
            panelInternoP.add(lblPuntuacion);

            lblReservar = new JLabel("Marca si deseas alquilar: ");
            lblReservar.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblReservar.setBounds(0, 57, 279, 12);
            panelInternoP.add(lblReservar);

            chckbxAlquilar = new JCheckBox("Alquilar");
            chckbxAlquilar.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 11));
            chckbxAlquilar.setBackground(Color.LIGHT_GRAY);
            chckbxAlquilar.setBounds(21, 83, 97, 23);
            panelInternoP.add(chckbxAlquilar);

            spinDias = new JSpinner();
            spinDias.setModel(new SpinnerListModel(new String[]{"1", "2", "3", "4", "5", "7", "10", "15"}));
            spinDias.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 16));
            spinDias.setBounds(221, 80, 58, 26);
            panelInternoP.add(spinDias);

            lblDias = new JLabel("Indique los dias");
            lblDias.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 10));
            lblDias.setBounds(124, 86, 272, 12);
            panelInternoP.add(lblDias);
            internalFrame.setVisible(true);
            */

            internalArticulo internal = new internalArticulo(videojuego, objGestor, 2);
            listaInternalFrames.add(internal);
            panel.add(internal);
            internal.setVisible(true);

        }

    }

    private void ventanaMusica() {

        ArrayList<itfProperty> musicas = objGestor.leerMusica();
        for (itfProperty musica : musicas) {
            /**
            internalFrame = new JInternalFrame((String) musica.getPropertyA(MUSICA_NOMBRE));
            listaInternalFrames.add(internalFrame);
            internalFrame.setClosable(true);
            internalFrame.setBounds(766, 89, 305, 143);
            panel.add(internalFrame);
            internalFrame.getContentPane().setLayout(null);

            panelInternoP = new JPanel();
            panelInternoP.setBackground(Color.GREEN);
            panelInternoP.setBounds(0, 0, 289, 113);
            internalFrame.getContentPane().add(panelInternoP);
            panelInternoP.setLayout(null);

            lblFechaSalida = new JLabel("Fecha de salida: " + musica.getPropertyA(MUSICA_FECHA_SALIDA));
            lblFechaSalida.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblFechaSalida.setBounds(0, 0, 279, 12);
            panelInternoP.add(lblFechaSalida);

            lblPrecio = new JLabel("Precio por dia alquilado: " + musica.getPropertyA(MUSICA_PRECIO));
            lblPrecio.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblPrecio.setBounds(0, 11, 279, 12);
            panelInternoP.add(lblPrecio);

            lblDuracion = new JLabel("Duracion de pelicula (horas.min): " + musica.getPropertyA(MUSICA_DURACION));
            lblDuracion.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblDuracion.setBounds(0, 23, 279, 12);
            panelInternoP.add(lblDuracion);

            lPegi = new JLabel("Estudio de musica: " + musica.getPropertyA(MUSICA_EXPLICITO));
            lPegi.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lPegi.setBounds(0, 34, 279, 12);
            panelInternoP.add(lPegi);

            lblPuntuacion = new JLabel("Artista de album:  " + musica.getPropertyA(MUSICA_ARTISTA));
            lblPuntuacion.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblPuntuacion.setBounds(0, 46, 279, 12);
            panelInternoP.add(lblPuntuacion);

            lblReservar = new JLabel("Indica si alquilar:");
            lblReservar.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 12));
            lblReservar.setBounds(0, 57, 279, 12);
            panelInternoP.add(lblReservar);

            chckbxAlquilar = new JCheckBox("Alquilar");
            chckbxAlquilar.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 11));
            chckbxAlquilar.setBackground(Color.LIGHT_GRAY);
            chckbxAlquilar.setBounds(21, 83, 97, 23);
            panelInternoP.add(chckbxAlquilar);

            spinDias = new JSpinner();
            spinDias.setModel(new SpinnerListModel(new String[]{"1", "2", "3", "4", "5", "7", "10", "15"}));
            spinDias.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 16));
            spinDias.setBounds(221, 80, 58, 26);
            panelInternoP.add(spinDias);

            lblDias = new JLabel("Indique los dias");
            lblDias.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 10));
            lblDias.setBounds(124, 86, 272, 12);
            panelInternoP.add(lblDias);
            internalFrame.setVisible(true);
            */
            internalArticulo internalM = new internalArticulo(musica, objGestor, 3);
            listaInternalFrames.add(internalM);
            panel.add(internalM);
            internalM.setVisible(true);


        }

    }


    public void actionPerformed(ActionEvent e) {

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

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
        // TODO Auto-generated method stub

    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {

        switch (e.getButton()) {

        }
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * Invoked when an item has been selected or deselected by the user.
     * The code written for this method performs the operations
     * that need to occur when an item is selected (or deselected).
     *
     * @param e the event to be processed
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        if (chckbxAlquilar.isSelected()) {
            System.out.println("Hola");
        }
    }
}
