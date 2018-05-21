package proyectoayudantia;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Batalla {

    private int dañoDados;
    private ArrayList<Luchador> luchadores;
    private Monstruo monstruo;
    private int primerAtaque; // Si es 1 ataca el monstruo, si es 0 el luchador mas rapido.

    public Batalla(ArrayList<Luchador> luchadores, Monstruo monstruo) {
        calculoDañoDados();
        this.luchadores = luchadores;
        this.monstruo = monstruo;
        this.primerAtaque = -1;
    }

    private int dado6Caras() {
        return (ThreadLocalRandom.current().nextInt(1, 6 + 1));
    }

    private int dado8Caras() {
        return (ThreadLocalRandom.current().nextInt(1, 8 + 1));
    }

    private int restaDados() {
        return dado8Caras() - dado6Caras();
    }

    private void calculoDañoDados() {
        int restaDados = restaDados();

        if (restaDados > 1) {
            this.dañoDados = 2 * restaDados;
            IO.output("El daño será: " + this.dañoDados);
        }

        if (restaDados < 1) {
            this.dañoDados = Math.abs(restaDados);
            IO.output("El daño será: " + this.dañoDados);
        } else {
            this.dañoDados = 0;
            IO.output("No hay aumento del daño");
        }

    }

    private void evaluacionFacciones(Luchador l1, Monstruo m1) {

        if (l1.getFaccion() == "Agua" && m1.getFaccion() == "Fuego") {
            l1.setAtk(l1.getAtk() * 1.5);
            m1.setAtk(m1.getAtk() * 0.75);
        }
        if (l1.getFaccion() == "Fuego" && m1.getFaccion() == "Planta") {
            l1.setAtk(l1.getAtk() * 1.5);
            m1.setAtk(m1.getAtk() * 0.75);
        }
        if (l1.getFaccion() == "Planta" && m1.getFaccion() == "Agua") {
            l1.setAtk(l1.getAtk() * 1.5);
            m1.setAtk(m1.getAtk() * 0.75);
        }

        if (m1.getFaccion() == "Agua" && l1.getFaccion() == "Fuego") {
            m1.setAtk(m1.getAtk() * 1.5);
            l1.setAtk(l1.getAtk() * 0.75);
        }
        if (m1.getFaccion() == "Fuego" && l1.getFaccion() == "Planta") {
            m1.setAtk(m1.getAtk() * 1.5);
            l1.setAtk(l1.getAtk() * 0.75);
        }
        if (m1.getFaccion() == "Planta" && l1.getFaccion() == "Agua") {
            m1.setAtk(m1.getAtk() * 1.5);
            l1.setAtk(l1.getAtk() * 0.75);
        }

    }

    private double calculoDañoLM(Luchador atacante, Monstruo atacado) {
        double daño = atacado.getAtk() - atacado.getDef();
        if (daño < 0) {
            daño = 0;
        }
        return daño;
    }

    private double calculoDañoML(Monstruo atacante, Luchador atacado) {
        double daño = atacado.getAtk() - atacado.getDef();
        if (daño < 0) {
            daño = 0;
        }
        return daño;
    }

    private void ordenarAtaqueLuchadores() {
        int p, j;
        double auxSpd;
        Luchador auxLuch;

        for (p = 1; p < this.luchadores.size(); p++) {

            auxSpd = this.luchadores.get(p).getSpd();
            auxLuch = this.luchadores.get(p);
            j = p - 1;

            while ((j >= 0) && (auxSpd < this.luchadores.get(j).getSpd())) {
                this.luchadores.set(j + 1, this.luchadores.get(j));
                j--;
            }

            this.luchadores.set(j + 1, auxLuch);
        }
    }

    private void quitarMuertos() {
        for (int i = 0; i < this.luchadores.size(); i++) {
            if (this.luchadores.get(i).getHp() == 0) {
                luchadores.remove(i);
            }
        }
    }

    private void compararSpdLM() {
        if (this.monstruo.getSpd() > this.luchadores.get(this.luchadores.size() - 1).getSpd()) {
            this.primerAtaque = 1;
        } else {
            this.primerAtaque = 0;
        }
    }
}
