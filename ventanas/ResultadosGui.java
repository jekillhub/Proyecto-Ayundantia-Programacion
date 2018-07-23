package com.mycompany.proyectoayundatiaprogra.ventanas;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ResultadosGui extends JFrame {

    protected JTextField textoTF;
    protected JPanel textoP;

    ResultadosGui(String title) {

        super(title);
        this.setLayout(new FlowLayout());

        this.textoTF = new JTextField();
        this.textoP = new JPanel();

        textoP.add(textoTF);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

}
