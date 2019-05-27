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

import static com.company.COMUN.clsConstantes.USUARIO_CONTRASENA;
import static com.company.COMUN.clsConstantes.USUARIO_IDENTIFICADOR;

public class clsVentanaValidar extends JFrame implements ActionListener, WindowListener {

    private clsGestor objGestor;

    private final String INICIAR = "Iniciar";
    private final String ATRAS = "Atras";

    private static final String AC_BOTON_INICIAR = "botonIniciar";
    private static final String AC_BOTON_ATRAS2 = "botonAtras";

    private JPasswordField textoContrasena;
    private JTextField textoIdentificador;
    JButton btnIniciar;
    JButton btnAtras;

    public clsVentanaValidar(clsGestor _objGestor) {

        objGestor = _objGestor;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridBagLayout());

        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setForeground(Color.WHITE);
        panel.setBounds(0, 0, 1364, 749);
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblIntroduceElUsuario = new JLabel("Introduce el usuario:");
        lblIntroduceElUsuario.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        lblIntroduceElUsuario.setForeground(Color.YELLOW);
        lblIntroduceElUsuario.setBounds(428, 204, 366, 14);
        panel.add(lblIntroduceElUsuario);

        JLabel lblIntroduceLaContrasea = new JLabel("Introduce la contrasena:");
        lblIntroduceLaContrasea.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        lblIntroduceLaContrasea.setForeground(Color.YELLOW);
        lblIntroduceLaContrasea.setBounds(428, 306, 366, 14);
        panel.add(lblIntroduceLaContrasea);

        textoContrasena = new JPasswordField();
        textoContrasena.setBounds(428, 331, 366, 20);
        panel.add(textoContrasena);

        textoIdentificador = new JTextField();
        textoIdentificador.setBounds(428, 229, 366, 20);
        panel.add(textoIdentificador);
        textoIdentificador.setColumns(10);

        btnIniciar = new JButton(INICIAR);
        btnIniciar.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        btnIniciar.setForeground(Color.BLUE);
        btnIniciar.setBackground(Color.PINK);
        btnIniciar.setBounds(428, 376, 175, 33);
        btnIniciar.setActionCommand(AC_BOTON_INICIAR);
        btnIniciar.addActionListener(this);
        panel.add(btnIniciar);

        btnAtras = new JButton(ATRAS);
        btnAtras.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        btnAtras.setForeground(Color.BLUE);
        btnAtras.setBackground(Color.PINK);
        btnAtras.setBounds(628, 376, 166, 33);
        btnAtras.setActionCommand(AC_BOTON_ATRAS2);
        btnAtras.addActionListener(this);
        panel.add(btnAtras);

        JLabel lblImagenValidacion = new JLabel("Imagen validacion");
        lblImagenValidacion.setIcon(new ImageIcon(clsVentanaValidar.class.getResource("/com/company/COMUN/validacion.jpg")));
        lblImagenValidacion.setBounds(0, 0, 1364, 749);
        panel.add(lblImagenValidacion);

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
            case AC_BOTON_INICIAR:

                try {

                    boolean estado = false;
                    ArrayList<itfProperty> lUsuarios = objGestor.leerUsuarios();
                    for (itfProperty usuario : lUsuarios) {
                        if (textoContrasena.getText().equals(usuario.getPropertyU(USUARIO_CONTRASENA)) &&
                                textoIdentificador.getText().equals(usuario.getPropertyU(USUARIO_IDENTIFICADOR))) {
                            estado = true;
                        }
                    }
                    if (estado == true) {
                        clsVentanaMenu objVentanaMenu = new clsVentanaMenu(objGestor);
                        objVentanaMenu.setVisible(true);
                        objVentanaMenu.setExtendedState(6);
                    } else {
                        javax.swing.JOptionPane.showMessageDialog(this, "error, usuario o contrasena incrorrenta");
                        clsVentanaValidar objVentanaValidar = new clsVentanaValidar(objGestor);
                        objVentanaValidar.setVisible(true);
                        objVentanaValidar.setExtendedState(6);
                        break;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                this.dispose();
                break;

            case AC_BOTON_ATRAS2:
                clsVentanaInicio objVentanaInicio = new clsVentanaInicio(objGestor);
                objVentanaInicio.setVisible(true);
                objVentanaInicio.setExtendedState(6);
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
