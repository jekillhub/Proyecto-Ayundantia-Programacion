package com.mycompany.proyectoayudantiaprogra.funciones;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class InventarioLuchadores extends Inventario {

    private ArrayList<Luchador> luchadores;
    private ArrayList<Luchador> seleccionados;
    private int cantMax;
    
    public InventarioLuchadores() {

        this.luchadores = new ArrayList();
        this.seleccionados = new ArrayList();
        this.cantMax = 25;
        agregar();

    }

    @Override
    public String verCantidad() {

        return "Actualmente hay " + this.luchadores.size() + " luchadores en el inventario";

    }

    @Override
    public void agregar() {

        Luchador l1 = new Luchador();

        do {

            l1 = new Luchador();

        } while (comprobacionNombre(l1.getNombre()) == true);

        if (this.luchadores.size() < this.cantMax) {

            this.luchadores.add(l1);

        } else {

            System.out.println("Inventario lleno");

        }
    }

    public boolean comprobacionNombre(String nombre) {

        boolean existe = false;

        for (int i = 0; i < this.luchadores.size(); i++) {

            if (nombre.equals(this.luchadores.get(i).getNombre())) {

                existe = true;

            }

        }

        return existe;
    }

    public String buscarFaccion(String faccion) {

        StringBuilder luchadoresFaccion = new StringBuilder();
        luchadoresFaccion.append("Coincidencias con la busqueda" + "\n");

        for (int i = 0; i < this.luchadores.size(); i++) {

            if (this.luchadores.get(i).getFaccion().equals(faccion)) {

                luchadoresFaccion.append("El luchador numero " + (i + 1) + " corresponde a la busqueda" + "\n");

            }

        }

        return luchadoresFaccion.toString();

    }

    @Override
    protected String buscarRango(int rango) {

        StringBuilder luchadoresRango = new StringBuilder();
        luchadoresRango.append("Coincidencias con la busqueda" + "\n");

        for (int i = 0; i < this.luchadores.size(); i++) {

            if (this.luchadores.get(i).getRango() == rango) {

                luchadoresRango.append("El luchador numero " + (i + 1) + " corresponde a la busqueda" + "\n");

            }

        }

        return luchadoresRango.toString();
    }

    @Override
    public void quitar(int posicion) {

        this.luchadores.remove(posicion);

    }

    @Override
    public String mostrarTodos() {

        StringBuilder informacionTodos = new StringBuilder();
        informacionTodos.append("Luchadores Disponibles: " + "\n");

        for (int x = 0; x < this.luchadores.size(); x++) {

            informacionTodos.append((x + 1) + "." + "\n");
            informacionTodos.append(this.luchadores.get(x).infoCompleta() + "\n");

        }

        informacionTodos.append("");

        return informacionTodos.toString();

    }

    public String mostrarTodosSeleccionados() {

        StringBuilder informacionSeleccionados = new StringBuilder();
        informacionSeleccionados.append("Luchadores Seleccionados: " + "\n");

        for (int x = 0; x < this.seleccionados.size(); x++) {

            informacionSeleccionados.append((x + 1) + "." + "\n");
            informacionSeleccionados.append(this.seleccionados.get(x).infoCompleta() + "\n");

        }

        informacionSeleccionados.append("");

        return informacionSeleccionados.toString();

    }

    public String mostrarEspecifico(int posicion) {

        return this.luchadores.get(posicion).infoCompleta();

    }

    public void seleccionarLuchador() {

        Luchador l1 = new Luchador();

        for (int i = 0; i < 6; i++) {

            int seleccion = (ThreadLocalRandom.current().nextInt(0, luchadores.size() - 1));
            l1 = this.luchadores.get(seleccion);
            getSeleccionados().add(l1);
            quitar(seleccion);

        }

    }

    public ArrayList<Luchador> getLuchadores() {
        return luchadores;
    }

    public void setLuchadores(ArrayList<Luchador> luchadores) {
        this.luchadores = luchadores;
    }

    public ArrayList<Luchador> getSeleccionados() {
        return seleccionados;
    }

    public void setSeleccionados(ArrayList<Luchador> seleccionados) {
        this.seleccionados = seleccionados;
    }

}
