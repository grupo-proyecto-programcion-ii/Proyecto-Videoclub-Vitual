package com.company.LP;

import com.company.COMUN.itfProperty;
import com.company.LN.clsGestor;

import javax.swing.*;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import static com.company.COMUN.clsConstantes.USUARIO_COSTE_TOTAL;
import static com.company.COMUN.clsConstantes.USUARIO_IDENTIFICADOR;

public class clsVenatanaVisualizarArticulos extends JFrame implements ItemListener, MouseListener, InternalFrameListener, ActionListener, WindowListener {

    private clsGestor objGestor;
    private String id;
    private int recuentoH;
    private int recuentoV;
    private double costeTotal;

    private JPanel panel;
    private ArrayList<JInternalFrame> listaInternalFrames = new ArrayList<>();
    private JButton btnVolver;
    private JLabel label;
    private JLabel lblCosteTotalActual;

    private static final String AC_BOTON_VOLVER = "botonVolver";


    public clsVenatanaVisualizarArticulos(clsGestor _objGestor, String _id, int codigo) {

        objGestor = _objGestor;
        id = _id;
        leerDatos(_id);

        this.setSize(1920, 1080);
        getContentPane().setLayout(null);

        panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBounds(0, 0, 1364, 749);
        getContentPane().add(panel);
        panel.setLayout(null);

        btnVolver = new JButton("volver");
        btnVolver.setForeground(Color.WHITE);
        btnVolver.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        btnVolver.setBackground(new Color(165, 42, 42));
        btnVolver.setActionCommand(AC_BOTON_VOLVER);
        btnVolver.addActionListener(this);
        btnVolver.setBounds(10, 653, 282, 50);
        panel.add(btnVolver);
        
        lblCosteTotalActual = new JLabel("Coste total actual: "+ costeTotal+"$");
        lblCosteTotalActual.setForeground(Color.WHITE);
        lblCosteTotalActual.setBackground(Color.WHITE);
        lblCosteTotalActual.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 22));
        lblCosteTotalActual.setBounds(302, 651, 546, 52);
        panel.add(lblCosteTotalActual);

        label = new JLabel("");
        label.setIcon(new ImageIcon(clsVenatanaVisualizarArticulos.class.getResource("/com/company/COMUN/imagenFondoAlquilar.jpg")));
        label.setBounds(0, 642, 1419, 107);
        panel.add(label);


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
                ventanaPeliculasPtos();
                break;
            case 4:
                ventanaVideojuegos();
                break;
            case 5:
                ventanaVideojuegosPtos();
                break;
            case 6:
                ventanaMusica();
                break;
            case 7:
                ventanaMusicaAnio();
                break;
        }
    }

    private void ventanaPeliculas() {

        ArrayList<itfProperty> peliculas = objGestor.leerPeliculas();
        for (itfProperty pelicula : peliculas) {

            internalArticulo internalP = new internalArticulo(pelicula, objGestor, 1, id, recuentoH, recuentoV);
            listaInternalFrames.add(internalP);
            panel.add(internalP);
            internalP.setVisible(true);
            recuentoH++;
            if (recuentoH == 4 || recuentoH == 8 || recuentoH == 12){
                recuentoV++;
                recuentoH = 0;
            }
        }
    }

    private void ventanaPeliculasPtos() {

        ArrayList<itfProperty> _peliculas = objGestor.listaPeliculasPuntos();
        for (itfProperty pelicula : _peliculas) {

            internalArticulo internalP = new internalArticulo(pelicula, objGestor, 1, id, recuentoH, recuentoV);
            listaInternalFrames.add(internalP);
            panel.add(internalP);
            internalP.setVisible(true);
            recuentoH++;
            if (recuentoH == 4 || recuentoH == 8 || recuentoH == 12){
                recuentoV++;
                recuentoH = 0;
            }
        }
    }

    private void ventanaVideojuegos() {

        ArrayList<itfProperty> videojuegos = objGestor.leerVideojuegos();
        for (itfProperty videojuego : videojuegos) {

            internalArticulo internal = new internalArticulo(videojuego, objGestor, 2, id, recuentoH, recuentoV);
            listaInternalFrames.add(internal);
            panel.add(internal);
            internal.setVisible(true);
            recuentoH++;
            if (recuentoH == 4 || recuentoH == 8 || recuentoH == 12){
                recuentoV++;
                recuentoH = 0;
            }
        }
    }

    private void ventanaVideojuegosPtos() {

        ArrayList<itfProperty> _videojuegos = objGestor.listaVideojuegosPuntos();
        for (itfProperty videojuego : _videojuegos) {

            internalArticulo internal = new internalArticulo(videojuego, objGestor, 2, id, recuentoH, recuentoV);
            listaInternalFrames.add(internal);
            panel.add(internal);
            internal.setVisible(true);
            recuentoH++;
            if (recuentoH == 4 || recuentoH == 8 || recuentoH == 12){
                recuentoV++;
                recuentoH = 0;
            }
        }
    }

    private void ventanaMusica() {

        ArrayList<itfProperty> musicas = objGestor.leerMusica();
        for (itfProperty musica : musicas) {

            internalArticulo internalM = new internalArticulo(musica, objGestor, 3, id, recuentoH, recuentoV);
            listaInternalFrames.add(internalM);
            panel.add(internalM);
            internalM.setVisible(true);
            recuentoH++;
            if (recuentoH == 4 || recuentoH == 8 || recuentoH == 12){
                recuentoV++;
                recuentoH = 0;
            }
        }
    }

    private void ventanaMusicaAnio() {

        ArrayList<itfProperty> _musicas = objGestor.listaMusicaAnio();
        for (itfProperty musica : _musicas) {

            internalArticulo internalM = new internalArticulo(musica, objGestor, 3, id, recuentoH, recuentoV);
            listaInternalFrames.add(internalM);
            panel.add(internalM);
            internalM.setVisible(true);
            recuentoH++;
            if (recuentoH == 4 || recuentoH == 8 || recuentoH == 12){
                recuentoV++;
                recuentoH = 0;
            }
        }
    }

    private void leerDatos(String id){
        ArrayList<itfProperty> lUsuarios = objGestor.leerUsuarios();
        for (itfProperty usuario : lUsuarios) {
            if (usuario.getPropertyU(USUARIO_IDENTIFICADOR).equals(id)) {
                costeTotal = (Double) usuario.getPropertyU(USUARIO_COSTE_TOTAL);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case AC_BOTON_VOLVER:
                clsVenatanaMenuAlquiler objVentanaMenuAlquiler = new clsVenatanaMenuAlquiler(objGestor, id);
                objVentanaMenuAlquiler.setVisible(true);
                objVentanaMenuAlquiler.setExtendedState(6);
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

    }
}
