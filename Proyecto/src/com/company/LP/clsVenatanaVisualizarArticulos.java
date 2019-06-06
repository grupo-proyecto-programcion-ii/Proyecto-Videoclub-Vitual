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

/**
 * Clase para la ventana de visualizacionde los articulos. Dentro de ella de encuentras las
 * ventanas menores que contienen los datos de los articulos
 */
public class clsVenatanaVisualizarArticulos extends JFrame implements ItemListener, MouseListener, InternalFrameListener, ActionListener, WindowListener {

    private clsGestor objGestor;
    private String id;
    private int recuentoH;
    private int recuentoV;
    private double costeTotal;
    private int codigo_aleatorio = 0;

    private JPanel panel;
    private ArrayList<JInternalFrame> listaInternalFrames = new ArrayList<>();
    private JButton btnVolver;
    private JLabel label;
    private JLabel lblCosteTotalActual;

    private static final String AC_BOTON_VOLVER = "botonVolver";

    /**
     * Constructor de la clase
     *
     * @param _objGestor objeto para los metodos de gestor
     * @param _id        identidicador del usuario logeado
     * @param codigo     codigo que se le transmite desde la ventana anterior para ejecitar
     *                   las ventanas interiores seleccionadas
     */
    public clsVenatanaVisualizarArticulos(clsGestor _objGestor, String _id, int codigo) {

        objGestor = _objGestor;
        id = _id;
        leerDatos(_id);

        this.setSize(1920, 1080);
        getContentPane().setLayout(null);
        addWindowListener(this);

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

        lblCosteTotalActual = new JLabel("Coste total actual: " + costeTotal + "$");
        lblCosteTotalActual.setForeground(Color.WHITE);
        lblCosteTotalActual.setBackground(Color.WHITE);
        lblCosteTotalActual.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 22));
        lblCosteTotalActual.setBounds(302, 651, 546, 52);
        panel.add(lblCosteTotalActual);

        label = new JLabel("");
        label.setIcon(new ImageIcon(clsVenatanaVisualizarArticulos.class.getResource("/com/company/COMUN/imagenFondoAlquilar.jpg")));
        label.setBounds(0, 642, 1419, 107);
        panel.add(label);


        try {
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
                case 8:
                    ventanaAlquilerP();
                    ventanaAlquilerV();
                    ventanaAlquilerM();
                    break;
                case 9:
                    ventanaAlquilerP_alquiler();
                    ventanaAlquilerV_alquiler();
                    ventanaAlquilerM_alquiler();
                    break;
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "error al insertar ventanas");
        }
    }

    /**
     * Metodo para mostrar la ventana de peliculas
     */
    private void ventanaPeliculas() {

        ArrayList<itfProperty> peliculas = objGestor.leerPeliculas();
        for (itfProperty pelicula : peliculas) {

            internalArticulo internalP = new internalArticulo(pelicula, objGestor, 1, id, recuentoH, recuentoV);
            listaInternalFrames.add(internalP);
            panel.add(internalP);
            internalP.setVisible(true);
            recuentoH++;
            if (recuentoH == 4 || recuentoH == 8 || recuentoH == 12) {
                recuentoV++;
                recuentoH = 0;
            }
        }
    }

    /**
     * Metodo para mostrar la ventana de peliculas ordenada por puntos
     */
    private void ventanaPeliculasPtos() {

        ArrayList<itfProperty> _peliculas = objGestor.listaPeliculasPuntos();
        for (itfProperty pelicula : _peliculas) {

            internalArticulo _internalP = new internalArticulo(pelicula, objGestor, 1, id, recuentoH, recuentoV);
            listaInternalFrames.add(_internalP);
            panel.add(_internalP);
            _internalP.setVisible(true);
            recuentoH++;
            if (recuentoH == 4 || recuentoH == 8 || recuentoH == 12) {
                recuentoV++;
                recuentoH = 0;
            }
        }
    }

    /**
     * Metodo para mostrar la ventana de videojuegos
     */
    private void ventanaVideojuegos() {

        ArrayList<itfProperty> videojuegos = objGestor.leerVideojuegos();
        for (itfProperty videojuego : videojuegos) {

            internalArticulo internalV = new internalArticulo(videojuego, objGestor, 2, id, recuentoH, recuentoV);
            listaInternalFrames.add(internalV);
            panel.add(internalV);
            internalV.setVisible(true);
            recuentoH++;
            if (recuentoH == 4 || recuentoH == 8 || recuentoH == 12) {
                recuentoV++;
                recuentoH = 0;
            }
        }
    }

    /**
     * Metodo para mostrar la ventana de videojuegos por puntos
     */
    private void ventanaVideojuegosPtos() {

        ArrayList<itfProperty> _videojuegos = objGestor.listaVideojuegosPuntos();
        for (itfProperty videojuego : _videojuegos) {

            internalArticulo _internalV = new internalArticulo(videojuego, objGestor, 2, id, recuentoH, recuentoV);
            listaInternalFrames.add(_internalV);
            panel.add(_internalV);
            _internalV.setVisible(true);
            recuentoH++;
            if (recuentoH == 4 || recuentoH == 8 || recuentoH == 12) {
                recuentoV++;
                recuentoH = 0;
            }
        }
    }

    /**
     * Metodo para mostrar la ventana de musica
     */
    private void ventanaMusica() {

        ArrayList<itfProperty> musicas = objGestor.leerMusica();
        for (itfProperty musica : musicas) {

            internalArticulo internalM = new internalArticulo(musica, objGestor, 3, id, recuentoH, recuentoV);
            listaInternalFrames.add(internalM);
            panel.add(internalM);
            internalM.setVisible(true);
            recuentoH++;
            if (recuentoH == 4 || recuentoH == 8 || recuentoH == 12) {
                recuentoV++;
                recuentoH = 0;
            }
        }
    }

    /**
     * Metodo para mostrar la ventana de musica ordenada por anio
     */
    private void ventanaMusicaAnio() {

        ArrayList<itfProperty> _musicas = objGestor.listaMusicaAnio();
        for (itfProperty musica : _musicas) {

            internalArticulo _internalM = new internalArticulo(musica, objGestor, 3, id, recuentoH, recuentoV);
            listaInternalFrames.add(_internalM);
            panel.add(_internalM);
            _internalM.setVisible(true);
            recuentoH++;
            if (recuentoH == 4 || recuentoH == 8 || recuentoH == 12) {
                recuentoV++;
                recuentoH = 0;
            }
        }
    }

    /**
     * Ventana para mostrar peliculas con suscripcion
     */
    private void ventanaAlquilerP() {

        ArrayList<itfProperty> peliculas = objGestor.leerPeliculas();
        for (itfProperty pelicula : peliculas) {

            internalAlquiler internalAlquilerP = new internalAlquiler(pelicula, objGestor, 1, id, recuentoH, recuentoV);
            listaInternalFrames.add(internalAlquilerP);
            panel.add(internalAlquilerP);
            internalAlquilerP.setVisible(true);
            recuentoH++;
            if (recuentoH == 4 || recuentoH == 8 || recuentoH == 12) {
                recuentoV++;
                recuentoH = 0;
            }
        }
    }

    /**
     * Venatana para mostrar peliculas alquiladas
     */
    private void ventanaAlquilerP_alquiler() {


        try {
            ArrayList<itfProperty> alquilerPeliculas = objGestor.leerAlquilerP();
            ArrayList<itfProperty> peliculas = objGestor.leerPeliculas();
            for (itfProperty pelicula : peliculas) {
                for (itfProperty alquilerP : alquilerPeliculas) {
                    if (codigo_aleatorio == (int)alquilerP.getPropertyA(ALQUILER_PELICULA_USUARIOS_CODIGO) &&
                            (int)alquilerP.getPropertyA(ALQUILER_PELICULA_ID_PROPIA) == (int)pelicula.getPropertyA(PELICULA_CODIGO_ID)) {

                        internalAlquiler internalAlquilerP = new internalAlquiler(pelicula, objGestor, 1, id, recuentoH, recuentoV);
                        listaInternalFrames.add(internalAlquilerP);
                        panel.add(internalAlquilerP);
                        internalAlquilerP.setVisible(true);
                        recuentoH++;
                        if (recuentoH == 4 || recuentoH == 8 || recuentoH == 12) {
                            recuentoV++;
                            recuentoH = 0;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Ventana apra mostrar videjuegos con suscripcion
     */
    private void ventanaAlquilerV() {

        ArrayList<itfProperty> videojuegos = objGestor.leerVideojuegos();
        for (itfProperty videojuego : videojuegos) {

            internalAlquiler internalAlquilerV = new internalAlquiler(videojuego, objGestor, 2, id, recuentoH, recuentoV);
            listaInternalFrames.add(internalAlquilerV);
            panel.add(internalAlquilerV);
            internalAlquilerV.setVisible(true);
            recuentoH++;
            if (recuentoH == 4 || recuentoH == 8 || recuentoH == 12) {
                recuentoV++;
                recuentoH = 0;
            }
        }
    }

    /**
     * Ventana para mostrar videojuegos alquilados
     */
    private void ventanaAlquilerV_alquiler() {

        try {
            ArrayList<itfProperty> alquilerVideojuegos = objGestor.leerAlquilerV();
            ArrayList<itfProperty> videojuegos = objGestor.leerVideojuegos();
            for (itfProperty videojuego : videojuegos) {
                for (itfProperty alquilerV : alquilerVideojuegos) {
                    if (codigo_aleatorio == (int)alquilerV.getPropertyA(ALQUILER_VIDEOJUEGO_USUARIOS_CODIGO) &&
                            (int)alquilerV.getPropertyA(ALQUILER_VIDEOJUEGO_ID_PROPIA) == (int)videojuego.getPropertyA(VIDEJUEGO_ID)) {

                        internalAlquiler internalAlquilerV = new internalAlquiler(videojuego, objGestor, 2, id, recuentoH, recuentoV);
                        listaInternalFrames.add(internalAlquilerV);
                        panel.add(internalAlquilerV);
                        internalAlquilerV.setVisible(true);
                        recuentoH++;
                        if (recuentoH == 4 || recuentoH == 8 || recuentoH == 12) {
                            recuentoV++;
                            recuentoH = 0;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Venatan para mostrar musica con suscripcion
     */
    private void ventanaAlquilerM() {

        ArrayList<itfProperty> musicas = objGestor.leerMusica();
        for (itfProperty musica : musicas) {

            internalAlquiler internalAlquilerM = new internalAlquiler(musica, objGestor, 3, id, recuentoH, recuentoV);
            listaInternalFrames.add(internalAlquilerM);
            panel.add(internalAlquilerM);
            internalAlquilerM.setVisible(true);
            recuentoH++;
            if (recuentoH == 4 || recuentoH == 8 || recuentoH == 12) {
                recuentoV++;
                recuentoH = 0;
            }
        }
    }

    /**
     * Venatan para mostrar musica alquiladas
     */
    private void ventanaAlquilerM_alquiler() {

        try {
            ArrayList<itfProperty> alquilerMusicas = objGestor.leerAlquilerM();
            ArrayList<itfProperty> cds = objGestor.leerMusica();

            for (itfProperty cd : cds) {
                for (itfProperty alquilerM : alquilerMusicas) {
                    System.out.println(alquilerM.getPropertyA(ALQUILER_MUSICA_ID_PROPIA));
                    if (codigo_aleatorio == (int)alquilerM.getPropertyA(ALQUILER_MUSICA_USUARIOS_CODIGO) &&
                            (int)alquilerM.getPropertyA(ALQUILER_MUSICA_ID_PROPIA) == (int)cd.getPropertyA(MUSICA_ID)) {

                        internalAlquiler internalAlquilerM = new internalAlquiler(cd, objGestor, 3, id, recuentoH, recuentoV);
                        listaInternalFrames.add(internalAlquilerM);
                        panel.add(internalAlquilerM);
                        internalAlquilerM.setVisible(true);
                        recuentoH++;
                        if (recuentoH == 4 || recuentoH == 8 || recuentoH == 12) {
                            recuentoV++;
                            recuentoH = 0;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para leer los datos del usuario logeado anteriormente
     *
     * @param id
     */
    private void leerDatos(String id) {
        ArrayList<itfProperty> lUsuarios = objGestor.leerUsuarios();
        for (itfProperty usuario : lUsuarios) {
            if (usuario.getPropertyU(USUARIO_IDENTIFICADOR).equals(id)) {
                costeTotal = (Double) usuario.getPropertyU(USUARIO_COSTE_TOTAL);
                codigo_aleatorio = (int) usuario.getPropertyU(USUARIO_CODIGO_ID);
            }
        }
    }

    /**
     * Metodo para la escucha de selecciones de botones
     *
     * @param e e
     */
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
