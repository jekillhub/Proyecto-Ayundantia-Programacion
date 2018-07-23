package com.mycompany.proyectoayudantiaprogra.funciones;

public abstract class Inventario {

	protected int cantMax;

	protected abstract String verCantidad();

	protected abstract void agregar();

	protected abstract void quitar(int posicion);

	protected abstract String mostrarTodos();

	protected abstract String buscarRango(int rango);

}