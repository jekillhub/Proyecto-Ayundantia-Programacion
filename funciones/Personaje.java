package com.mycompany.proyectoayudantiaprogra.funciones;

public abstract class Personaje {

	protected String faccion;
	protected double hp;
	protected double atk;
	protected double def;
	protected double spd;

	protected abstract String elegirFaccion();

	protected abstract String mostrarInformacion();

}