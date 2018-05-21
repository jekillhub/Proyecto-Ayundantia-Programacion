public abstract class Inventario {

	protected int cantMax;

	protected abstract void verCantidad();

	protected abstract void agregar();

	protected abstract void quitar();

	protected abstract void mostrarAll();

	protected abstract void buscarRango(int rango);

	protected abstract void filtrar();

}