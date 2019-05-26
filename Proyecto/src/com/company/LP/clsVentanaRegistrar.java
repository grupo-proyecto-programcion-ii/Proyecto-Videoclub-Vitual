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

    private static final String AC_BOTON_REGISTRAR_USUARIO = "botonRegistrar";
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
    private JPasswordField textContrasena;
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

        btnValidar = new JButton(REGISTRARSE);
        btnValidar.setBounds(363, 613, 276, 47);
        btnValidar.setForeground(Color.WHITE);
        btnValidar.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        btnValidar.setBackground(Color.BLACK);
        btnValidar.setActionCommand(AC_BOTON_REGISTRAR_USUARIO);
        btnValidar.addActionListener(this);//importante para que escuche el boton en la ventana
        panelDeContenido.add(btnValidar);

        btnAtras = new JButton(ATRAS);
        btnAtras.setBounds(681, 613, 276, 47);
        btnAtras.setForeground(Color.WHITE);
        btnAtras.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        btnAtras.setBackground(Color.BLACK);
        btnAtras.setActionCommand(AC_BOTON_ATRAS);
        btnAtras.addActionListener(this);
        panelDeContenido.add(btnAtras);

        lblItrouceDatos = new JLabel(INTRODUCE_DATOS);
        lblItrouceDatos.setBounds(363, 80, 616, 33);
        lblItrouceDatos.setForeground(new Color(0, 0, 0));
        lblItrouceDatos.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 30));
        panelDeContenido.add(lblItrouceDatos);

        lblNombre = new JLabel(NOMBRE);
        lblNombre.setBounds(361, 191, 389, 22);
        lblNombre.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        panelDeContenido.add(lblNombre);

        lblApellidos = new JLabel(APELLIDOS);
        lblApellidos.setBounds(702, 191, 445, 22);
        lblApellidos.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        panelDeContenido.add(lblApellidos);

        lblUsuario = new JLabel(USUARIO);
        lblUsuario.setBounds(364, 313, 386, 22);
        lblUsuario.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        panelDeContenido.add(lblUsuario);

        lblPassword = new JLabel(CONTRASENA);
        lblPassword.setBounds(364, 365, 389, 22);
        lblPassword.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        panelDeContenido.add(lblPassword);

        lblNumeroTarjeta = new JLabel(NUMERO_T);
        lblNumeroTarjeta.setBounds(363, 438, 389, 22);
        lblNumeroTarjeta.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        panelDeContenido.add(lblNumeroTarjeta);

        lblCorreo = new JLabel(CORREO_E);
        lblCorreo.setBounds(363, 502, 389, 22);
        lblCorreo.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        panelDeContenido.add(lblCorreo);

        lblFechaNacimiento = new JLabel(FECHA_NACIMIENTO);
        lblFechaNacimiento.setBounds(758, 502, 389, 22);
        lblFechaNacimiento.setFont(new Font("BankGothic Lt BT", Font.PLAIN, 20));
        panelDeContenido.add(lblFechaNacimiento);

        textNombre = new JTextField();
        textNombre.setBounds(364, 224, 205, 20);
        textNombre.setForeground(Color.BLUE);
        textNombre.setBackground(Color.LIGHT_GRAY);
        panelDeContenido.add(textNombre);
        textNombre.setColumns(10);

        textApellidos = new JTextField();
        textApellidos.setBounds(702, 224, 277, 20);
        textApellidos.setForeground(Color.BLUE);
        textApellidos.setColumns(10);
        textApellidos.setBackground(Color.LIGHT_GRAY);
        panelDeContenido.add(textApellidos);

        textIdentificador = new JTextField();
        textIdentificador.setBounds(363, 340, 435, 20);
        textIdentificador.setForeground(Color.BLUE);
        textIdentificador.setColumns(10);
        textIdentificador.setBackground(Color.LIGHT_GRAY);
        panelDeContenido.add(textIdentificador);

        textContrasena = new JPasswordField();
        textContrasena.setBounds(363, 392, 435, 20);
        textContrasena.setForeground(Color.BLUE);
        textContrasena.setColumns(10);
        textContrasena.setBackground(Color.LIGHT_GRAY);
        panelDeContenido.add(textContrasena);

        textNumeroTarjeta = new JTextField();
        textNumeroTarjeta.setBounds(363, 471, 435, 20);
        textNumeroTarjeta.setForeground(Color.BLUE);
        textNumeroTarjeta.setColumns(10);
        textNumeroTarjeta.setBackground(Color.LIGHT_GRAY);
        panelDeContenido.add(textNumeroTarjeta);

        textCorreoElectronico = new JTextField();
        textCorreoElectronico.setBounds(363, 535, 389, 20);
        textCorreoElectronico.setForeground(Color.BLUE);
        textCorreoElectronico.setColumns(10);
        textCorreoElectronico.setBackground(Color.LIGHT_GRAY);
        panelDeContenido.add(textCorreoElectronico);

        textFechaNacimiento = new JTextField();
        textFechaNacimiento.setBounds(758, 535, 373, 20);
        textFechaNacimiento.setForeground(Color.BLUE);
        textFechaNacimiento.setColumns(10);
        textFechaNacimiento.setBackground(Color.LIGHT_GRAY);
        panelDeContenido.add(textFechaNacimiento);
    }

    //FALTA HASHET DE COMPROBACION DE USUARIOS

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {

            case AC_BOTON_REGISTRAR_USUARIO:

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
