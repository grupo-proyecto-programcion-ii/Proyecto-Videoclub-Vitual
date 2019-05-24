package com.company.LP;

import com.company.LN.clsGestor;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class clsPruebas extends JFrame {
    private JPanel contentPane;
    private Border frame = new Border() {
        /**
         * Paints the border for the specified component with the specified
         * position and size.
         *
         * @param c      the component for which this border is being painted
         * @param g      the paint graphics
         * @param x      the x position of the painted border
         * @param y      the y position of the painted border
         * @param width  the width of the painted border
         * @param height the height of the painted border
         */
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {

        }

        /**
         * Returns the insets of the border.
         *
         * @param c the component for which this border insets value applies
         * @return an {@code Insets} object containing the insets from top, left,
         * bottom and right of this {@code Border}
         */
        @Override
        public Insets getBorderInsets(Component c) {
            return null;
        }

        /**
         * Returns whether or not the border is opaque.  If the border
         * is opaque, it is responsible for filling in it's own
         * background when painting.
         *
         * @return true if this {@code Border} is opaque
         */
        @Override
        public boolean isBorderOpaque() {
            return false;
        }
    };

    public clsPruebas(clsGestor objprueba) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);


        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        //contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

        JButton btnNewButton_3 = new JButton("New button");
        btnNewButton_3.setAlignmentX(Component.BOTTOM_ALIGNMENT); //(center,right,left,top)
        //btnNewButton_3.setAlignmentY(Component.BOTTOM_ALIGNMENT); //(center,right,left,top)
        contentPane.add(btnNewButton_3);

        JButton btnNewButton = new JButton("New button");
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("New button");
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("New button");
        contentPane.add(btnNewButton_2);

        JButton btnNewButton_4 = new JButton("New button");
        contentPane.add(btnNewButton_4);



    }

}
