package com.company.LP;

import com.company.LN.clsGestor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class clsVentanaRegistrar extends JFrame implements ActionListener, WindowListener {

    private clsGestor objGestor;

    private static final String INTRODUCE_DATOS = "Introduce los datos para el registro";
    private static final String NOMBRE = "Nombre:";
    private static final String APELLIDOS = "Apellidos:";
    private static final String USUARIO = "Nombre de usuario o identificador:";
    private static final String CONTRASENA = "Password:";
    private static final String CORREO_E = "Correo electronico:";
    private static final String NUMERO_T = "Numero tarjeta de credito:";
    private static final String FECHA_NACIMIENTO = "Fecha de nacimiento (dd/MM/yyyy):";

    private static final String REGISTRARSE = "Registrarse";
    private static final String ATRAS = "Atras";

    private static final String AC_BOTON_REGISTRAR = "botonRegistrar";
    private static final String AC_BOTON_ATRAS = "botonAtras";

    private JPanel panelDeContenido;
    private JLabel lblItrouceDatos;
    private JLabel lblNombre;
    private JLabel lblApellidos;
    private JLabel lblUsuario;
    private JLabel lblPassword;
    private JLabel lblCorreo;
    private JLabel lblNumeroTarjeta;
    private JLabel lblFechaNacimiento;
    private JTextField textNombre;
    private JTextField textApellidos;
    private JTextField textIdentificador;
    private JTextField textContrasena;
    private JTextField textNumeroTarjeta;
    private JTextField textFechaNacimiento;
    private JTextField textCorreoElectronico;
    private JButton btnValidar;
    private JButton btnAtras;


    public clsVentanaRegistrar(clsGestor _objGestor) {

        objGestor = _objGestor;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920, 1080);
        getContentPane().setLayout(null);

        panelDeContenido = new JPanel();
        panelDeContenido.setBackground(new Color(255, 255, 255));
        panelDeContenido.setForeground(Color.BLACK);
        panelDeContenido.setBounds(0, 0, 1364, 749);
        getContentPane().add(panelDeContenido);
        panelDeContenido.setLayout(null);

        lblItrouceDatos = new JLabel(INTRODUCE_DATOS);
        lblItrouceDatos.setForeground(new Color(0, 0, 0));
        lblItrouceDatos.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 30));
        lblItrouceDatos.setBounds(364, 122, 707, 33);
        panelDeContenido.add(lblItrouceDatos);

        lblNombre = new JLabel(NOMBRE);
        lblNombre.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        lblNombre.setBounds(392, 204, 366, 14);
        panelDeContenido.add(lblNombre);

        lblApellidos = new JLabel(APELLIDOS);
        lblApellidos.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        lblApellidos.setBounds(702, 204, 366, 14);
        panelDeContenido.add(lblApellidos);

        lblUsuario = new JLabel(USUARIO);
        lblUsuario.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        lblUsuario.setBounds(392, 301, 455, 14);
        panelDeContenido.add(lblUsuario);

        lblPassword = new JLabel(CONTRASENA);
        lblPassword.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        lblPassword.setBounds(392, 362, 366, 14);
        panelDeContenido.add(lblPassword);

        lblCorreo = new JLabel(CORREO_E);
        lblCorreo.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        lblCorreo.setBounds(392, 548, 366, 14);
        panelDeContenido.add(lblCorreo);

        lblNumeroTarjeta = new JLabel(NUMERO_T);
        lblNumeroTarjeta.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        lblNumeroTarjeta.setBounds(392, 463, 366, 14);
        panelDeContenido.add(lblNumeroTarjeta);

        lblFechaNacimiento = new JLabel(FECHA_NACIMIENTO);
        lblFechaNacimiento.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        lblFechaNacimiento.setBounds(778, 548, 389, 14);
        panelDeContenido.add(lblFechaNacimiento);

        textNombre = new JTextField();
        textNombre.setForeground(Color.BLUE);
        textNombre.setBackground(Color.LIGHT_GRAY);
        textNombre.setBounds(392, 229, 252, 20);
        panelDeContenido.add(textNombre);
        textNombre.setColumns(10);

        textApellidos = new JTextField();
        textApellidos.setForeground(Color.BLUE);
        textApellidos.setColumns(10);
        textApellidos.setBackground(Color.LIGHT_GRAY);
        textApellidos.setBounds(712, 229, 252, 20);
        panelDeContenido.add(textApellidos);

        textIdentificador = new JTextField();
        textIdentificador.setForeground(Color.BLUE);
        textIdentificador.setColumns(10);
        textIdentificador.setBackground(Color.LIGHT_GRAY);
        textIdentificador.setBounds(392, 326, 434, 20);
        panelDeContenido.add(textIdentificador);

        textContrasena = new JTextField();
        textContrasena.setForeground(Color.BLUE);
        textContrasena.setColumns(10);
        textContrasena.setBackground(Color.LIGHT_GRAY);
        textContrasena.setBounds(392, 387, 434, 20);
        panelDeContenido.add(textContrasena);

        textNumeroTarjeta = new JTextField();
        textNumeroTarjeta.setForeground(Color.BLUE);
        textNumeroTarjeta.setColumns(10);
        textNumeroTarjeta.setBackground(Color.LIGHT_GRAY);
        textNumeroTarjeta.setBounds(392, 501, 415, 20);
        panelDeContenido.add(textNumeroTarjeta);

        textFechaNacimiento = new JTextField();
        textFechaNacimiento.setForeground(Color.BLUE);
        textFechaNacimiento.setColumns(10);
        textFechaNacimiento.setBackground(Color.LIGHT_GRAY);
        textFechaNacimiento.setBounds(778, 573, 225, 20);
        panelDeContenido.add(textFechaNacimiento);

        textCorreoElectronico = new JTextField();
        textCorreoElectronico.setForeground(Color.BLUE);
        textCorreoElectronico.setColumns(10);
        textCorreoElectronico.setBackground(Color.LIGHT_GRAY);
        textCorreoElectronico.setBounds(392, 573, 366, 20);
        panelDeContenido.add(textCorreoElectronico);

        btnValidar = new JButton(REGISTRARSE);
        btnValidar.setForeground(Color.WHITE);
        btnValidar.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        btnValidar.setBackground(Color.BLACK);
        btnValidar.setActionCommand(AC_BOTON_REGISTRAR);
        btnValidar.setBounds(392, 626, 281, 52);
        panelDeContenido.add(btnValidar);

        btnAtras = new JButton(ATRAS);
        btnAtras.setForeground(Color.WHITE);
        btnAtras.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        btnAtras.setBackground(Color.BLACK);
        btnAtras.setActionCommand(AC_BOTON_ATRAS);
        btnAtras.setBounds(752, 626, 281, 52);
        panelDeContenido.add(btnAtras);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case AC_BOTON_REGISTRAR:

                Date fechaNacimiento = null;
                try {
                    fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(textFechaNacimiento.getText());

                    Date fechaHoy = new Date();
                    objGestor.anadirUsuario(textIdentificador.getText(), textContrasena.getText(),
                            textNombre.getText(), textApellidos.getText(), textCorreoElectronico.getText(),
                            textNumeroTarjeta.getText(), fechaNacimiento, false, fechaHoy);


                    clsVentanaMenu objVentanaMenu = new clsVentanaMenu(objGestor);
                    //objVentanaMenu.setVisible(true);
                    //objVentanaMenu.setExtendedState(6);
                    this.dispose();

                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                break;
            case AC_BOTON_ATRAS:
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
