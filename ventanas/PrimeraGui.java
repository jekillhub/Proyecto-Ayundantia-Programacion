package com.mycompany.proyectoayundatiaprogra.ventanas;

import com.mycompany.proyectoayudantiaprogra.funciones.Batalla;
import com.mycompany.proyectoayudantiaprogra.funciones.InventarioLuchadores;
import com.mycompany.proyectoayudantiaprogra.funciones.Monstruo;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PrimeraGui extends JFrame implements ActionListener {

    protected JButton crearLuchadoresB;
    protected JPanel crearLuchadoresP;

    protected JButton verLuchadoresB;
    protected JButton verMonstruoB;
    protected JButton lucharB;
    protected JPanel botoneraP;

    protected JTextField textoTF;
    protected JPanel textoP;

    private InventarioLuchadores inventarioLuchadores;
    private Batalla batalla;
    private Monstruo monstruo;

    PrimeraGui(String title) {

        super(title);
        this.setLayout(new FlowLayout());

        this.verLuchadoresB = new JButton("Ver Luchadores");
        this.verMonstruoB = new JButton("Ver Monstruo");
        this.lucharB = new JButton("Luchar");
        this.botoneraP = new JPanel();

        this.textoTF = new JTextField();
        this.textoP = new JPanel();

        this.crearLuchadoresB = new JButton("Crear Luchadores");
        this.crearLuchadoresP = new JPanel();

        verLuchadoresB.addActionListener(this);
        verMonstruoB.addActionListener(this);
        lucharB.addActionListener(this);

        crearLuchadoresB.addActionListener(this);

        botoneraP.add(verLuchadoresB);
        botoneraP.add(verMonstruoB);
        botoneraP.add(lucharB);

        textoP.add(textoTF);

        crearLuchadoresP.add(crearLuchadoresB);

        this.add(botoneraP);
        this.add(textoP);
        this.add(crearLuchadoresP);

        inventarioLuchadores = new InventarioLuchadores();

        monstruo = new Monstruo();
        batalla = new Batalla(inventarioLuchadores.getSeleccionados(), monstruo);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == crearLuchadoresB) {

            for (int i = 0; i < 24; i++) {
                inventarioLuchadores.agregar();
            }
            for (int i = 0; i < 6; i++) {
                inventarioLuchadores.seleccionarLuchador();
            }

        }

        if (e.getSource() == verLuchadoresB) {

            if (this.inventarioLuchadores.getSeleccionados().isEmpty()) {

                textoTF.setText("");
                textoTF.setText("Primero clickee en Crear Luchadores");

            } else {

                textoTF.setText("");
                textoTF.setText(inventarioLuchadores.mostrarTodosSeleccionados());

            }

        }

        if (e.getSource() == verMonstruoB) {

            textoTF.setText("");
            textoTF.setText(monstruo.mostrarInformacion());

        }

        if (e.getSource() == lucharB) {

            setVisible(false);
            ResultadosGui resultados = new ResultadosGui("Resultados");
            resultados.textoTF.setText(batalla.pelear());
            resultados.setVisible(true);

        }

    }
}
