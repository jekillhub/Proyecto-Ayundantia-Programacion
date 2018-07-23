package com.mycompany.proyectoayudantiaprogra.funciones;

import java.util.ArrayList;

public class InventarioObjetos extends Inventario {

    private ArrayList<ObjetoEquipable> objetos;
    private int cantMax;

    public InventarioObjetos() {

        this.objetos = new ArrayList();
        this.cantMax = 10;

    }

    @Override
    protected String mostrarTodos() {

        StringBuilder informacionTodos = new StringBuilder();
        informacionTodos.append("Objetos Disponibles: " + "\n");

        for (int x = 0; x < this.objetos.size(); x++) {

            informacionTodos.append((x + 1) + "." + "\n");
            informacionTodos.append("Caracteristica: " + this.objetos.get(x).getCaracteristica() + "\n");
            informacionTodos.append("Rango: " + this.objetos.get(x).getRango() + "\n");
            informacionTodos.append("Mejora Total: " + this.objetos.get(x).getMejoraTotal() + "\n");
            informacionTodos.append("");

        }

        informacionTodos.append("");

        return informacionTodos.toString();

    }

    @Override
    protected String verCantidad() {

        return "Actualmente hay " + this.objetos.size() + " objetos en el inventario";

    }

    @Override
    protected void agregar() {

        ObjetoEquipable obj1 = new ObjetoEquipable();

        if (this.objetos.size() < this.cantMax) {
            this.objetos.add(obj1);
        } else {
            System.out.print("Inventario lleno");
        }

    }

    @Override
    protected void quitar(int posicion) {

        this.objetos.remove(posicion);

    }

    @Override
    protected String buscarRango(int rango) {

        StringBuilder informacionBusqueda = new StringBuilder();
        informacionBusqueda.append("Coincidencias con la busqueda: " + "\n");

        for (int i = 0; i < this.objetos.size(); i++) {

            if (this.objetos.get(i).getRango() == rango) {

                informacionBusqueda.append("El luchador numero " + (i + 1) + " corresponde a la busqueda" + "\n");

            }

        }

        informacionBusqueda.append("");

        return informacionBusqueda.toString();

    }

    public void equiparObjeto(Luchador l1, int posicion) {

        l1.equiparObjeto(objetos.get(posicion));
        this.objetos.remove(posicion);
        System.out.println("El objeto " + l1.getObjetoEq().getCaracteristica() + " fue equipado con exito");

    }

    public void desequiparObjeto(Luchador l1) {

        System.out.println("Actualmente está equipado: " + l1.getObjetoEq().getCaracteristica());
        this.objetos.add(l1.getObjetoEq());
        l1.desequiparObjeto();
        System.out.println("Objeto desequipado");

    }

    public ArrayList<ObjetoEquipable> getObjetos() {
        return objetos;
    }

    public void setObjetos(ArrayList<ObjetoEquipable> objetos) {
        this.objetos = objetos;
    }

}