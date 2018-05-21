package proyectoayudantia;

import java.util.ArrayList;

public class InventarioLuchadores extends Inventario {

    private ArrayList<Luchador> luchadores;
    private ArrayList<Luchador> seleccionados;
    private int cantMax;

    public InventarioLuchadores() {
        this.luchadores = new ArrayList();
        this.cantMax = 25;
        agregar();
    }

    public void verCantidad() {
        IO.output("Actualmente hay " + this.luchadores.size() + " luchadores en el inventario");
    }

    public void agregar() {
        Luchador l1 = new Luchador();

        if (this.luchadores.size() <= this.cantMax) {
            this.luchadores.add(l1);
        } else {
            IO.output("Inventario lleno");
        }
    }

    private void buscarFaccion(String faccion) {
        int i;

        for (i = 0; i < this.luchadores.size(); i++) {
            if (this.luchadores.get(i).getFaccion().equals(faccion)) {
                IO.output("El luchador numero " + (i + 1) + " corresponde a la busqueda");
            }
        }
    }

    private void buscarRango(int rango) {
        int i;

        for (i = 0; i < this.luchadores.size(); i++) {
            if (this.luchadores.get(i).getRango() == rango) {
                IO.output("El luchador numero " + (i + 1) + " corresponde a la busqueda");
            }
        }
    }

    public void filtrar() {
        int firstOpc = 0;

        do {
            IO.output("Seleccione alguna de las opciones siguientes");
            IO.output("1. Filtrar por Facción");
            IO.output("2. Filtrar por Rango");
            firstOpc = IO.leerInt();
        } while (firstOpc < 1 || firstOpc > 2);

        String entrada = "";

        switch (firstOpc) {
            case 1:
                IO.output("¿Que tipo de facción desea encontrar?");
                entrada = IO.leerString();
                buscarFaccion(entrada);
                break;
            case 2:
                IO.output("¿Que tipo de rango desea encontrar?");
                entrada = IO.leerString();
                buscarRango(IO.convertToInt(entrada));
                break;
        }
    }

    public void quitar() {
        int opc = 0;
        mostrarAll();

        do {
            IO.output("Seleccione el numero del luchador a eliminar");
            opc = IO.leerInt() - 1;

        } while (opc < 0 || opc > this.luchadores.size());

        this.luchadores.remove(opc);
    }

    public void mostrarAll() {
        IO.output("Luchadores Disponibles: ");
        for (int x = 0; x < this.luchadores.size(); x++) {
            IO.output((x + 1) + ".");
            IO.output("Nombre: " + this.luchadores.get(x).getNombre());
            IO.output("Facción: " + this.luchadores.get(x).getFaccion());
            IO.output("Rango: " + this.luchadores.get(x).getRango());
            IO.output("");
        }
        IO.output("");
    }

    public void mostrarSpecific() {
        int opc = 0;

        do {
            mostrarAll();
            IO.output("Seleccione el numero de algún luchador para mostrar toda su información");
            opc = IO.leerInt() - 1;

        } while (opc < 0 || opc > this.luchadores.size() - 1);

        this.luchadores.get(opc).showInfo();
    }

    //REVISAR METODOS
    public void seleccionarLuchador() {
        int opc = 0;

        do {
            mostrarAll();
            IO.output("Seleccione el numero de algún luchador para enviarlo a combatir");
            opc = IO.leerInt() - 1;

        } while (opc < 1 || opc > this.luchadores.size() + 1);

        Luchador l1 = this.luchadores.get(opc - 1);
        this.seleccionados.add(l1);
        seleccionarVarios();

    }

    private void seleccionarVarios() {
        int opcion = 0;

        if (seleccionados.size() < 6) {
            do {
                IO.output("¿Desea seleccionar otro luchador?");
                IO.output("1. Si");
                IO.output("2. No");
                opcion = IO.leerInt();
            } while (opcion < 1 || opcion > 2);

            if (opcion == 1) {
                seleccionarLuchador();
            }
        } else {
            IO.output("Ya has seleccionado el máximo de luchadores permitidos para enviar a combate");
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
